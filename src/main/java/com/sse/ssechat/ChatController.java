package com.sse.ssechat;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @PostMapping("/writeMessage")
    public Response writeMessage(){
        ChatMessage message = new ChatMessage("안지영", "안녕하세요");

        return new Response("SUCCESS","메세지가 작성되었습니다.", message);
    }

}
