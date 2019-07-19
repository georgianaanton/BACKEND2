package com.georgiana.certification.infra.persistence.mentor;

import com.georgiana.certification.domain.UniqueId;
import com.georgiana.certification.domain.mentor.MentorTraining;
import com.georgiana.certification.domain.mentor.MentorTrainings;

import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

@Repository
public class SdjMentorTrainings implements MentorTrainings {
    private final MentorTrainingsSdj sdj;

    public SdjMentorTrainings(MentorTrainingsSdj sdj) {
        this.sdj = sdj;
    }

    @Override
    public Set<MentorTraining> findByTrainingIds(Set<UniqueId> trainingIds) {
        return new HashSet<>(sdj.findAllById(trainingIds));
    }

    @Override
    public MentorTraining getOrThrow(UniqueId trainingId) {
        return sdj.findById(trainingId).orElseThrow(NoSuchElementException::new);
    }
}
