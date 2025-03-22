package com.user.service.controller;

import com.user.service.entity.CustomerProfile;
import com.user.service.exception.ProfileCreationException;
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
        CustomerProfile profile = null;
        try {
            CustomerProfile customerProfileSaved = userService.saveCustomerProfile(customerProfile);
            return ResponseEntity.ok(customerProfileSaved);
        } catch (Exception e) {
            throw new ProfileCreationException("Exception Occurred while creating the customer profile");
        }
    }

    @GetMapping("customer-profile/{profileId}")
    public ResponseEntity<CustomerProfile> saveCustomerProfile(@PathVariable String profileId) {

        try {
            CustomerProfile customerProfile = userService.fetchCustomerProfile(profileId);
            return ResponseEntity.ok(customerProfile);
        } catch (Exception e) {
            throw new ProfileCreationException("Exception Occurred while retrieving the customer profile");
        }
    }
}
