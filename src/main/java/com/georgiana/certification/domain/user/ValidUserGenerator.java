package com.georgiana.certification.domain.user;

public class ValidUserGenerator {

    public static final User GEORGIANA = new User(
            new EmailAddress("georgiana@georgiana.com"), "Georgiana", "Anton",
            new PhoneNumber("1234567890")
    );
}
