package by.myself.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCreditCard is a Querydsl query type for CreditCard
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCreditCard extends EntityPathBase<CreditCard> {

    private static final long serialVersionUID = -1076105705L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCreditCard creditCard = new QCreditCard("creditCard");

    public final QPayment _super;

    public final StringPath cvv = createString("cvv");

    public final DatePath<java.time.LocalDate> expireDate = createDate("expireDate", java.time.LocalDate.class);

    //inherited
    public final NumberPath<Long> id;

    public final StringPath serialNumber = createString("serialNumber");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> time;

    // inherited
    public final QWallet wallet;

    public QCreditCard(String variable) {
        this(CreditCard.class, forVariable(variable), INITS);
    }

    public QCreditCard(Path<? extends CreditCard> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCreditCard(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCreditCard(PathMetadata metadata, PathInits inits) {
        this(CreditCard.class, metadata, inits);
    }

    public QCreditCard(Class<? extends CreditCard> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QPayment(type, metadata, inits);
        this.id = _super.id;
        this.time = _super.time;
        this.wallet = _super.wallet;
    }

}

