package com.sse.ssechat.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class WriteMessageRequest{
    private final String authorName;
    private final String content;
}
