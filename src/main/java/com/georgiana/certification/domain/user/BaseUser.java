package com.georgiana.certification.domain.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.georgiana.certification.domain.BaseEntity;

@MappedSuperclass
@NoArgsConstructor
@Getter
public class BaseUser extends BaseEntity<BaseUser, EmailAddress> {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotNull
    private PhoneNumber phoneNumber;

    protected BaseUser(EmailAddress username) {
        super(BaseUser.class, username);
    }


    public BaseUser(
            @NotNull EmailAddress id, @NotBlank String firstName,
            @NotBlank String lastName, @NotNull PhoneNumber phoneNumber
    ) {
        super(BaseUser.class, id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
