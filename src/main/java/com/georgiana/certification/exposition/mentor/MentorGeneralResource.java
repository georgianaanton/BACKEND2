package com.georgiana.certification.exposition.mentor;

import com.georgiana.certification.domain.UniqueId;
import com.georgiana.certification.domain.mentor.Mentor;
import com.georgiana.certification.domain.mentor.MentorService;
import com.georgiana.certification.domain.mentor.Mentors;
import com.georgiana.certification.domain.mentor.calendar.MentorTrainingDetails;
import com.georgiana.certification.domain.user.EmailAddress;
import com.georgiana.certification.exposition.CustomRequestMapping;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

import static org.springframework.http.ResponseEntity.ok;

@CustomRequestMapping
public class MentorGeneralResource {
    private final MentorService mentorService;
    private final Mentors mentors;

    public MentorGeneralResource(MentorService mentorService, Mentors mentors) {
        this.mentorService = mentorService;
        this.mentors = mentors;
    }

//    @GetMapping("/mentors/{address}")
//    public Mentor getMentorDetails(@PathVariable("address") EmailAddress address) {
//        return mentors.getOrThrow(address);
//    }

    @PutMapping("/mentors")
    public ResponseEntity<EmailAddress> registerMentor(@Valid @RequestBody MentorEditCommand registrationCommand) {
        return ok(mentorService.registerMentor(registrationCommand).getId());
    }

    @PostMapping("/mentors")
    public ResponseEntity<EmailAddress> updatedMentor(@Valid @RequestBody MentorEditCommand editCommand) {
        return ok(mentorService.updateMentor(editCommand).getId());
    }

    @GetMapping("/mentors/{mentorAddress}/trainings")
    public Set<MentorTrainingDetails> viewTrainings(@PathVariable @Valid EmailAddress mentorAddress) {
        return mentorService.viewTrainingsDetails(mentorAddress);
    }

    @GetMapping("/mentors/trainings/{trainingId}")
    public MentorTrainingDetails viewTrainingDetails(@PathVariable @Valid UniqueId trainingId) {
        return mentorService.viewTrainingDetails(trainingId);
    }

    @PostMapping("/mentors/trainings")
    public ResponseEntity<UniqueId> addTraining(@Valid @RequestBody TrainingAddCommand trainingAddCommand) {
        return ok(mentorService.registerTraining(trainingAddCommand));
    }

    @DeleteMapping("/mentors/trainings")
    public ResponseEntity<EmailAddress> removeTrainings(@Valid @RequestBody TrainingsRemovalCommand removalCommand) {
        Mentor mentorWithRemovedTrainings = mentorService.removeTrainings(
                removalCommand.mentorAddress, removalCommand.trainingIdsToBeRemoved
        );
        return ok(mentorWithRemovedTrainings.getId());
    }
}
