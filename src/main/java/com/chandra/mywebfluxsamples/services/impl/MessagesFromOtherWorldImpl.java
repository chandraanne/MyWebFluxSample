package com.chandra.mywebfluxsamples.services.impl;

import com.chandra.mywebfluxsamples.annotations.InjectHelloHuman;
import com.chandra.mywebfluxsamples.model.Message;
import com.chandra.mywebfluxsamples.services.MessagesFromOtherWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

@Service
public class MessagesFromOtherWorldImpl implements MessagesFromOtherWorld {
    private WebClient webClient;

    @Autowired
    public MessagesFromOtherWorldImpl(@Qualifier("WebClient") WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Mono<Message> getMessage() {
        return webClient
                .get()
                .header(
                        HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .acceptCharset(StandardCharsets.UTF_8)
                .exchangeToMono(clientResponse -> clientResponse.bodyToMono(Message.class).map(message -> readAnnotations(message)));
    }

    private Message readAnnotations(Message message) {
        String messageString = null;
        try {
            InjectHelloHuman reflectionValue = Message.class.getMethod("getReflectionValue").getAnnotation(InjectHelloHuman.class);

            messageString = reflectionValue.messageString();
        } catch (NoSuchMethodException exception) {
            exception.printStackTrace();
        }

        return new Message(message.getMessage(), message.getFrom(), message.getSentOn(), message.getPeaceMission(), messageString);
    }
}
