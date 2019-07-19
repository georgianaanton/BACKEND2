package com.georgiana.certification.infra.persistence.mentor;

import static java.util.Collections.emptySet;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.georgiana.certification.domain.UniqueId;
import com.georgiana.certification.domain.mentor.Mentor;
import com.georgiana.certification.domain.mentor.MentorSearchResult;
import com.georgiana.certification.domain.mentor.MentorTraining;
import com.georgiana.certification.domain.mentor.MentorTrainingSearch;
import com.georgiana.certification.domain.mentor.Mentors;
import com.georgiana.certification.domain.mentor.ValidRomanianIntervalGenerator;
import com.georgiana.certification.domain.mentor.calendar.MentorCalendar;
import com.georgiana.certification.domain.mentor.calendar.MentorCalendars;
import com.georgiana.certification.domain.skill.Skill;
import com.georgiana.certification.domain.skill.Skills;
import com.georgiana.certification.infra.dataset.MentorDataSet;
import com.georgiana.certification.infra.dataset.SkillsDataset;
import com.georgiana.certification.infra.persistence.IntegrationTestWithNoDataset;

@Ignore
public class MentorTrainingSearchLocalIT extends IntegrationTestWithNoDataset {
    private static final LocalDateTime START_TIME = ValidRomanianIntervalGenerator.START_TIME;
    private static final LocalDateTime END_TIME = ValidRomanianIntervalGenerator.END_TIME;
    @Autowired
    private Skills sdjSkills;
    @Autowired
    private MentorCalendars sdjMemoryCalendars;
    @Autowired
    private Mentors sdjMentors;
    @Autowired
    private MentorTrainingSearch sut;
    private MentorInput mentorInput;

    @Before
    public void setupTestDataset() {
        mentorInput = new MentorInput().setupMentor();
        setupSkill(mentorInput.mentorTraining);
        setupCalendar(mentorInput.mentorTraining);
    }

    @Test
    public void should_return_all_if_training_pattern_is_null_and_dates_null() {
        List<MentorSearchResult> results = sut.searchForMentors(
                null, null, null
        );
        checkExpectationsForActualResults(results);
    }

    @Test
    public void should_return_1_result_for_java_and_no_dates() {
        List<MentorSearchResult> results = sut.searchForMentors(
                SkillsDataset.JAVA.getSkillName(), null, null
        );
        assertThat(results).hasSize(1);
    }

    @Test
    public void should_return_results_matching_the_training_pattern_and_date_times() {
        List<MentorSearchResult> results = sut.searchForMentors(
                "ava", START_TIME.minusHours(1L), END_TIME.plusDays(1L)
        );
        checkExpectationsForActualResults(results);
    }

    @Test
    public void should_return_results_matching_the_training_pattern_and_date_times_if_start_date_is_equal_to_skill_start() {
        List<MentorSearchResult> results = sut.searchForMentors(
                "ava", START_TIME, END_TIME.plusDays(1L)
        );
        checkExpectationsForActualResults(results);
    }

    @Test
    public void should_return_results_matching_the_training_pattern_and_date_times_if_end_date_is_equal_to_skill_end() {
        List<MentorSearchResult> results = sut.searchForMentors(
                "ava", START_TIME.minusHours(1L), END_TIME
        );
        checkExpectationsForActualResults(results);
    }


    @Test
    public void should_return_empty_results_if_end_time_of_training_is_after_input_end_time() {
        List<MentorSearchResult> results = sut.searchForMentors(
                "AVA", START_TIME.minusHours(1L), END_TIME.minusHours(1L)
        );
        assertThat(results).isEmpty();
    }

    @Test
    public void should_return_empty_results_if_start_time_of_training_is_before_input_start_time() {
        List<MentorSearchResult> results = sut.searchForMentors(
                "AVA", START_TIME.plusMinutes(1L), END_TIME.plusHours(1L)
        );
        assertThat(results).isEmpty();
    }

    @Test
    public void should_return_empty_results_if_skill_pattern_does_not_match() {
        List<MentorSearchResult> results = sut.searchForMentors(
                "AVAc", START_TIME.minusHours(1L), END_TIME.plusHours(1L)
        );
        assertThat(results).isEmpty();
    }


    private void checkExpectationsForActualResults(List<MentorSearchResult> results) {
        MentorSearchResult expectedResult = expectedResult(mentorInput);
        assertThat(results).isNotEmpty();
        assertThat(results).usingFieldByFieldElementComparator().containsExactly(expectedResult);
    }

    private MentorSearchResult expectedResult(MentorInput mentorInput) {
        Mentor mentor = mentorInput.getMentor();
        MentorTraining mentorTraining = mentorInput.getMentorTraining();
        return new MentorSearchResult(
                mentor.getFirstName(), mentor.getLastName(), mentor.getYearsOfExperience(), mentor.getNoOfOverallTrainingsDone(),
                mentorTraining.getNoOfTrainingsDone(), new BigDecimal(100), "JAVA",
                mentorTraining.getId().getValue()
        );
    }

    private class MentorInput {
        private Mentor linus;
        private MentorTraining mentorTraining;

        public Mentor getMentor() {
            return linus;
        }

        public MentorTraining getMentorTraining() {
            return mentorTraining;
        }

        public MentorInput setupMentor() {
            linus = MentorDataSet.THOR;
            sdjMentors.add(linus);
            mentorTraining = linus.getTrainings().stream()
                    .findFirst().orElseThrow(NoSuchElementException::new);
            return this;
        }
    }

    private void setupSkill(MentorTraining mentorTraining) {
        UniqueId skillId = mentorTraining.getSkillId();
        Skill skill = new Skill(skillId, "JAVA");
        sdjSkills.add(skill);
    }

    private void setupCalendar(MentorTraining mentorTraining) {
        MentorCalendar calendarEntry = new MentorCalendar(
                new UniqueId(), mentorTraining.getId(), START_TIME, END_TIME, 20, emptySet()
        );
        sdjMemoryCalendars.add(calendarEntry);
    }
}
