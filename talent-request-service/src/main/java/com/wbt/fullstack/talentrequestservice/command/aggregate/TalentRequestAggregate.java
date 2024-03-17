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
     * @param talentRequestCommand Represents the command we want to dispatch.
     * @apiNote This handler will be call when we want to dispatch a command of type CreateTalentRequestCommand.
     */
    @CommandHandler
    public TalentRequestAggregate(final CreateTalentRequestCommand talentRequestCommand) {
        //  Forge an event for that command
        final var talentCreatedEvent = new TalentRequestCreatedEvent(
                talentRequestCommand.getTalentRequestId(),
                talentRequestCommand.getTalentRequestTitle(),
                talentRequestCommand.getJobDescription(),
                talentRequestCommand.getCandidateSkills(),
                talentRequestCommand.getRequestStatus(),
                talentRequestCommand.getStartDate());
//        BeanUtils.copyProperties(talentRequestCommand, talentCreatedEvent);
        // dispatch the event to the event store
        AggregateLifecycle.apply(talentCreatedEvent);
    }

    /**
     * @param requestCreatedEvent represents the event.
     * @apiNote This is a convention for Axon, this method which update the state of the aggregate. By convention, it is named "public void on(@params)".
     */
    @EventSourcingHandler
    public void on(final TalentRequestCreatedEvent requestCreatedEvent) {
        this.talentRequestId = requestCreatedEvent.talentRequestId();
        this.talentRequestTitle = requestCreatedEvent.talentRequestTitle();
        this.jobDescription = requestCreatedEvent.jobDescription();
        this.candidateSkills = requestCreatedEvent.candidateSkills();
        this.requestStatus = requestCreatedEvent.requestStatus();
        this.localDate = requestCreatedEvent.startDate();
    }
}
