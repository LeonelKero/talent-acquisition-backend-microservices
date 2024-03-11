package com.wbt.fullstack.talentrequestservice.command.controller;

import com.wbt.fullstack.talentrequestservice.command.dto.CreateTalentRequestCommandDto;
import com.wbt.fullstack.talentrequestservice.command.service.TalentRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {"/talent-request"})
public record TalentRequestCommandController(TalentRequestService talentRequestService) {

    @PostMapping
    public ResponseEntity createTalentRequest(final @RequestBody CreateTalentRequestCommandDto talentRequestCommandDto) {
        return this.talentRequestService.createNewTalentRequest(talentRequestCommandDto);
    }

}
