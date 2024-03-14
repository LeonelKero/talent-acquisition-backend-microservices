package com.wbt.fullstack.talentrequestservice.query.eventhandler;

import com.wbt.fullstack.talentrequestservice.core.events.TalentRequestCreatedEvent;
import com.wbt.fullstack.talentrequestservice.query.repository.TalentRequest;
import com.wbt.fullstack.talentrequestservice.query.repository.TalentRequestRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class TalentRequestEventHandler {

    private final TalentRequestRepository talentRequestRepository;

    public TalentRequestEventHandler(TalentRequestRepository talentRequestRepository) {
        this.talentRequestRepository = talentRequestRepository;
    }

    @EventHandler
    public void on(final TalentRequestCreatedEvent event) {
        final var talentRequest = new TalentRequest();
        BeanUtils.copyProperties(event, talentRequest);
        this.talentRequestRepository.save(talentRequest);
    }
}
