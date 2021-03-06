package br.com.kproj.salesman.infrastructure.entity.assistants.calendar.activity_specialization;


import br.com.kproj.salesman.infrastructure.entity.Identifiable;
import br.com.kproj.salesman.infrastructure.entity.assistants.calendar.CalendarActivityEntity;
import br.com.kproj.salesman.infrastructure.entity.leads.LeadEntity;

import javax.persistence.*;

@Entity
@Table(name="calendar_activity_lead")
public class CalendarActivityLeadEntity extends Identifiable {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name="lead_id")
    private LeadEntity lead;

    @OneToOne
    @JoinColumn(name = "activity_id")
    private CalendarActivityEntity activity;


    public CalendarActivityLeadEntity(){}

    public LeadEntity getLead() {
        return lead;
    }

    public void setLead(LeadEntity lead) {
        this.lead = lead;
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
