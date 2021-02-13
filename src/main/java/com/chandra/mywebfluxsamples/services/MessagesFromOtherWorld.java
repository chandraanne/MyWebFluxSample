package com.chandra.mywebfluxsamples.services;

import com.chandra.mywebfluxsamples.model.Message;
import reactor.core.publisher.Mono;

public interface MessagesFromOtherWorld {
    Mono<Message> getMessage();
}
