package com.wbt.fullstack.talentrequestservice.command.aggregate;

import com.wbt.fullstack.talentrequestservice.command.command.CreateTalentRequestCommand;
import com.wbt.fullstack.talentrequestservice.core.events.TalentRequestCreatedEvent;
import com.wbt.talentcoreapi.domain.CandidateSkills;
import com.wbt.talentcoreapi.domain.JobDescription;
import com.wbt.talentcoreapi.domain.RequestStatus;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

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

    /**
     * @param talentRequestCommand Represents the command we want to dispatch
     * @apiNote This handler will be call when we want to dispatch a command of type CreateTalentRequestCommand.
     */
    @CommandHandler
    public TalentRequestAggregate(final CreateTalentRequestCommand talentRequestCommand) {
        final var talentCreatedEvent = new TalentRequestCreatedEvent();
        BeanUtils.copyProperties(talentRequestCommand, talentCreatedEvent);
        // dispatch the event to the store
        AggregateLifecycle.apply(talentCreatedEvent);
    }

    @EventSourcingHandler
    public void on(final TalentRequestCreatedEvent requestCreatedEvent) {
        this.talentRequestId = requestCreatedEvent.getTalentRequestId();
        this.talentRequestTitle = requestCreatedEvent.getTalentRequestTitle();
        this.jobDescription = requestCreatedEvent.getJobDescription();
        this.candidateSkills = requestCreatedEvent.getCandidateSkills();
        this.requestStatus = requestCreatedEvent.getRequestStatus();
        this.localDate = requestCreatedEvent.getStartDate();
    }
}
