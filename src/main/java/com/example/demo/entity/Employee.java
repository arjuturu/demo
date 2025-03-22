package com.example.demo.entity;

import com.azure.spring.data.cosmos.core.mapping.Container;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Container(containerName = "employee")
@Getter
@Setter
public class Employee {

    @Id
    private String id;
    private String name;

}
