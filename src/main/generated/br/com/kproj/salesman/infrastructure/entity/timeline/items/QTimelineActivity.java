package br.com.kproj.salesman.infrastructure.entity.timeline.items;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTimelineActivity is a Querydsl query type for TimelineActivity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTimelineActivity extends EntityPathBase<TimelineActivity> {

    private static final long serialVersionUID = -1897898148L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTimelineActivity timelineActivity = new QTimelineActivity("timelineActivity");

    public final br.com.kproj.salesman.infrastructure.entity.QIdentifiable _super = new br.com.kproj.salesman.infrastructure.entity.QIdentifiable(this);

    public final DateTimePath<java.util.Date> creation = createDateTime("creation", java.util.Date.class);

    public final StringPath description = createString("description");

    public final ListPath<br.com.kproj.salesman.infrastructure.entity.AppFileEntity, br.com.kproj.salesman.infrastructure.entity.QAppFileEntity> files = this.<br.com.kproj.salesman.infrastructure.entity.AppFileEntity, br.com.kproj.salesman.infrastructure.entity.QAppFileEntity>createList("files", br.com.kproj.salesman.infrastructure.entity.AppFileEntity.class, br.com.kproj.salesman.infrastructure.entity.QAppFileEntity.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<TimelineActivity.TagEntity> tag = createEnum("tag", TimelineActivity.TagEntity.class);

    public final br.com.kproj.salesman.infrastructure.entity.timeline.QTimelineEntity timeline;

    public final br.com.kproj.salesman.infrastructure.entity.QUserEntity user;

    public QTimelineActivity(String variable) {
        this(TimelineActivity.class, forVariable(variable), INITS);
    }

    public QTimelineActivity(Path<? extends TimelineActivity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTimelineActivity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTimelineActivity(PathMetadata metadata, PathInits inits) {
        this(TimelineActivity.class, metadata, inits);
    }

    public QTimelineActivity(Class<? extends TimelineActivity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.timeline = inits.isInitialized("timeline") ? new br.com.kproj.salesman.infrastructure.entity.timeline.QTimelineEntity(forProperty("timeline")) : null;
        this.user = inits.isInitialized("user") ? new br.com.kproj.salesman.infrastructure.entity.QUserEntity(forProperty("user"), inits.get("user")) : null;
    }

}

