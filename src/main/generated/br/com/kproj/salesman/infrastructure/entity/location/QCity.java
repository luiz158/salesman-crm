package br.com.kproj.salesman.infrastructure.entity.location;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QCity is a Querydsl query type for City
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QCity extends EntityPathBase<City> {

    private static final long serialVersionUID = -482766219L;

    public static final QCity city = new QCity("city");

    public final br.com.kproj.salesman.infrastructure.entity.QIdentifiable _super = new br.com.kproj.salesman.infrastructure.entity.QIdentifiable(this);

    public final StringPath code = createString("code");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    public final StringPath stateAcronym = createString("stateAcronym");

    public QCity(String variable) {
        super(City.class, forVariable(variable));
    }

    public QCity(Path<? extends City> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCity(PathMetadata<?> metadata) {
        super(City.class, metadata);
    }

}

