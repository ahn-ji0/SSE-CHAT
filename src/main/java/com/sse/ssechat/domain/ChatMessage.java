package com.sse.ssechat.domain;

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
        this(ChatMessageIdGenerator.getNextId(), LocalDateTime.now(), authorName, content);
    }
}
