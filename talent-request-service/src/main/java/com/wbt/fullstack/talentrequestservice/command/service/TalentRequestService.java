package com.wbt.fullstack.talentrequestservice.command.service;

import com.wbt.fullstack.talentrequestservice.command.command.CreateTalentRequestCommand;
import com.wbt.fullstack.talentrequestservice.command.dto.CreateTalentRequestCommandDto;
import com.wbt.fullstack.talentrequestservice.command.dto.TalentRequestResponseDto;
import com.wbt.talentcoreapi.domain.RequestStatus;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public record TalentRequestService(CommandGateway commandGateway) {
    /**
     * @param talentRequestCommandDto data transfer object
     * @return Response entity of
     * @apiNote Create new talent request command and send it to the command bus.
     * @see com.wbt.fullstack.talentrequestservice.command.command.CreateTalentRequestCommand
     */
    public ResponseEntity<?> createNewTalentRequest(final CreateTalentRequestCommandDto talentRequestCommandDto) {
        final var talentRequestCommand = CreateTalentRequestCommand.builder()
                .talentRequestId(UUID.randomUUID().toString())
                .requestStatus(RequestStatus.OPEN)
                .talentRequestTitle(talentRequestCommandDto.getTalentRequestTitle())
                .jobDescription(talentRequestCommandDto.getJobDescription())
                .candidateSkills(talentRequestCommandDto.getCandidateSkills())
                .startDate(talentRequestCommandDto.getStartDate())
                .build();
        try {
            this.commandGateway.sendAndWait(talentRequestCommand);
            final var talentRequestResponseDto = new TalentRequestResponseDto();
            BeanUtils.copyProperties(talentRequestCommand, talentRequestResponseDto);

            return new ResponseEntity<>(talentRequestResponseDto, HttpStatus.CREATED);
        } catch (Exception e) {
            final var exceptionMessage = "Unable to create new talent request";
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
