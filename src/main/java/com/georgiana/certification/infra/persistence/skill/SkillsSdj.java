package com.georgiana.certification.infra.persistence.skill;

import com.georgiana.certification.domain.UniqueId;
import com.georgiana.certification.domain.skill.Skill;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface SkillsSdj extends JpaRepository<Skill, UniqueId> {

    Set<Skill> findSkillBySkillNameContainsIgnoreCase(String pattern);

    boolean existsBySkillNameEqualsIgnoreCase(String skillName);
}
