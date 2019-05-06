package org.ncstudy.authentication.service;

import org.ncstudy.authentication.domain.Role;
import org.ncstudy.authentication.domain.User;
import org.ncstudy.authentication.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Service
@Transactional
public class UsersService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

// todo: set password encoder

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    public User addUser(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @PostConstruct
    private void setupDefaultUser() {
        if (userRepository.count() == 0) {
            User user = new User("adman",
                    "adman",
//                    passwordEncoder.encode("adman"),
                    Arrays.asList(Role.USER, Role.ADMIN));
            user.setActive(true);
            userRepository.save(user);
        }
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}