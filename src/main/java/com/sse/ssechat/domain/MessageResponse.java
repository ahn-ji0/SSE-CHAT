package com.sse.ssechat.domain;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MessageResponse {
    private final List<ChatMessage> messages;
    private final long count;
}
