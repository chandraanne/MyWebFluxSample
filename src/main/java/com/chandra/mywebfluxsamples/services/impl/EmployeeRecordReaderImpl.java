package com.chandra.mywebfluxsamples.services.impl;

import com.chandra.mywebfluxsamples.model.Employee;
import com.chandra.mywebfluxsamples.services.EmployeeRecordReader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.BaseStream;

@Service
public class EmployeeRecordReaderImpl implements EmployeeRecordReader {
    @Override
    public Mono<List<Employee>> bulkReader(String resourceName) {
        return streamReader(resourceName).collectList();
    }

    @Override
    public Flux<Employee> streamReader(String resourceName) {
        return Flux.using(() -> Files.lines(Path.of(ClassLoader.getSystemResource(resourceName).toURI())),
                Flux::fromStream,
                BaseStream::close
        ).map(string -> string.split(","))
        .map(strArray -> new Employee(strArray[0], strArray[1], strArray[2], strArray[3], strArray[4], strArray[5]));
    }
}
