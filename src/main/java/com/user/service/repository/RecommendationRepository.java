package com.user.service.repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;
import com.azure.spring.data.cosmos.repository.Query;
import com.user.service.entity.Mood;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendationRepository extends CosmosRepository<Mood, String> {


    @Query(value = "SELECT * FROM c WHERE c.id = @customerId")
    List<Mood> getAllById(String customerId);
}
