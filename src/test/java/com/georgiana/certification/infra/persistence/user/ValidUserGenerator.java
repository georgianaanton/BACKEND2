package com.georgiana.certification.infra.persistence.user;

import com.georgiana.certification.domain.user.EmailAddress;
import com.georgiana.certification.domain.user.PhoneNumber;
import com.georgiana.certification.domain.user.User;

public class ValidUserGenerator {
    public static User gigiUser() {
        return new User(
                new EmailAddress("georgiana@test.com"), "Georgiana", "Anton",
                new PhoneNumber("0742979020")
        );
    }
}