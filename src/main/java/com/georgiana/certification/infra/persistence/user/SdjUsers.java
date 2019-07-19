package com.georgiana.certification.infra.persistence.user;

import org.springframework.stereotype.Repository;

import com.georgiana.certification.domain.user.EmailAddress;
import com.georgiana.certification.domain.user.User;
import com.georgiana.certification.domain.user.Users;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

@Repository
public class SdjUsers implements Users {
    private final UsersSdj sdj;

    public SdjUsers(UsersSdj sdj) {
        this.sdj = sdj;
    }

    @Override
    public User add(User user) {
        return sdj.saveAndFlush(user);
    }

    @Override
    public Set<User> findAll() {
        return new HashSet<>(sdj.findAll());
    }

    @Override
    public Set<User> findAll(Set<EmailAddress> emails) {
        return new HashSet<>(sdj.findAllById(emails));
    }

    @Override
    public User getOrThrow(EmailAddress userId) {
        return sdj.findById(userId)
                .orElseThrow(
                        () -> new NoSuchElementException(userId.getValue())
                );
    }

    @Override
    public boolean exists(EmailAddress address) {
        return sdj.existsById(address);
    }
}
