package com.georgiana.certification.domain.mentor;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.georgiana.certification.domain.BaseEntity;
import com.georgiana.certification.domain.UniqueId;
import com.georgiana.certification.domain.user.EmailAddress;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Access(AccessType.FIELD)
@Getter
@Entity
public class MentorTraining extends BaseEntity<MentorTraining, UniqueId> {
    @NotEmpty
    @Column(name = "FACILITIES")
    @JsonProperty
    private String facilitiesDesc;

    @NotNull
    @AttributeOverride(name = "value", column = @Column(name = "SKILL_ID"))
    @JsonProperty
    private UniqueId skillId;

    @NotEmpty
    @Column(name = "TRAINING_PREREQUISITE")
    @JsonProperty
    private String prerequisitesDesc;

    @JsonProperty
    private int noOfTrainingsDone;

    @NotNull
    @AttributeOverride(name = "value", column = @Column(name = "MENTOR_ID"))
    @JsonProperty
    private EmailAddress mentorId;

    @NotNull
    @JsonProperty
    private BigDecimal fee;

    public MentorTraining(
            UniqueId id, @NotEmpty String facilitiesDesc, UniqueId skillId, String prerequisitesDesc,
            int noOfTrainingsDone, EmailAddress mentorId, BigDecimal fee
    ) {
        super(MentorTraining.class, id);
        this.facilitiesDesc = facilitiesDesc;
        this.skillId = skillId;
        this.prerequisitesDesc = prerequisitesDesc;
        this.noOfTrainingsDone = noOfTrainingsDone;
        this.mentorId = mentorId;
        this.fee = fee;
        validate(this);
    }

    /*Used by JPA*/
    private MentorTraining() {
        super(MentorTraining.class, new UniqueId());
        prerequisitesDesc = null;
        skillId = null;
        facilitiesDesc = null;
    }
}
