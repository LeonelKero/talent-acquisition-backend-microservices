package com.wbt.fullstack.talentrequestservice.command.command;

import com.wbt.talentcoreapi.domain.CandidateSkills;
import com.wbt.talentcoreapi.domain.JobDescription;
import com.wbt.talentcoreapi.domain.RequestStatus;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.time.LocalDate;

@Data
@Builder
public class CreateTalentRequestCommand {
    @TargetAggregateIdentifier
    private final String talentRequestId;
    private final String talentRequestTitle;
    private final JobDescription jobDescription;
    private final CandidateSkills candidateSkills;
    private final RequestStatus requestStatus;
    private final LocalDate startDate;
}
