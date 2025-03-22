package com.user.service.service;

import com.user.service.entity.CustomerProfile;
import com.user.service.exception.ProfileCreationException;
import com.user.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public CustomerProfile saveCustomerProfile(CustomerProfile customerProfile) {
        CustomerProfile customerProfileData;
        try {
            customerProfile.setId(generateID());
            customerProfileData = userRepository.save(customerProfile);
            return customerProfileData;
        } catch (Exception e) {
            throw new ProfileCreationException("Exception Occurred while creating the customer profile");
        }
    }

    private String generateID() {
        long count = userRepository.count() + 1;
        return "MLFINM" +
                LocalDate.now().getDayOfWeek().getValue() +
                LocalDate.now().getDayOfMonth() +
                LocalDate.now().getYear() +
                count;
    }

    public CustomerProfile fetchCustomerProfile(String profileId) {
        try {
            Optional<CustomerProfile> customerProfile = userRepository.findById(profileId);
            if (customerProfile.isPresent()) {
                return customerProfile.get();
            }
        } catch (Exception e) {
            throw new ProfileCreationException("Exception Occurred while retrieving the customer profile");
        }
        return null;
    }
}
