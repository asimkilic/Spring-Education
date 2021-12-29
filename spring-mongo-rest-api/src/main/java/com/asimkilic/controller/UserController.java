package com.asimkilic.controller;

import com.asimkilic.entity.User;
import com.asimkilic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
@RequestMapping("/users")
public class UserController {

    @Autowired
    private  UserRepository userRepository;

    @PostConstruct
    public void init() {
        User user = new User();
        user.setFirstName("Asım");
        user.setLastName("Kılıç");
        userRepository.save(user);
    }



    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        user = userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> userList = userRepository.findAll();
        return ResponseEntity.ok(userList);
    }
}
