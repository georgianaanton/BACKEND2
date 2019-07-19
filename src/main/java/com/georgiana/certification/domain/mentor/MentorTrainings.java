package com.georgiana.certification.domain.mentor;

import java.util.Set;

import com.georgiana.certification.domain.UniqueId;

public interface MentorTrainings {
    Set<MentorTraining> findByTrainingIds(Set<UniqueId> trainingIds);
    MentorTraining getOrThrow(UniqueId trainingId);
}
