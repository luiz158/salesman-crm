package br.com.kproj.salesman.infrastructure.entity.sale;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSalesOrderItem is a Querydsl query type for SalesOrderItem
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSalesOrderItem extends EntityPathBase<SalesOrderItem> {

    private static final long serialVersionUID = -1109282291L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSalesOrderItem salesOrderItem = new QSalesOrderItem("salesOrderItem");

    public final br.com.kproj.salesman.infrastructure.entity.QIdentifiable _super = new br.com.kproj.salesman.infrastructure.entity.QIdentifiable(this);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<java.math.BigDecimal> originalPrice = createNumber("originalPrice", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> price = createNumber("price", java.math.BigDecimal.class);

    public final NumberPath<Integer> quantity = createNumber("quantity", Integer.class);

    public final br.com.kproj.salesman.infrastructure.entity.saleable.QSaleableUnitEntity saleableUnit;

    public final br.com.kproj.salesman.infrastructure.entity.saleable.QSalePackageEntity salePackage;

    public final QSalesOrderEntity salesOrder;

    public QSalesOrderItem(String variable) {
        this(SalesOrderItem.class, forVariable(variable), INITS);
    }

    public QSalesOrderItem(Path<? extends SalesOrderItem> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSalesOrderItem(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSalesOrderItem(PathMetadata metadata, PathInits inits) {
        this(SalesOrderItem.class, metadata, inits);
    }

    public QSalesOrderItem(Class<? extends SalesOrderItem> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.saleableUnit = inits.isInitialized("saleableUnit") ? new br.com.kproj.salesman.infrastructure.entity.saleable.QSaleableUnitEntity(forProperty("saleableUnit")) : null;
        this.salePackage = inits.isInitialized("salePackage") ? new br.com.kproj.salesman.infrastructure.entity.saleable.QSalePackageEntity(forProperty("salePackage"), inits.get("salePackage")) : null;
        this.salesOrder = inits.isInitialized("salesOrder") ? new QSalesOrderEntity(forProperty("salesOrder"), inits.get("salesOrder")) : null;
    }

}

