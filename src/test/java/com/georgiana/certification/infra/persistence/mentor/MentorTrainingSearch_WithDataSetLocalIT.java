package com.georgiana.certification.infra.persistence.mentor;

import com.georgiana.certification.domain.mentor.MentorSearchResult;
import com.georgiana.certification.domain.mentor.MentorTrainingSearch;
import com.georgiana.certification.infra.dataset.SkillsDataset;
import com.georgiana.certification.infra.persistence.IntegrationTestWithDataset;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Ignore
public class MentorTrainingSearch_WithDataSetLocalIT extends IntegrationTestWithDataset {
    @Autowired
    private MentorTrainingSearch sut;


    @Test
    public void should_return_1_result_for_java_and_no_dates() {
        List<MentorSearchResult> results = sut.searchForMentors(
                SkillsDataset.ANGULAR.getSkillName(), null, null
        );
        assertThat(results).hasSize(1);
    }

    @Test
    public void should_return_2_results_for_microservices_and_no_dates() {
        List<MentorSearchResult> results = sut.searchForMentors(
                SkillsDataset.MICROSERVICES.getSkillName(), null, null
        );
        assertThat(results).hasSize(2);
    }
}
