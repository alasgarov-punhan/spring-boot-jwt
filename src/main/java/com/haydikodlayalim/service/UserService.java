package com.haydikodlayalim.service;

import com.haydikodlayalim.model.User;
import com.haydikodlayalim.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author PUNHAN
 * @created 09/02/2022
 * @project spring-boot-jwt
 */

@Service
public class UserService {
    private Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean checkExistence(String userName) {
        return userRepository.existsByUserName(userName);
    }

    public User getUser(String userName) {
        return userRepository.findByUserName(userName);
    }

    public String returnUserPassword(String userName) {
        return getUser(userName).getPassword().toString();
    }


}
