package com.georgiana.certification.domain.skill;

import java.util.List;

import com.georgiana.certification.domain.UniqueId;

public interface Skills {
    List<Skill> findAllWithPattern(String trainingPattern);
    Skill getOrThrow(UniqueId skillId);
    Skill add(Skill training);
    boolean exists(String skillName);
}
