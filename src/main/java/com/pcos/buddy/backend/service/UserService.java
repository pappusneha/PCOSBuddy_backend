package com.pcos.buddy.backend.service;

import com.pcos.buddy.backend.model.User;
import com.pcos.buddy.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserByEmail(String email){
        Optional<User> user = userRepository.findByEmail(email);
        // Handle the case where the user is not found
        // or throw new UserNotFoundException("User not found");
        return user.orElse(null);


    }

    public User updateUser(String email, User request) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(request.getName());
        user.setWeight(request.getWeight());
        user.setCycleLength(request.getCycleLength());
        user.setAge(request.getAge());
        user.setDiagnosisDate(request.getDiagnosisDate());

        return userRepository.save(user);
    }
}
