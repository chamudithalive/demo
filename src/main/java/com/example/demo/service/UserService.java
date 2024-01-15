package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public User updateUser(Long userId, User updatedUser) {
        Optional<User> existingUserOptional = userRepository.findById(userId);

        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            // Update the existing user with the new values
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setEmail(updatedUser.getEmail());

            // Save the updated user
            return userRepository.save(existingUser);
        } else {
            // Handle the case where the user with the given ID is not found
            return null;
        }
    }

    public boolean changePassword(Long userId, String newPassword) {
        Optional<User> userOptional = userRepository.findById(userId);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            // Change the user's password
            user.setPassword(newPassword);
            
            // Save the user with the updated password
            userRepository.save(user);
            
            return true;
        } else {
            // Handle the case where the user with the given ID is not found
            return false;
        }
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    public String getUsername(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.map(User::getUsername).orElse(null);
    }
}
