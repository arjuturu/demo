package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @Autowired
    private DemoRepository demoRepository;

    public Employee getEmployee(String id) {
        return demoRepository.findById(id).get();
    }

    public Employee saveEmp(Employee emp) {
        return demoRepository.save(emp);
    }
}
