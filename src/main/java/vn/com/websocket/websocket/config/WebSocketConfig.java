package vn.com.websocket.websocket.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import vn.com.websocket.websocket.intercepter.HttpHandshakeInterceptor;

@Configuration
@EnableWebSocketMessageBroker
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    private final HttpHandshakeInterceptor httpHandshakeInterceptor;


    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        /**đăng ký một endpoint /ws bật các tùy chọn SockJS để có thể sử dụng các phương tiện truyền thay thế nếu
         * websocket không khả dụng. máy khách SockJS sẽ cố gắng kết nối với websocket và sử dụng phương thức
         * truyền tốt nhất*/
        registry.addEndpoint("/ws").withSockJS().setInterceptors(httpHandshakeInterceptor);
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        /** định cấu hình message broker */
        registry.setApplicationDestinationPrefixes("/app");//định nghĩa prefix cho MessageMapping
        registry.enableSimpleBroker("/topic");
    }
}
