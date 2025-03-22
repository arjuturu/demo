package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.events.DemoProducerService;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @Autowired
    private DemoProducerService demoProducerService;

    @GetMapping("/hello/{input}")
    public ResponseEntity<String> echo(@PathVariable  String input) throws ExecutionException, InterruptedException {

        Employee employee = new Employee();
        employee.setId(input);
        employee.setName(input);
        demoService.saveEmp(employee);
        //update
        Employee existing = demoService.getEmployee("amar11");
        existing.setName("Anwika");
        demoService.saveEmp(existing);

        String s = demoProducerService.sendMessage("arjuturu-topic", employee.toString());
        return ResponseEntity.ok("Hello "+s);
    }
}
