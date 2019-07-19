package com.georgiana.certification.exposition.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.georgiana.certification.domain.user.User;

import lombok.NoArgsConstructor;
import org.springframework.boot.jackson.JsonComponent;

@JsonComponent
@NoArgsConstructor
public class UserRegistrationCommand  {
    @JsonProperty
    public User newUser;
    @JsonProperty
    public String password;

    public UserRegistrationCommand(User newUser, String password) {
        this.newUser = newUser;
        this.password = password;
    }
}
