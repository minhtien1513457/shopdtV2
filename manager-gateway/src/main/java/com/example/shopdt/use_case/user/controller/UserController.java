package com.example.shopdt.use_case.user.controller;

import lombok.RequiredArgsConstructor;
import com.okta.sdk.client.Client;
import com.okta.sdk.resource.user.User;
import com.okta.sdk.resource.user.UserBuilder;
import com.okta.sdk.resource.user.UserList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final Client client;

    @GetMapping("/users")
    public UserList getUsers() {
        return client.listUsers();
    }

    @GetMapping("/user")
    public UserList searchUserByEmail(@RequestParam String query) {
        return client.listUsers(query, null, null, null, null);
    }

    @PostMapping("/createUser")
    public User createUser() {
        char[] tempPassword = {'P','a','$','$','w','0','r','d'};
        User user = UserBuilder.instance()
                .setEmail("norman.lewis@email.com")
                .setFirstName("Norman")
                .setLastName("Lewis")
                .setPassword(tempPassword)
                .setActive(true)
                .buildAndCreate(client);
        return user;
    }
}
