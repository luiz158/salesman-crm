package br.com.kproj.salesman.assistants.calendar.activities.specialization.application;



import br.com.kproj.salesman.assistants.calendar.activities.specialization.domain.model.activity.ActivityContact;
import br.com.kproj.salesman.infrastructure.service.ModelFacade;

import java.util.Optional;

public interface ActivityContactFacade extends ModelFacade<ActivityContact> {

    Optional<ActivityContact> makeSpecialization(ActivityContact activityContact);

}
