package com.georgiana.certification.exposition.mentor;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class MentorSearchRequest {
    @JsonProperty
    private String skillNamePattern;
    @JsonProperty
    private String startDate;
    @JsonProperty
    private String endDate;


    public String getSkillNamePattern() {
        return skillNamePattern;
    }

    public LocalDateTime startTime() {
        if (StringUtils.isEmpty(startDate)) {
            return null;
        }
        return LocalDateTime.parse(startDate);
    }

    public LocalDateTime endTime() {
        if (StringUtils.isEmpty(endDate)) {
            return null;
        }
        return LocalDateTime.parse(endDate);
    }
}
