package com.chandra.mywebfluxsamples.services;

import com.chandra.mywebfluxsamples.model.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface EmployeeRecordReader {
    Mono<List<Employee>> bulkReader(String resourceName);

    Flux<Employee> streamReader(String resourceName);
}
