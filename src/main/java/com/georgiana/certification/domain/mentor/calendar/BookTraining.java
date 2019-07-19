package com.georgiana.certification.domain.mentor.calendar;

import com.georgiana.certification.domain.UniqueId;
import com.georgiana.certification.domain.user.User;
import com.georgiana.certification.domain.user.Users;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class BookTraining {
    private final MentorCalendars calendar;
    private final Users users;

    public BookTraining(MentorCalendars calendar, Users users) {
        this.calendar = calendar;
        this.users = users;
    }

    public boolean bookTrainingForTrainee(BookingCommand bookingCommand) {
        MentorCalendar trainingCalendar = calendar.findByTraining(bookingCommand.trainingId);
        return trainingCalendar.bookForTrainingIfSpotsLeft(bookingCommand.traineeEmail);
    }

    public boolean cancelBookingTrainingForTrainee(BookingCommand bookingCommand) {
        MentorCalendar trainingCalendar = calendar.findByTraining(bookingCommand.trainingId);
        return trainingCalendar.cancelBookingForTrainee(bookingCommand.traineeEmail);
    }

    public Set<User> getUsersThatBookedTraining(UniqueId trainingId) {
        MentorCalendar trainingCalendar = calendar.findByTraining(trainingId);
        return users.findAll(trainingCalendar.getTraineesBooked());
    }
}
