package com.learning.api.service;

import com.learning.api.dto.UserRequestDTO;
import com.learning.api.entity.User;
import com.learning.api.exception.UserNotFoundException;
import com.learning.api.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User saveUser(UserRequestDTO userDTO) {

        User user = User.build(0, userDTO.getName(), userDTO.getEmail(), userDTO.getMobile(), userDTO.getGender(), userDTO.getAge(), userDTO.getNationality());

        return userRepository.save(user);
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public User getUserById(@Valid int id) throws UserNotFoundException {

    return userRepository.findByUserId(id);

//        User user =
//
//        if (user != null) return user;
//        else throw new UserNotFoundException("User not found with ID - " + id);
    }




}
