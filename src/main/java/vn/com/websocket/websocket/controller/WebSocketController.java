package vn.com.websocket.websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import vn.com.websocket.websocket.dto.ChatMessage;

@Controller
public class WebSocketController {
    @MessageMapping("/chat.sendMessage")//MessageMapping : khi một tin nhắn được gửi đến /chat.sendMessage thì sẽ gọi phương thức sendMessage
    @SendTo("/topic/publicChatRoom")// định nghĩa xem message gửi đến topic nào
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/publicChatRoom")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        // thêm mới user vào websocket
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
}
