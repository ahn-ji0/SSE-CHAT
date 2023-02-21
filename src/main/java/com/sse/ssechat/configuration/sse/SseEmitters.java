package com.sse.ssechat.configuration.sse;

import com.sse.ssechat.utils.MapUtils;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.catalina.connector.ClientAbortException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Component
public class SseEmitters {
    private final List<SseEmitter> emitters = new CopyOnWriteArrayList<>();

    public SseEmitter add(SseEmitter emitter) {
        this.emitters.add(emitter);
        emitter.onCompletion(() -> {
            this.emitters.remove(emitter);
        });
        emitter.onTimeout(() -> {
            emitter.complete();
        });

        return emitter;
    }

    public void notify(String eventName) {
        notify(eventName, MapUtils.mapOf());
    }

    public void notify(String eventName, Map<String, Object> data) {
        emitters.forEach(emitter -> {
            try {
                emitter.send(
                    SseEmitter.event()
                              .name(eventName)
                              .data(data)
                            );
            } catch (ClientAbortException e) {

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
