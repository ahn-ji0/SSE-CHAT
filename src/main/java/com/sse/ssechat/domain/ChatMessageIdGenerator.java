package com.sse.ssechat.domain;

public class ChatMessageIdGenerator {

    private static long id = 0;

    public static long getNextId() {
        return ++id;
    }
}
