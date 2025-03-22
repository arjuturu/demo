package com.user.service.controller;

import com.user.service.entity.CustomerProfile;
import com.user.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/customer-profile")
    public ResponseEntity<CustomerProfile> saveCustomerProfile(@RequestBody CustomerProfile customerProfile) {

        CustomerProfile customerProfileSaved = userService.saveCustomerProfile(customerProfile);

        return ResponseEntity.ok(customerProfileSaved);
    }

    @GetMapping("/customer-profile/{profileId}")
    public ResponseEntity<CustomerProfile> saveCustomerProfile(@PathVariable String profileId) {

        CustomerProfile customerProfileSaved = userService.fetchCustomerProfile(profileId);

        return ResponseEntity.ok(customerProfileSaved);
    }

}
