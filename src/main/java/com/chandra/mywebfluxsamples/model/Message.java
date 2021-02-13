package com.chandra.mywebfluxsamples.model;

import com.chandra.mywebfluxsamples.annotations.InjectHelloHuman;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;


public class Message {
    private String message;
    private String from;
    private LocalDate sentOn;
    private Boolean peaceMission;
    private String reflectionValue;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public Message(@JsonProperty("message") String message,
                   @JsonProperty("from") String from,
                   @JsonProperty("sentOn") LocalDate sentOn,
                   @JsonProperty("peaceMission") Boolean peaceMission,
                   @JsonProperty("reflectionValue") String reflectionValue) {
        this.message = message;
        this.from = from;
        this.sentOn = sentOn;
        this.peaceMission = peaceMission;
        this.reflectionValue = reflectionValue;
    }

    public String getMessage() {
        return message;
    }

    public String getFrom() {
        return from;
    }

    public LocalDate getSentOn() {
        return sentOn;
    }

    public Boolean getPeaceMission() {
        return peaceMission;
    }

    @InjectHelloHuman(messageString = "Hello Human, I am Vulcan")
    public String getReflectionValue() {
        return reflectionValue;
    }
}
