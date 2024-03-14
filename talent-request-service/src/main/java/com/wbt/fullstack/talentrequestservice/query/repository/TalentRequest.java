package com.wbt.fullstack.talentrequestservice.query.repository;

import com.wbt.talentcoreapi.domain.CandidateSkills;
import com.wbt.talentcoreapi.domain.JobDescription;
import com.wbt.talentcoreapi.domain.RequestStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class TalentRequest {
    @Id
    private String talentRequestId;
    private String talentRequestTitle;
    @Embedded
    private JobDescription jobDescription;
    @Embedded
    private CandidateSkills candidateSkills;
    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;
    private LocalDate startDate;
}
