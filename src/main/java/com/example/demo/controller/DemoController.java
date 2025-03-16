package com.example.demo.controller;

import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/hello/{input}")
    public ResponseEntity<String> echo(@PathVariable  String input) {

//        Employee employee = new Employee();
//        employee.setId(input);
//        employee.setName(input);
//        demoService.saveEmp(employee);
        return ResponseEntity.ok("Hello "+input);
    }
}
