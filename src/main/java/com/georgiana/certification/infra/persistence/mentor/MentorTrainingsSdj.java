package com.georgiana.certification.infra.persistence.mentor;

import com.georgiana.certification.domain.UniqueId;
import com.georgiana.certification.domain.mentor.MentorTraining;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorTrainingsSdj extends JpaRepository<MentorTraining, UniqueId> {
}
