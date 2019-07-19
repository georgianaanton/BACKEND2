package com.georgiana.certification.infra.persistence.mentor;

import static java.time.LocalDateTime.now;
import static java.util.Collections.singleton;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.georgiana.certification.domain.UniqueId;
import com.georgiana.certification.domain.mentor.Mentor;
import com.georgiana.certification.domain.mentor.MentorService;
import com.georgiana.certification.domain.mentor.MentorTraining;
import com.georgiana.certification.domain.user.EmailAddress;
import com.georgiana.certification.domain.user.PhoneNumber;
import com.georgiana.certification.exposition.mentor.MentorEditCommand;
import com.georgiana.certification.exposition.mentor.TrainingAddCommand;
import com.georgiana.certification.infra.dataset.MentorDataSet;
import com.georgiana.certification.infra.dataset.SkillsDataset;
import com.georgiana.certification.infra.persistence.IntegrationTestWithDataset;

@Ignore
public class MentorServiceLocalIT extends IntegrationTestWithDataset {

    @Autowired
    private MentorsSdj sdj;
    
    @Autowired
    private MentorService sut;

    @Test
    public void registerMentor() {
        MentorEditCommand command = someRegistrationCommand();
        Mentor expected = getExpectedFromRegistrationCommand(command);
        Mentor actual = sut.registerMentor(command);
        assertThat(actual).isEqualToComparingFieldByFieldRecursively(expected);
    }

    @Test
    public void registerTraining() {
        EmailAddress linusId = MentorDataSet.THOR.getId();
        MentorTraining training = someNewTraining(linusId);
        TrainingAddCommand command = new TrainingAddCommand(
                training.getFacilitiesDesc(), training.getSkillId(), training.getPrerequisitesDesc(),
                training.getNoOfTrainingsDone(), training.getMentorId(), training.getFee(), now().minusDays(1L), now()
        );
        Mentor linus = sdj.findById(linusId).orElseThrow(NoSuchElementException::new);
        int numberOfTrainingsBeforeNewTraining = linus.getTrainings().size();
        Set<MentorTraining> trainingsBefore = linus.getTrainings();
        sut.registerTraining(command);
        linus = sdj.findById(linusId).orElseThrow(NoSuchElementException::new);
        Set<MentorTraining> updatedTrainings = linus.getTrainings();
        int numberOfTrainingsAfterAddingNewTraining = updatedTrainings.size();
        updatedTrainings.removeAll(trainingsBefore);
        MentorTraining savedTraining = updatedTrainings.stream().findFirst().orElseThrow(NoSuchElementException::new);
        assertThat(numberOfTrainingsAfterAddingNewTraining).isEqualTo(numberOfTrainingsBeforeNewTraining + 1);
        assertThat(savedTraining).isEqualToIgnoringGivenFields(training, "id");
    }

    @Test
    public void removeTraining() {
        Mentor linus = sdj.findById(MentorDataSet.THOR.getId()).orElseThrow(NoSuchElementException::new);
        MentorTraining trainingToRemove = linus.getTrainings().stream().findFirst().orElseThrow(NoSuchElementException::new);
        int numberOfTrainingsBeforeRemoval = linus.getTrainings().size();
        sut.removeTrainings(linus.getId(), singleton(trainingToRemove.getId()));
        linus = sdj.findById(linus.getId()).orElseThrow(NoSuchElementException::new);
        Set<MentorTraining> actualTrainings = linus.getTrainings();
        assertThat(actualTrainings).hasSize(numberOfTrainingsBeforeRemoval - 1);
        assertThat(actualTrainings).doesNotContain(trainingToRemove);
    }

    private MentorEditCommand someRegistrationCommand() {
        return new MentorEditCommand(
                "Chupa", "Chups", "chupa@chups.com",
                "1234567890", 10, "www.linkedin.com"
        );
    }

    private Mentor getExpectedFromRegistrationCommand(MentorEditCommand command) {
        return new Mentor(
                new EmailAddress(command.getUsername()), command.getFirstName(), command.getLastName(),
                new PhoneNumber(command.getPhoneNumber()), command.getYearsOfExperience(), command.getLinkedinUrl(),
                new HashSet<>(), 0
        );
    }

    private MentorTraining someNewTraining(EmailAddress linusId) {
        return new MentorTraining(
                new UniqueId(), "super new training",
                SkillsDataset.KOTLIN.getId(), "java", 2,
                linusId, new BigDecimal(300)
        );
    }
}
