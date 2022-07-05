package com.haydikodlayalim.auth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;

import com.haydikodlayalim.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(UserDetailsService.class);

    private final UserService userService;

    public UserDetailsService(UserService userService) {
        this.userService = userService;
    }


    private Map<String, String> users = new HashMap<>();

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @PostConstruct
    public void init() {
        users.put("temelt", passwordEncoder.encode("123"));
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        logger.info("username = ", username);
        if (userService.checkExistence(username)) {
            logger.info("hello");
            logger.info("hello 2 = ", userService.getUser(username).getPassword().toString());
            return new User(username, passwordEncoder.encode(userService.getUser(username).getPassword().toString()), new ArrayList<>());
        }
/*        if (users.containsKey(username)) {
            logger.info("hello");
            return new User(username, users.get(username), new ArrayList<>());
        }*/

        throw new UsernameNotFoundException(username);
    }


}
