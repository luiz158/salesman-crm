package br.com.kproj.salesman.infrastructure.entity.proposal.requestapproval;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRequestApprovalEntity is a Querydsl query type for RequestApprovalEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRequestApprovalEntity extends EntityPathBase<RequestApprovalEntity> {

    private static final long serialVersionUID = 190164748L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRequestApprovalEntity requestApprovalEntity = new QRequestApprovalEntity("requestApprovalEntity");

    public final br.com.kproj.salesman.infrastructure.entity.QIdentifiable _super = new br.com.kproj.salesman.infrastructure.entity.QIdentifiable(this);

    public final ListPath<ApprovalItemEntity, QApprovalItemEntity> approvers = this.<ApprovalItemEntity, QApprovalItemEntity>createList("approvers", ApprovalItemEntity.class, QApprovalItemEntity.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final br.com.kproj.salesman.infrastructure.entity.proposal.QBusinessProposalEntity proposal;

    public final br.com.kproj.salesman.infrastructure.entity.QUserEntity userRequester;

    public QRequestApprovalEntity(String variable) {
        this(RequestApprovalEntity.class, forVariable(variable), INITS);
    }

    public QRequestApprovalEntity(Path<? extends RequestApprovalEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRequestApprovalEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRequestApprovalEntity(PathMetadata metadata, PathInits inits) {
        this(RequestApprovalEntity.class, metadata, inits);
    }

    public QRequestApprovalEntity(Class<? extends RequestApprovalEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.proposal = inits.isInitialized("proposal") ? new br.com.kproj.salesman.infrastructure.entity.proposal.QBusinessProposalEntity(forProperty("proposal"), inits.get("proposal")) : null;
        this.userRequester = inits.isInitialized("userRequester") ? new br.com.kproj.salesman.infrastructure.entity.QUserEntity(forProperty("userRequester"), inits.get("userRequester")) : null;
    }

}

