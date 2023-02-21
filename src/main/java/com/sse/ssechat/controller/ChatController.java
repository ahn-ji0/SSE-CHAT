package com.sse.ssechat.controller;

import com.sse.ssechat.domain.ChatMessage;
import com.sse.ssechat.Response;
import com.sse.ssechat.domain.WriteMessageResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private List<ChatMessage> chatMessageList = new ArrayList<>();



    @PostMapping("/writeMessage")
    public Response writeMessage(){
        ChatMessage message = new ChatMessage("안지영", "안녕하세요");

        chatMessageList.add(message);

        return new Response("SUCCESS","메세지가 작성되었습니다.", new WriteMessageResponse(message.getId()));
    }

    @GetMapping("/messages")
    public Response getMessages(){
        return new Response("SUCCESS","성공", chatMessageList);
    }

}
