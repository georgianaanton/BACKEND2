package com.georgiana.certification.infra.persistence.mentor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.georgiana.certification.domain.UniqueId;
import com.georgiana.certification.domain.mentor.Mentor;
import com.georgiana.certification.domain.mentor.Mentors;
import com.georgiana.certification.domain.user.EmailAddress;

@Repository
@Primary
public class SdjMentors implements Mentors {


    private final MentorsSdj sdj;

    public SdjMentors(MentorsSdj sdj) {
        this.sdj = sdj;
    }

    @Override
    public Mentor add(Mentor mentor) {
        return sdj.saveAndFlush(mentor);
    }

    @Override
    public Mentor getOrThrow(EmailAddress username) {
        return sdj.findById(username).orElseThrow(() -> new NoSuchElementException(username.toString()));
    }

    @Override
    public Set<Mentor> findAll() {
        return new HashSet<>(sdj.findAll());
    }

    @Override
    public List<Mentor> findAllMentorsTeachingTheSkills(Set<UniqueId> skillIds) {
        return new ArrayList<>(sdj.findByTrainingsSkillId(skillIds));
    }

    @Override
    public List<Mentor> findAll(List<EmailAddress> matchingMentorIds) {
        return sdj.findAllById(matchingMentorIds);
    }

    @Override
    public boolean exists(EmailAddress address) {
        return sdj.existsById(address);
    }
}
