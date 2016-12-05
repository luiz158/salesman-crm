package br.com.kproj.salesman.assistants.calendar.infrastructure.persistence;

import br.com.kproj.salesman.assistants.calendar.domain.model.activity.Activity;
import br.com.kproj.salesman.assistants.calendar.domain.model.activity.ActivityRepository;
import br.com.kproj.salesman.assistants.calendar.domain.model.activity.NewActivity;
import br.com.kproj.salesman.assistants.calendar.domain.model.activity.RangeDate;
import br.com.kproj.salesman.assistants.calendar.domain.model.calendar.Calendar;
import br.com.kproj.salesman.assistants.calendar.infrastructure.persistence.springdata.CalendarActivityRepository;
import br.com.kproj.salesman.assistants.calendar.infrastructure.persistence.translate.ActivityToCalendarActivityEntity;
import br.com.kproj.salesman.assistants.calendar.infrastructure.persistence.translate.CalendarActiityToActivity;
import br.com.kproj.salesman.infrastructure.entity.assistants.calendar.CalendarActivityEntity;
import br.com.kproj.salesman.infrastructure.entity.assistants.calendar.CalendarEntity;
import br.com.kproj.salesman.infrastructure.repository.BaseRepositoryLegacy;
import br.com.kproj.salesman.infrastructure.repository.BaseRespositoryImpl;
import br.com.kproj.salesman.infrastructure.repository.Converter;
import com.trex.clone.BusinessModelClone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.trex.clone.BusinessModelClone.from;

@Repository("activityRepositoryHibernateCalendarModule")
public class ActivityRepositoryHibernate extends BaseRespositoryImpl<Activity, CalendarActivityEntity> implements ActivityRepository {


    private CalendarActivityRepository repository;
    private CalendarActiityToActivity converter;

    @Autowired
    public ActivityRepositoryHibernate(CalendarActivityRepository repository, CalendarActiityToActivity converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public List<Activity> findAll(RangeDate range) {
        List<CalendarActivityEntity> activities = null;//repository.findByRangeDates(range.getStart(), range.getEnd());

        return activities.stream().map(converter::convert).collect(Collectors.toList());
    }

    @Override
    public Optional<Activity> register(NewActivity newActivity) {
        Activity activity = newActivity.getActivity();
        Calendar calendar = newActivity.getCalendar();

        CalendarActivityEntity calendarActivityEntity = from(activity).convertTo(CalendarActivityEntity.class);
        calendarActivityEntity.setCalendar(new CalendarEntity(calendar.getId()));

        CalendarActivityEntity activitySaved = repository.save(calendarActivityEntity);

        return Optional.of(getConverter().convert(activitySaved));
    }

    @Override
    public BaseRepositoryLegacy<CalendarActivityEntity, Long> getRepository() {
        return repository;
    }

    @Override
    public Converter<CalendarActivityEntity, Activity> getConverter() {
        return converter;
    }
}
