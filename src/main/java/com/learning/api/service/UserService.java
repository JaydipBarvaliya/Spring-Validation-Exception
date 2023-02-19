package com.learning.api.service;

import com.learning.api.dto.UserRequestDTO;
import com.learning.api.entity.User;
import com.learning.api.exception.UserNotFoundException;
import com.learning.api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User saveUser(UserRequestDTO userRequest) {

        User user = User.build(0, userRequest.getName(), userRequest.getEmail(), userRequest.getMobile(), userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());

        return userRepository.save(user);
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public User getUserById(int id) throws UserNotFoundException {
        User user = userRepository.findByUserId(id);

        if (user != null) return user;
        else throw new UserNotFoundException("User not found with ID - " + id);
    }


}
