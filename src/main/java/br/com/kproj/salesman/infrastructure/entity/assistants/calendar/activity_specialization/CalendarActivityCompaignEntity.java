package br.com.kproj.salesman.infrastructure.entity.assistants.calendar.activity_specialization;


import br.com.kproj.salesman.infrastructure.entity.Identifiable;
import br.com.kproj.salesman.infrastructure.entity.campaigns.CampaignEntity;

import javax.persistence.*;

@Entity
@Table(name="calendar_activity_compaign")
public class CalendarActivityCompaignEntity extends Identifiable {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name="compaign_id")
    private CampaignEntity campaign;


    public CalendarActivityCompaignEntity(){}

    public CampaignEntity getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignEntity campaign) {
        this.campaign = campaign;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
