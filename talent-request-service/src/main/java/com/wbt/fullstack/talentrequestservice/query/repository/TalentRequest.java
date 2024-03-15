package com.wbt.fullstack.talentrequestservice.query.repository;

import com.wbt.talentcoreapi.domain.CandidateSkills;
import com.wbt.talentcoreapi.domain.JobDescription;
import com.wbt.talentcoreapi.domain.RequestStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class TalentRequest {
    @Id
    private String talentRequestId;
    private String talentRequestTitle;
    @Embedded
    private JobDescription jobDescription;
    @Embedded
    private CandidateSkills candidateSkills;
    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;
    private LocalDate startDate;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        TalentRequest that = (TalentRequest) o;
        return getTalentRequestId() != null && Objects.equals(getTalentRequestId(), that.getTalentRequestId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
