package com.user.service.repository;

import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository;
import com.user.service.entity.CustomerProfile;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ReactiveCosmosRepository<CustomerProfile, String> {
}
