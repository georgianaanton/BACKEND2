package com.georgiana.certification.exposition.mentor;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.georgiana.certification.domain.mentor.Mentor;
import com.georgiana.certification.domain.user.EmailAddress;
import com.georgiana.certification.domain.user.PhoneNumber;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;

@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MentorEditCommand {
    @JsonProperty
    private String firstName;
    @JsonProperty
    private String lastName;
    @JsonProperty
    private String username;
    @JsonProperty
    private String phoneNumber;
    @JsonProperty
    private int yearsOfExperience;
    @JsonProperty
    private String linkedinUrl;

    public Mentor toNewMentor() {
        return new Mentor(
                new EmailAddress(username), firstName, lastName, new PhoneNumber(phoneNumber),
                yearsOfExperience, linkedinUrl, new HashSet<>(), 0
        );
    }
}
