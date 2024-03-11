package com.wbt.fullstack.talentrequestservice.command.dto;

import com.wbt.talentcoreapi.domain.CandidateSkills;
import com.wbt.talentcoreapi.domain.JobDescription;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class CreateTalentRequestCommandDto {
    private String talentRequestTitle;
    private JobDescription jobDescription;
    private CandidateSkills candidateSkills;
    private LocalDate startDate;
}
