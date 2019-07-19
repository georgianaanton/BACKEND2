package com.georgiana.certification.infra.persistence.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.georgiana.certification.domain.user.EmailAddress;
import com.georgiana.certification.domain.user.User;

public interface UsersSdj extends JpaRepository<User, EmailAddress> {
}
