package com.wbt.fullstack.talentrequestservice.core.events;

import com.wbt.talentcoreapi.domain.CandidateSkills;
import com.wbt.talentcoreapi.domain.JobDescription;
import com.wbt.talentcoreapi.domain.RequestStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

/**
 * This class defines which properties of the event will be persisted in the event store
 */
public record TalentRequestCreatedEvent(String talentRequestId,
                                        String talentRequestTitle,
                                        JobDescription jobDescription,
                                        CandidateSkills candidateSkills,
                                        RequestStatus requestStatus,
                                        LocalDate startDate) {

}
