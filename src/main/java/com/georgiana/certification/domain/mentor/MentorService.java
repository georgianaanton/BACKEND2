package com.georgiana.certification.domain.mentor;

import com.georgiana.certification.domain.UniqueId;
import com.georgiana.certification.domain.mentor.calendar.MentorCalendar;
import com.georgiana.certification.domain.mentor.calendar.MentorCalendars;
import com.georgiana.certification.domain.mentor.calendar.MentorTrainingDetails;
import com.georgiana.certification.domain.skill.Skill;
import com.georgiana.certification.domain.skill.Skills;
import com.georgiana.certification.domain.user.EmailAddress;
import com.georgiana.certification.exposition.mentor.MentorEditCommand;
import com.georgiana.certification.exposition.mentor.TrainingAddCommand;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

import static java.lang.String.format;
import static java.util.stream.Collectors.toSet;

@Service
public class MentorService {
    private final Mentors mentors;
    private final MentorCalendars calendar;
    private final MentorTrainings trainings;
    private final Skills skills;

    public MentorService(Mentors mentors, MentorCalendars calendar, MentorTrainings trainings, Skills skills) {
        this.mentors = mentors;
        this.calendar = calendar;
        this.trainings = trainings;
        this.skills = skills;
    }

    public Mentor registerMentor(MentorEditCommand registrationCommand) {
        Mentor newMentor = registrationCommand.toNewMentor();
        if (mentors.exists(newMentor.getId())) {
            throw new IllegalStateException(format("Mentor with address <%s> already exists", newMentor.getId()));
        }
        return mentors.add(newMentor);
    }

    public Mentor updateMentor(MentorEditCommand editCommand) {
        Mentor newMentor = editCommand.toNewMentor();
        return mentors.add(newMentor);
    }

    public UniqueId registerTraining(TrainingAddCommand command) {
        MentorTraining newTraining = command.createMentorTraining();
        Mentor mentorTeachingTraining = mentors.getOrThrow(newTraining.getMentorId());
        MentorCalendar trainingCalendar = command.createTrainingCalendar(newTraining.getId());
        mentorTeachingTraining.addTraining(newTraining);
        calendar.add(trainingCalendar);
        mentors.add(mentorTeachingTraining);
        return newTraining.getId();
    }

    public Mentor removeTrainings(EmailAddress address, Set<UniqueId> trainingIds) {
        Mentor mentorToRemoveTrainingFrom = mentors.getOrThrow(address);
        mentorToRemoveTrainingFrom.removeTrainings(trainingIds);
        return mentors.add(mentorToRemoveTrainingFrom);
    }

    public Set<MentorTrainingDetails> viewTrainingsDetails(EmailAddress mentorAddress) {
        Mentor mentor = mentors.getOrThrow(mentorAddress);
        Set<MentorTraining> trainings = mentor.getTrainings();
        Set<UniqueId> trainingIds = trainings.stream().map(MentorTraining::getId).collect(toSet());
        Set<MentorCalendar> trainingsCalendar = calendar.findByTrainingIds(trainingIds);
        Set<MentorTrainingDetails> trainingDetails = mapMentorTrainingsDetails(mentor, trainings, trainingsCalendar);
        return trainingDetails;
    }

    public MentorTrainingDetails viewTrainingDetails(UniqueId trainingId) {
        MentorTraining training = trainings.getOrThrow(trainingId);
        Mentor mentor = mentors.getOrThrow(training.getMentorId());
        MentorCalendar trainingCalendar = calendar.findByTraining(trainingId);
        Skill skill = skills.getOrThrow(training.getSkillId());
        return new MentorTrainingDetails(mentor, training, trainingCalendar, skill);
    }

    private Set<MentorTrainingDetails> mapMentorTrainingsDetails(Mentor mentor, Set<MentorTraining> trainings, Set<MentorCalendar> trainingsCalendar) {
        Set<MentorTrainingDetails> trainingDetails = new HashSet<>();
        for (MentorTraining training: trainings) {
            MentorCalendar trainingCalendar = trainingsCalendar.stream()
                    .filter(c -> c.getTrainingId().equals(training.getId()))
                    .findFirst().orElseThrow(NoSuchElementException::new);
            Skill skill = skills.getOrThrow(training.getSkillId());
            trainingDetails.add(new MentorTrainingDetails(mentor, training, trainingCalendar, skill));
        }
        return trainingDetails;
    }
}
