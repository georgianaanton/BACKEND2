package com.georgiana.certification.exposition.skill;

import com.georgiana.certification.domain.skill.Skill;
import com.georgiana.certification.domain.skill.Skills;
import com.georgiana.certification.exposition.CustomRequestMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static java.lang.String.format;

@CustomRequestMapping
public class SkillResource {
    private final Skills skills;

    public SkillResource(Skills skills) {
        this.skills = skills;
    }

    @GetMapping("/skills")
    public List<Skill> getSkills() {
        return skills.findAllWithPattern(null);
    }

    @PutMapping("/skills")
    public Skill addSkill(@RequestBody SkillCreateCommand skill) {
        String skillName = skill.skillName;
        if (skills.exists(skillName)) {
            throw new IllegalStateException(format("Skill %s already exists", skillName));
        }
        return skills.add(new Skill(skillName));
    }
}
