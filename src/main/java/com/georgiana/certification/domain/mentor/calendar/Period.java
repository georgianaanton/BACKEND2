package com.georgiana.certification.domain.mentor.calendar;

import lombok.Getter;

import javax.validation.constraints.NotNull;

import com.georgiana.certification.domain.BaseValueObject;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;


@Getter
public class Period extends BaseValueObject<Period> {
    @NotNull
    private final LocalDateTime startTime;
    @NotNull
    private final LocalDateTime endTime;

    public Period(LocalDateTime startTime, LocalDateTime endTime) {
        super(Period.class);
        this.startTime = startTime;
        this.endTime = endTime;
        validate(this);
    }

    @Override
    protected List<Object> attributesToIncludeInEqualityCheck() {
        return asList(startTime, endTime);
    }


    private Period() {
        super(Period.class);
        this.startTime = null;
        this.endTime = null;
    }
}
