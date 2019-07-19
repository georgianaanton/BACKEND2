package com.georgiana.certification.exposition.mentor;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.georgiana.certification.domain.UniqueId;
import com.georgiana.certification.domain.user.EmailAddress;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainingsRemovalCommand {
    @JsonProperty
    @NotNull
    public EmailAddress mentorAddress;
    @JsonProperty
    @NotEmpty
    public Set<UniqueId> trainingIdsToBeRemoved;
}
