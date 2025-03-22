package com.user.service.service;

import com.user.service.entity.CustomerProfile;
import com.user.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public CustomerProfile saveCustomerProfile(CustomerProfile customerProfile) {
        return userRepository.save(customerProfile).block();
    }

    public CustomerProfile fetchCustomerProfile(String profileId) {

        return userRepository.findById(profileId).block();
    }
}
