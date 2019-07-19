package com.georgiana.certification.domain.user;

import com.georgiana.certification.domain.DomainConstraintViolationException;
import com.georgiana.certification.domain.user.EmailAddress;

import org.junit.Test;

public class EmailAddressTest {
    @Test(expected = DomainConstraintViolationException.class)
    public void should_not_allow_other_formats() {
        new EmailAddress("cucu");
    }

    @Test
    public void should_allow_correct_format() {
        new EmailAddress("cucu@cucu");
    }

    @Test(expected = DomainConstraintViolationException.class)
    public void should_not_allow_null() {
        new EmailAddress(null);
    }
    @Test(expected = DomainConstraintViolationException.class)
    public void should_not_allow_empty_string() {
        new EmailAddress("");
    }
}