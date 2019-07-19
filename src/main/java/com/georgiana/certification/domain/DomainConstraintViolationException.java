package com.georgiana.certification.domain;

public class DomainConstraintViolationException extends RuntimeException {

    public DomainConstraintViolationException(String message) {
        super(message);
    }
}
