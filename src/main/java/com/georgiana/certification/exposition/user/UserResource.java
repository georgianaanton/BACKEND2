package com.georgiana.certification.exposition.user;

import com.georgiana.certification.domain.user.EmailAddress;
import com.georgiana.certification.domain.user.RegisterUser;
import com.georgiana.certification.domain.user.User;
import com.georgiana.certification.domain.user.Users;
import com.georgiana.certification.exposition.CustomRequestMapping;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CustomRequestMapping
public class UserResource {

    private final RegisterUser registerUser;
    private final Users users;

    public UserResource(RegisterUser registerUser, Users users) {
        this.registerUser = registerUser;
        this.users = users;
    }
    @PostMapping(value = "/users")
    public EmailAddress registerUser(@Valid @RequestBody UserDto newUser) {
        return registerUser.registerUser(newUser.toUser()).getId();
    }

    @PutMapping(value = "/users")
    public EmailAddress updateUser(@Valid @RequestBody UserDto newUser) {
        return users.add(newUser.toUser()).getId();
    }

    @GetMapping(value = "/users/{emailAddress}")
    public User getUser(@PathVariable String emailAddress) {
        return users.getOrThrow(new EmailAddress(emailAddress));
    }
}
