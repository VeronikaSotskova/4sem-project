package ru.itis.semestrproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import ru.itis.semestrproject.handlers.WebSocketMessagesHandler;

@Configuration
public class WebSocketConfiguration implements WebSocketConfigurer {
    @Autowired
    private WebSocketMessagesHandler handler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(handler, "/chat");
    }
}
