package br.com.kproj.salesman.infrastructure.entity.assistants.calendar;

import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;

import static com.mysema.query.types.PathMetadataFactory.forVariable;


/**
 * QPeriod is a Querydsl query type for Period
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPeriod extends EntityPathBase<PeriodEntity> {

    private static final long serialVersionUID = 1307816263L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPeriod period = new QPeriod("period");

    public final br.com.kproj.salesman.infrastructure.entity.QIdentifiable _super = new br.com.kproj.salesman.infrastructure.entity.QIdentifiable(this);

    public final QCalendarActivity calendarActivity;

    public final DateTimePath<java.util.Date> endDate = createDateTime("endDate", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isAllDay = createBoolean("isAllDay");

    public final DateTimePath<java.util.Date> startDate = createDateTime("startDate", java.util.Date.class);

    public QPeriod(String variable) {
        this(PeriodEntity.class, forVariable(variable), INITS);
    }

    public QPeriod(Path<? extends PeriodEntity> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPeriod(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPeriod(PathMetadata<?> metadata, PathInits inits) {
        this(PeriodEntity.class, metadata, inits);
    }

    public QPeriod(Class<? extends PeriodEntity> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.calendarActivity = inits.isInitialized("calendarActivity") ? new QCalendarActivity(forProperty("calendarActivity"), inits.get("calendarActivity")) : null;
    }

}

