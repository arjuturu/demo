package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DemoService {

    @Autowired
    private DemoRepository demoRepository;

    public Employee saveEmp(Employee emp) {
        return demoRepository.save(emp).block();
    }

    public Employee getEmployee(String id) {
        Mono<Employee> byId = demoRepository.findById("1");
        return byId.block();
    }
}
