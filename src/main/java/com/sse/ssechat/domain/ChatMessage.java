package com.sse.ssechat.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ChatMessage {
    private long id;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createdAt;
    private String authorName;
    private String content;

    public ChatMessage(String authorName, String content){
        this(ChatMessageIdGenerator.getNextId(), LocalDateTime.now(), authorName, content);
    }
}
