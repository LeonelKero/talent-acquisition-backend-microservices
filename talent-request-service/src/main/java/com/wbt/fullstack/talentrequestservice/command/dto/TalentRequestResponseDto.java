package com.wbt.fullstack.talentrequestservice.command.dto;

import com.wbt.talentcoreapi.domain.RequestStatus;
import lombok.Data;

@Data
public class TalentRequestResponseDto {
    private String talentRequestId;
    private String talentRequestTitle;
    private RequestStatus requestStatus;
}
