package com.georgiana.certification.exposition.mentor;

import com.georgiana.certification.domain.mentor.MentorSearchResult;
import com.georgiana.certification.domain.mentor.MentorTrainingSearch;
import com.georgiana.certification.exposition.CustomRequestMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@CustomRequestMapping
public class MentorSearchResource {
    private final MentorTrainingSearch trainingSearch;

    public MentorSearchResource(MentorTrainingSearch trainingSearch) {
        this.trainingSearch = trainingSearch;
    }

    @PostMapping(path = "/mentors/search", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
    public List<MentorSearchResult> findMentors(@Valid @RequestBody MentorSearchRequest request) {
        return trainingSearch.searchForMentors(
                request.getSkillNamePattern(), request.startTime(), request.endTime()
        );
    }
    
//    @PostMapping(path = "/mentors", consumes = APPLICATION_JSON_UTF8_VALUE, produces = APPLICATION_JSON_UTF8_VALUE)
//    public List<MentorSearchResult> findAllMentors() {
//        
//    }
}
