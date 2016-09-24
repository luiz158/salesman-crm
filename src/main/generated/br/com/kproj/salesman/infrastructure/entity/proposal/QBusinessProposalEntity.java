package br.com.kproj.salesman.infrastructure.entity.proposal;

import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;

import static com.mysema.query.types.PathMetadataFactory.forVariable;


/**
 * QBusinessProposalEntity is a Querydsl query type for BusinessProposalEntity
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QBusinessProposalEntity extends EntityPathBase<BusinessProposalEntity> {

    private static final long serialVersionUID = 1953571842L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBusinessProposalEntity businessProposalEntity = new QBusinessProposalEntity("businessProposalEntity");

    public final br.com.kproj.salesman.infrastructure.entity.QIdentifiable _super = new br.com.kproj.salesman.infrastructure.entity.QIdentifiable(this);

    public final br.com.kproj.salesman.infrastructure.entity.accounts.QAccountEntity account;

    public final StringPath careOf = createString("careOf");

    public final DateTimePath<java.util.Date> deliveryForeCast = createDateTime("deliveryForeCast", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath introduction = createString("introduction");

    public final br.com.kproj.salesman.infrastructure.entity.QOperationRegionEntity operationRegionEntity;

    public final ListPath<ProposalPaymentItem, QProposalPaymentItem> paymentItems = this.<ProposalPaymentItem, QProposalPaymentItem>createList("paymentItems", ProposalPaymentItem.class, QProposalPaymentItem.class, PathInits.DIRECT2);

    public final ListPath<ProposalSaleableItem, QProposalSaleableItem> saleableItems = this.<ProposalSaleableItem, QProposalSaleableItem>createList("saleableItems", ProposalSaleableItem.class, QProposalSaleableItem.class, PathInits.DIRECT2);

    public final br.com.kproj.salesman.infrastructure.entity.QUserEntity seller;

    public final EnumPath<br.com.kproj.salesman.infrastructure.entity.enums.ProposalTemperature> temperature = createEnum("temperature", br.com.kproj.salesman.infrastructure.entity.enums.ProposalTemperature.class);

    public final br.com.kproj.salesman.infrastructure.entity.timeline.QTimeline timeline;

    public QBusinessProposalEntity(String variable) {
        this(BusinessProposalEntity.class, forVariable(variable), INITS);
    }

    public QBusinessProposalEntity(Path<? extends BusinessProposalEntity> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QBusinessProposalEntity(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QBusinessProposalEntity(PathMetadata<?> metadata, PathInits inits) {
        this(BusinessProposalEntity.class, metadata, inits);
    }

    public QBusinessProposalEntity(Class<? extends BusinessProposalEntity> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.account = inits.isInitialized("account") ? new br.com.kproj.salesman.infrastructure.entity.accounts.QAccountEntity(forProperty("account")) : null;
        this.operationRegionEntity = inits.isInitialized("operationRegionEntity") ? new br.com.kproj.salesman.infrastructure.entity.QOperationRegionEntity(forProperty("operationRegionEntity")) : null;
        this.seller = inits.isInitialized("seller") ? new br.com.kproj.salesman.infrastructure.entity.QUserEntity(forProperty("seller"), inits.get("seller")) : null;
        this.timeline = inits.isInitialized("timeline") ? new br.com.kproj.salesman.infrastructure.entity.timeline.QTimeline(forProperty("timeline"), inits.get("timeline")) : null;
    }

}

