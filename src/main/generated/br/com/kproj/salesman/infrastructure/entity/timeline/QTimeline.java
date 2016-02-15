package br.com.kproj.salesman.infrastructure.entity.timeline;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QTimeline is a Querydsl query type for Timeline
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QTimeline extends EntityPathBase<Timeline> {

    private static final long serialVersionUID = 772235583L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTimeline timeline = new QTimeline("timeline");

    public final br.com.kproj.salesman.infrastructure.entity.QIdentifiable _super = new br.com.kproj.salesman.infrastructure.entity.QIdentifiable(this);

    public final ListPath<br.com.kproj.salesman.infrastructure.entity.timeline.items.TimelineActivity, br.com.kproj.salesman.infrastructure.entity.timeline.items.QTimelineActivity> activities = this.<br.com.kproj.salesman.infrastructure.entity.timeline.items.TimelineActivity, br.com.kproj.salesman.infrastructure.entity.timeline.items.QTimelineActivity>createList("activities", br.com.kproj.salesman.infrastructure.entity.timeline.items.TimelineActivity.class, br.com.kproj.salesman.infrastructure.entity.timeline.items.QTimelineActivity.class, PathInits.DIRECT2);

    public final br.com.kproj.salesman.infrastructure.entity.calendar.QCalendarActivity calendarActivity;

    public final br.com.kproj.salesman.infrastructure.entity.QContact contact;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final br.com.kproj.salesman.infrastructure.entity.person.QPerson person;

    public final br.com.kproj.salesman.infrastructure.entity.proposal.QBusinessProposal proposal;

    public final br.com.kproj.salesman.infrastructure.entity.task.QTask task;

    public QTimeline(String variable) {
        this(Timeline.class, forVariable(variable), INITS);
    }

    public QTimeline(Path<? extends Timeline> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTimeline(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTimeline(PathMetadata<?> metadata, PathInits inits) {
        this(Timeline.class, metadata, inits);
    }

    public QTimeline(Class<? extends Timeline> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.calendarActivity = inits.isInitialized("calendarActivity") ? new br.com.kproj.salesman.infrastructure.entity.calendar.QCalendarActivity(forProperty("calendarActivity"), inits.get("calendarActivity")) : null;
        this.contact = inits.isInitialized("contact") ? new br.com.kproj.salesman.infrastructure.entity.QContact(forProperty("contact"), inits.get("contact")) : null;
        this.person = inits.isInitialized("person") ? new br.com.kproj.salesman.infrastructure.entity.person.QPerson(forProperty("person"), inits.get("person")) : null;
        this.proposal = inits.isInitialized("proposal") ? new br.com.kproj.salesman.infrastructure.entity.proposal.QBusinessProposal(forProperty("proposal"), inits.get("proposal")) : null;
        this.task = inits.isInitialized("task") ? new br.com.kproj.salesman.infrastructure.entity.task.QTask(forProperty("task"), inits.get("task")) : null;
    }

}

