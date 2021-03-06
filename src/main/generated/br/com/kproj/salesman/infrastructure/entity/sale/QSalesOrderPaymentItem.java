package br.com.kproj.salesman.infrastructure.entity.sale;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSalesOrderPaymentItem is a Querydsl query type for SalesOrderPaymentItem
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSalesOrderPaymentItem extends EntityPathBase<SalesOrderPaymentItem> {

    private static final long serialVersionUID = 299338239L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSalesOrderPaymentItem salesOrderPaymentItem = new QSalesOrderPaymentItem("salesOrderPaymentItem");

    public final br.com.kproj.salesman.infrastructure.entity.QIdentifiable _super = new br.com.kproj.salesman.infrastructure.entity.QIdentifiable(this);

    public final DateTimePath<java.util.Date> dueDate = createDateTime("dueDate", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath observation = createString("observation");

    public final QSalesOrderEntity salesOrder;

    public final NumberPath<java.math.BigDecimal> value = createNumber("value", java.math.BigDecimal.class);

    public QSalesOrderPaymentItem(String variable) {
        this(SalesOrderPaymentItem.class, forVariable(variable), INITS);
    }

    public QSalesOrderPaymentItem(Path<? extends SalesOrderPaymentItem> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSalesOrderPaymentItem(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSalesOrderPaymentItem(PathMetadata metadata, PathInits inits) {
        this(SalesOrderPaymentItem.class, metadata, inits);
    }

    public QSalesOrderPaymentItem(Class<? extends SalesOrderPaymentItem> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.salesOrder = inits.isInitialized("salesOrder") ? new QSalesOrderEntity(forProperty("salesOrder"), inits.get("salesOrder")) : null;
    }

}

