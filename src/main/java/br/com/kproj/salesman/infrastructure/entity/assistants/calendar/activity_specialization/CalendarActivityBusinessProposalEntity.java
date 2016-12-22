package br.com.kproj.salesman.infrastructure.entity.assistants.calendar.activity_specialization;


import br.com.kproj.salesman.infrastructure.entity.Identifiable;
import br.com.kproj.salesman.infrastructure.entity.assistants.calendar.CalendarActivityEntity;
import br.com.kproj.salesman.infrastructure.entity.proposal.BusinessProposalEntity;
import br.com.kproj.salesman.infrastructure.entity.saleable.SaleableUnitEntity;

import javax.persistence.*;

@Entity
@Table(name="calendar_activity_business_proposal")
public class CalendarActivityBusinessProposalEntity extends Identifiable {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name="business_proposal_id")
    private BusinessProposalEntity proposal;

    @OneToOne
    @JoinColumn(name = "activity_id")
    private CalendarActivityEntity activity;


    public CalendarActivityBusinessProposalEntity(){}

    public BusinessProposalEntity getProposal() {
        return proposal;
    }

    public void setProposal(BusinessProposalEntity proposal) {
        this.proposal = proposal;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CalendarActivityEntity getActivity() {
        return activity;
    }

    public void setActivity(CalendarActivityEntity activity) {
        this.activity = activity;
    }
}
