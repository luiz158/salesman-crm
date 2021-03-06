package br.com.kproj.salesman.infrastructure.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserPositionEntity is a Querydsl query type for UserPositionEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserPositionEntity extends EntityPathBase<UserPositionEntity> {

    private static final long serialVersionUID = 800260998L;

    public static final QUserPositionEntity userPositionEntity = new QUserPositionEntity("userPositionEntity");

    public final QIdentifiable _super = new QIdentifiable(this);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QUserPositionEntity(String variable) {
        super(UserPositionEntity.class, forVariable(variable));
    }

    public QUserPositionEntity(Path<? extends UserPositionEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserPositionEntity(PathMetadata metadata) {
        super(UserPositionEntity.class, metadata);
    }

}

