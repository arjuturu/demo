package com.example.demo.repository;

import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository;
import com.example.demo.entity.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends ReactiveCosmosRepository<Employee, String> {

}
