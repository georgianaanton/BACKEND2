package com.georgiana.certification.exposition.mentor.calendar;

import com.georgiana.certification.domain.mentor.calendar.BookTraining;
import com.georgiana.certification.domain.mentor.calendar.BookingCommand;
import com.georgiana.certification.domain.mentor.calendar.MentorTrainingDetails;
import com.georgiana.certification.domain.mentor.calendar.ViewTrainingsBookedByUser;
import com.georgiana.certification.domain.user.EmailAddress;
import com.georgiana.certification.exposition.CustomRequestMapping;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@CustomRequestMapping
public class CalendarResource {
    private final BookTraining bookTraining;
    private final ViewTrainingsBookedByUser viewTrainingsBookedByUser;

    public CalendarResource(BookTraining bookTraining, ViewTrainingsBookedByUser viewTrainingsBookedByUser) {
        this.bookTraining = bookTraining;
        this.viewTrainingsBookedByUser = viewTrainingsBookedByUser;
    }

    @PutMapping("/calendar/book")
    public ResponseEntity<Boolean> bookTraining(@Valid @RequestBody BookingCommand bookingCommand) {
        return ResponseEntity.ok(bookTraining.bookTrainingForTrainee(bookingCommand));
    }

    @PutMapping("/calendar/cancel-booking")
    public ResponseEntity<Boolean> cancelBookingForTraining(@Valid @RequestBody BookingCommand bookingCommand) {
        return ResponseEntity.ok(bookTraining.cancelBookingTrainingForTrainee(bookingCommand));
    }

    @GetMapping("/calendar/{traineeAddress}/bookings")
    public Set<MentorTrainingDetails> viewBookedTrainingsByUser(@PathVariable EmailAddress traineeAddress) {
        return viewTrainingsBookedByUser.viewTrainingsBookedByUser(traineeAddress);
    }

}
