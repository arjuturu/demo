package com.user.service.entity;


import com.azure.spring.data.cosmos.core.mapping.Container;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Container(containerName = "customer-profile")
@Getter
@Setter
public class CustomerProfile {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String phone;
    private int age;
    private int noOfHoursWalkPerDay;
    private int noOfHoursRunningPerDay;
    private int noOfHoursWorkOutPerDay;
    private int noOfHoursSwimPerDay;
    private String hasAnyHealthIssues;
    private String hasBp;
    private String hasDiabetic;


}
