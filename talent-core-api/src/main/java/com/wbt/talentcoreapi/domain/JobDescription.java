package com.wbt.talentcoreapi.domain;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class JobDescription {
    private String responsibility;
    public String qualification;
}
