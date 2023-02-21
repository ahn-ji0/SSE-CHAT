package com.sse.ssechat.controller;

import com.sse.ssechat.domain.ChatMessage;
import com.sse.ssechat.Response;
import com.sse.ssechat.domain.MessageRequest;
import com.sse.ssechat.domain.MessageResponse;
import com.sse.ssechat.domain.WriteMessageRequest;
import com.sse.ssechat.domain.WriteMessageResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/chat")
public class ChatController {

    private List<ChatMessage> chatMessageList = new ArrayList<>();

    @GetMapping("/room")
    public String showRoom(){
        return "chat/room";
    }

    @PostMapping("/writeMessage")
    @ResponseBody
    public Response writeMessage(@RequestBody WriteMessageRequest writeMessageRequest){
        ChatMessage message = new ChatMessage(writeMessageRequest.authorName(), writeMessageRequest.content());

        chatMessageList.add(message);

        return new Response("SUCCESS","메세지가 작성되었습니다.", new WriteMessageResponse(message.getId()));
    }

    @GetMapping("/messages")
    @ResponseBody
    public Response getMessages(MessageRequest messageRequest){
        int index;
        if(messageRequest.fromId() < 1){
            index = 0;
        }
        else if(messageRequest.fromId() > chatMessageList.size()) {
            index = chatMessageList.size();
        }
        else{
            index = (int)messageRequest.fromId() - 1;
        }
        List<ChatMessage> subList = chatMessageList.subList(index, chatMessageList.size());
        return new Response("SUCCESS","성공", new MessageResponse(subList, subList.size()));

    }

}
