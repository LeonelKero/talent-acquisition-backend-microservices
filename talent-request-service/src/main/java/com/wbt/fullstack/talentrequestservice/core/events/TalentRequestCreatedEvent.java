package com.wbt.fullstack.talentrequestservice.core.events;

import com.wbt.talentcoreapi.domain.CandidateSkills;
import com.wbt.talentcoreapi.domain.JobDescription;
import com.wbt.talentcoreapi.domain.RequestStatus;
import lombok.Data;

import java.time.LocalDate;

/**
 * This class defines which properties of the event will be persisted in the event store
 */
@Data
public class TalentRequestCreatedEvent {

    private String talentRequestId;
    private String talentRequestTitle;
    private JobDescription jobDescription;
    private CandidateSkills candidateSkills;
    private RequestStatus requestStatus;
    private LocalDate startDate;

}
