package com.chandra.mywebfluxsamples.controllers;

import com.chandra.mywebfluxsamples.model.Employee;
import com.chandra.mywebfluxsamples.model.Message;
import com.chandra.mywebfluxsamples.services.EmployeeRecordReader;
import com.chandra.mywebfluxsamples.services.MessagesFromOtherWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    private MessagesFromOtherWorld messagesFromOtherWorld;

    @Autowired
    private EmployeeRecordReader employeeRecordReader;

    @GetMapping(path = "sayHello")
    public Mono<String> sayHello() {
        return Mono.fromSupplier(() -> "Saying Hi");
    }

    @GetMapping(path = "getMessageFromMockIO")
    public Mono<Message> getMessageFromMockIO() {
        return messagesFromOtherWorld.getMessage();
    }

    @GetMapping(path = "streamEmployees")
    public Flux<Employee> streamEmployees() {
        return employeeRecordReader.streamReader("100 Records.csv");
    }

    @GetMapping(path = "bulkReadEmployees")
    public Mono<List<Employee>> bulkReadEmployees() {
        return employeeRecordReader.bulkReader("100 Records.csv");
    }
}
