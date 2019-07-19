package com.georgiana.certification.domain.mentor.calendar;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.georgiana.certification.domain.UniqueId;
import com.georgiana.certification.domain.user.EmailAddress;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingCommand {
    @JsonProperty
    @NotNull
    public UniqueId trainingId;
    @JsonProperty
    @NotNull
    public EmailAddress traineeEmail;
}
