package com.georgiana.certification.exposition.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.georgiana.certification.domain.user.EmailAddress;
import com.georgiana.certification.domain.user.PhoneNumber;
import com.georgiana.certification.domain.user.User;

import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
public class UserDto {
    @NotNull
    @JsonProperty
    public String username;
    @NotBlank
    @JsonProperty
    public String firstName;
    @NotBlank
    @JsonProperty
    public String lastName;
    @NotNull
    @JsonProperty
    public String phoneNumber;

    public User toUser() {
        return new User(new EmailAddress(username), firstName, lastName, new PhoneNumber(phoneNumber));
    }
}
