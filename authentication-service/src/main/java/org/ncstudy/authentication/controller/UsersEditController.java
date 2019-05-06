package org.ncstudy.authentication.controller;

import org.ncstudy.authentication.domain.User;
import org.ncstudy.authentication.repo.UserRepository;
import org.ncstudy.authentication.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/usr")
public class UsersEditController {

    @Autowired
    UsersService usersService;
    @Autowired
    UserRepository userRepository;

    @PostMapping("/add")
    public void add(User user){
        usersService.addUser(user);
    }

    @PostMapping("/delete")
    public void delete(String username){
        userRepository.deleteUserByUsername(username);
    }

}
