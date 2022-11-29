package vn.com.websocket.websocket.intercepter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Component
public class HttpHandshakeInterceptor implements HandshakeInterceptor {
    private final Logger logger = LogManager.getLogger(HttpHandshakeInterceptor.class);

    //khi client gửi một request đến server, server sẽ kiểm tra request nếu qua thì server sẽ gửi về success và client với
    //server kết nối bằng nguyên lý handshake

    @Override
    //được gọi trước khi client kết nối với server
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        logger.info("Call beforeHandshake");

        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
            HttpSession session = servletRequest.getServletRequest().getSession();
            attributes.put("sessionId", session.getId());
        }
        return true;
    }

    @Override
    //được gọi sau khi client kết nối đến server
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {
        logger.info("Call afterHandshake");
    }
}
