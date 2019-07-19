package com.georgiana.certification.exposition.mentor.calendar;

import com.georgiana.certification.domain.UniqueId;
import com.georgiana.certification.domain.mentor.calendar.BookingCommand;
import com.georgiana.certification.domain.mentor.calendar.MentorCalendar;
import com.georgiana.certification.domain.mentor.calendar.MentorCalendars;
import com.georgiana.certification.domain.user.EmailAddress;
import com.georgiana.certification.exposition.BaseExpoTest;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

import static com.georgiana.certification.domain.user.ValidUserGenerator.GEORGIANA;

import java.util.NoSuchElementException;

public class CalendarResourceLocalIT extends BaseExpoTest {

    @Autowired
    private MentorCalendars calendars;

    private UniqueId trainingId;

    @Test
    public void cancelBookingForTraining() {
        EmailAddress traineeEmail = GEORGIANA.getId();
        MentorCalendar trainingCalendar = calendars.findByTraineeAddress(traineeEmail)
                .stream().findFirst().orElseThrow(NoSuchElementException::new);
        BookingCommand cancellationCommand = new BookingCommand(trainingCalendar.getTrainingId(), traineeEmail);
        trainingId = trainingCalendar.getTrainingId();
        restTemplate.exchange(
                "/persons/calendar/cancel-booking", HttpMethod.PUT, new HttpEntity<>(cancellationCommand), Boolean.class
        );
    }

    @After
    public void verifyThatTrainingBookingWasCanceledWithoutCallingRepoSave() {
        MentorCalendar trainingCalendar = calendars.findByTraining(trainingId);
        Assertions.assertThat(trainingCalendar.getTraineesBooked()).doesNotContain(GEORGIANA.getId());
    }
}