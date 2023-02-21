package com.sse.ssechat.domain;

import java.util.List;

public record MessageResponse(List<ChatMessage> messages, long count) {

}
