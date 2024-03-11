package com.wbt.talentcoreapi.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Embeddable
@Data
public class CandidateSkills {
    @Enumerated(value = EnumType.STRING)
    private CoreSkill coreSkill;

    @Enumerated(value = EnumType.STRING)
    private SkillLevel skillLevel;
}
