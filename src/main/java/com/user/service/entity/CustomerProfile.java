package com.user.service.entity;


import com.azure.spring.data.cosmos.core.mapping.Container;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Container(containerName = "customer-profile")
@Getter
@Setter
public class CustomerProfile {

    @Id
    private String id;
    private CustomerName customerName;
    private String email;
    private String gender;
    private String phone;
    private BigDecimal height;
    private BigDecimal weight;
    private Long age;
    private FitnessData fitnessData;
    private String hasAnyHealthIssues;
    private String hasBp;
    private String hasDiabetic;


}
