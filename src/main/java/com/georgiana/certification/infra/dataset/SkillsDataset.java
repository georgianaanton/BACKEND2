package com.georgiana.certification.infra.dataset;

import com.georgiana.certification.domain.UniqueId;
import com.georgiana.certification.domain.skill.Skill;

import java.util.List;

import static java.util.Arrays.asList;

public class SkillsDataset {
    public final static Skill JAVA = new Skill(new UniqueId(), "Java");
    public final static Skill MICROSERVICES = new Skill(new UniqueId(), "Microservices");
    public final static Skill MONGODB = new Skill(new UniqueId(), "MongoDB");
    public final static Skill ANGULAR = new Skill(new UniqueId(), "Angular");
    public final static Skill KOTLIN = new Skill(new UniqueId(), "Kotlin");

    public static List<Skill> getAllSkills() {
        return asList(JAVA, MICROSERVICES, MONGODB, ANGULAR, KOTLIN);
    }
}
