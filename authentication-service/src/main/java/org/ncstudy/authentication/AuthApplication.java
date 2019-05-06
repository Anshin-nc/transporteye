package org.ncstudy.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AuthApplication {

    @RequestMapping("/")
    public String user() {
        return "hi";
    }

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }
}
