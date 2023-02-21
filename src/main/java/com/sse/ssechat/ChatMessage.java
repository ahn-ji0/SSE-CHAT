package com.sse.ssechat;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ChatMessage {
    private long id;
    private LocalDateTime createdAt;
    private String authorName;
    private String content;

    public ChatMessage(String authorName, String content){
        this(1, LocalDateTime.now(), authorName, content);
    }
}
