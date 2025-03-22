package com.user.service.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.user.service.entity.CustomerProfile;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CosmosRepository<CustomerProfile, String> {
}
