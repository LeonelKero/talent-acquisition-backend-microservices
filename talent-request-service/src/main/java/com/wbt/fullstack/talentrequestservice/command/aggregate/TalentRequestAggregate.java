package com.wbt.fullstack.talentrequestservice.command.aggregate;

import com.wbt.talentcoreapi.domain.CandidateSkills;
import com.wbt.talentcoreapi.domain.JobDescription;
import com.wbt.talentcoreapi.domain.RequestStatus;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.time.LocalDate;

@Aggregate
@NoArgsConstructor
public class TalentRequestAggregate {

    @AggregateIdentifier
    private String talentRequestId;

    private String talentRequestTitle;
    private JobDescription jobDescription;
    private CandidateSkills candidateSkills;
    private RequestStatus requestStatus;
    private LocalDate localDate;

}
