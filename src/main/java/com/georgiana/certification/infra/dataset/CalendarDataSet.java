package com.georgiana.certification.infra.dataset;

import com.georgiana.certification.domain.UniqueId;
import com.georgiana.certification.domain.mentor.MentorTraining;
import com.georgiana.certification.domain.mentor.calendar.MentorCalendar;
import com.georgiana.certification.domain.user.EmailAddress;

import static com.georgiana.certification.domain.user.ValidUserGenerator.GEORGIANA;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CalendarDataSet {
    private final static LocalDateTime START_TIME = LocalDateTime.now();
    private final static LocalDateTime END_TIME = LocalDateTime.now().plusMonths(1L);
    private final static long LOWER_BOUND = 1L;
    private final static long UPPER_BOUND = 20L;
    public static List<MentorCalendar> generateMentorCalendarForTrainings(Set<MentorTraining> trainings) {
        List<MentorCalendar> program = new ArrayList<>();
        for (MentorTraining training : trainings) {
            LocalDateTime startTime = START_TIME.minusDays(generateRandomLong());
            LocalDateTime endTime = END_TIME.plusDays(generateRandomLong());
            Set<EmailAddress> traineesThatBooked = new HashSet<>();
            makeSomeMentorTrainingHaveBookings(training, traineesThatBooked);
            MentorCalendar trainingProgram = new MentorCalendar(
                    new UniqueId(), training.getId(), startTime, endTime,
                    20, traineesThatBooked
            );
            program.add(trainingProgram);
        }
        return program;
    }

    private static void makeSomeMentorTrainingHaveBookings(MentorTraining training, Set<EmailAddress> traineesThatBooked) {
        if (training.getMentorId().equals(MentorDataSet.HERCULES.getId())) {
            traineesThatBooked.add(GEORGIANA.getId());
        }
    }

    private static long generateRandomLong() {
        return LOWER_BOUND + (long) (Math.random() * (UPPER_BOUND - LOWER_BOUND));
    }
}
