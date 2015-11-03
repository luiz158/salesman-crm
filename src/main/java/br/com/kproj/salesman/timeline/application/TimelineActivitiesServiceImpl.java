package br.com.kproj.salesman.timeline.application;

import br.com.kproj.salesman.infrastructure.entity.AppFile;
import br.com.kproj.salesman.infrastructure.entity.Contact;
import br.com.kproj.salesman.infrastructure.entity.person.Person;
import br.com.kproj.salesman.infrastructure.entity.proposal.BusinessProposal;
import br.com.kproj.salesman.infrastructure.entity.timeline.Timeline;
import br.com.kproj.salesman.infrastructure.entity.timeline.items.TimelineActivity;
import br.com.kproj.salesman.infrastructure.repository.BaseRepository;
import br.com.kproj.salesman.infrastructure.repository.TimelineActivitiesRepository;
import br.com.kproj.salesman.infrastructure.service.BaseModelServiceImpl;
import br.com.kproj.salesman.infrastructure.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimelineActivitiesServiceImpl extends BaseModelServiceImpl<TimelineActivity> implements TimelineActivitiesService {

	
    @Autowired
    private TimelineService service;

    @Autowired
    private TimelineActivitiesRepository repository;

    @Autowired
    private FileService fileService;

    @Override
    public Timeline register(Person person, TimelineActivity activity) {

        Timeline timeline = service.register(person);
        saveActivity(activity, timeline);

        return timeline;
    }

    @Override
    public Timeline register(BusinessProposal proposal, TimelineActivity activity) {

        Timeline timeline = service.register(proposal);
        saveActivity(activity, timeline);

        return timeline;
    }

    @Override
    public Timeline register(Contact contact, TimelineActivity activity) {

        Timeline timeline = service.register(contact);
        saveActivity(activity, timeline);

        return timeline;
    }

    private void saveActivity(TimelineActivity activity, Timeline timeline) {
        List<AppFile> files = activity.getFiles();
        TimelineActivity activitySaved = save(activity);

        timeline.addActivity(activitySaved);
        this.fileService.saveFile(activitySaved, files);
    }

    @Override
    public byte[] getActivityFile(TimelineActivity timelineActivity, AppFile appfile) {
        if (timelineActivity.isNew() || appfile.isNew()) {
            return new byte[0];
        }
        return fileService.getFile(timelineActivity, appfile);
    }


    @Override
    public BaseRepository<TimelineActivity, Long> getRepository() {
        return repository;
    }
}