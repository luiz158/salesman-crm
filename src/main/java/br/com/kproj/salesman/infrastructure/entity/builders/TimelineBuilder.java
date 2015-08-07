package br.com.kproj.salesman.infrastructure.entity.builders;


import br.com.kproj.salesman.infrastructure.entity.Contact;
import br.com.kproj.salesman.infrastructure.entity.person.Person;
import br.com.kproj.salesman.infrastructure.entity.proposal.BusinessProposal;
import br.com.kproj.salesman.infrastructure.entity.timeline.Timeline;
import br.com.kproj.salesman.infrastructure.entity.timeline.items.TimelineItem;
import com.google.common.collect.Lists;

import java.util.List;

public class TimelineBuilder extends AbstractBuilder<Timeline>  {

	public TimelineBuilder() {
		this.entity = new Timeline();
	}

	public TimelineBuilder(Long id) {
		this();
		this.entity.setId(id);
	}
	
	public TimelineBuilder withContact(Contact contact) {
		this.entity.setContact(contact);
		return this;
	}

    public TimelineBuilder withPerson(Person person) {
        this.entity.setPerson(person);
        return this;
    }

    public TimelineBuilder withBusinessProposal(BusinessProposal proposal) {
        this.entity.setProposal(proposal);
        return this;
    }

    public TimelineBuilder withItem(TimelineItem item) {
        if (this.entity.getItems() == null) {
            this.entity.setItems(Lists.newArrayList());
        }

        this.entity.getItems().add(item);
        return this;
    }

    public TimelineBuilder withItems(List<TimelineItem> items) {
        if (this.entity.getItems() == null) {
            this.entity.setItems(Lists.newArrayList());
        }

        this.entity.getItems().addAll(items);
        return this;
    }

	public static TimelineBuilder createTimeline(Long id) {
		return new TimelineBuilder(id);
	}

	public static TimelineBuilder createTimeline() {
		return new TimelineBuilder();
	}
}
