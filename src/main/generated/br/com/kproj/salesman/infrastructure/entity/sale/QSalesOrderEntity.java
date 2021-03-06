package br.com.kproj.salesman.infrastructure.entity.sale;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSalesOrderEntity is a Querydsl query type for SalesOrderEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSalesOrderEntity extends EntityPathBase<SalesOrderEntity> {

    private static final long serialVersionUID = -988003235L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSalesOrderEntity salesOrderEntity = new QSalesOrderEntity("salesOrderEntity");

    public final br.com.kproj.salesman.infrastructure.entity.QIdentifiable _super = new br.com.kproj.salesman.infrastructure.entity.QIdentifiable(this);

    public final br.com.kproj.salesman.infrastructure.entity.person.QPerson client;

    public final DateTimePath<java.util.Date> creationDate = createDateTime("creationDate", java.util.Date.class);

    public final DateTimePath<java.util.Date> deliveryForecast = createDateTime("deliveryForecast", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final br.com.kproj.salesman.infrastructure.entity.QOperationRegionEntity operationRegionEntity;

    public final ListPath<SalesOrderPaymentItem, QSalesOrderPaymentItem> paymentItems = this.<SalesOrderPaymentItem, QSalesOrderPaymentItem>createList("paymentItems", SalesOrderPaymentItem.class, QSalesOrderPaymentItem.class, PathInits.DIRECT2);

    public final br.com.kproj.salesman.infrastructure.entity.proposal.QBusinessProposalEntity proposal;

    public final ListPath<SalesOrderItem, QSalesOrderItem> salesOrderItems = this.<SalesOrderItem, QSalesOrderItem>createList("salesOrderItems", SalesOrderItem.class, QSalesOrderItem.class, PathInits.DIRECT2);

    public final br.com.kproj.salesman.infrastructure.entity.QUserEntity seller;

    public final BooleanPath taskGenerated = createBoolean("taskGenerated");

    public QSalesOrderEntity(String variable) {
        this(SalesOrderEntity.class, forVariable(variable), INITS);
    }

    public QSalesOrderEntity(Path<? extends SalesOrderEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSalesOrderEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSalesOrderEntity(PathMetadata metadata, PathInits inits) {
        this(SalesOrderEntity.class, metadata, inits);
    }

    public QSalesOrderEntity(Class<? extends SalesOrderEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.client = inits.isInitialized("client") ? new br.com.kproj.salesman.infrastructure.entity.person.QPerson(forProperty("client"), inits.get("client")) : null;
        this.operationRegionEntity = inits.isInitialized("operationRegionEntity") ? new br.com.kproj.salesman.infrastructure.entity.QOperationRegionEntity(forProperty("operationRegionEntity")) : null;
        this.proposal = inits.isInitialized("proposal") ? new br.com.kproj.salesman.infrastructure.entity.proposal.QBusinessProposalEntity(forProperty("proposal"), inits.get("proposal")) : null;
        this.seller = inits.isInitialized("seller") ? new br.com.kproj.salesman.infrastructure.entity.QUserEntity(forProperty("seller"), inits.get("seller")) : null;
    }

}

