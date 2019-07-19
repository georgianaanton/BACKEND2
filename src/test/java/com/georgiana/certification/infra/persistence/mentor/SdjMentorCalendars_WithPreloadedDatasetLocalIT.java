//package com.georgiana.certification.infra.persistence.mentor;
//@Ignore
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.util.Set;
//
//import org.junit.Ignore;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.georgiana.certification.domain.mentor.calendar.MentorCalendar;
//import com.georgiana.certification.domain.user.EmailAddress;
//import com.georgiana.certification.domain.user.ValidUserGenerator;
//import com.georgiana.certification.infra.dataset.MentorDataSet;
//
//@Ignore
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class SdjMentorCalendars_WithPreloadedDatasetLocalIT {
//    @Autowired
//    private SdjMentorCalendars sut;
//
//    @Test
//    public void findByTraineeAddress_should_return_all_trainings_booked_by_that_email() {
//        EmailAddress traineeThatBookedEmail = ValidUserGenerator.GEORGIANA.getId();
//        Set<MentorCalendar> actualResults = sut.findByTraineeAddress(traineeThatBookedEmail);
//        int expectedNumberOfResults = MentorDataSet.HERCULES.getTrainings().size();
//        assertThat(actualResults).hasSize(expectedNumberOfResults);
//        assertThat(actualResults).allMatch(
//                c -> c.getTraineesBooked().contains(traineeThatBookedEmail)
//        );
//    }
//}
