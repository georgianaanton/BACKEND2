package com.georgiana.certification.infra.persistence.mentor;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.georgiana.certification.domain.UniqueId;
import com.georgiana.certification.domain.mentor.Mentor;
import com.georgiana.certification.domain.user.EmailAddress;

@Repository
public interface MentorsSdj extends JpaRepository<Mentor, EmailAddress> {
    @Query("select m from Mentor m  left join fetch m.trainings as t where t.skillId in :skillIds")
    Set<Mentor> findByTrainingsSkillId(@Param("skillIds") Set<UniqueId> skillIds);
}
