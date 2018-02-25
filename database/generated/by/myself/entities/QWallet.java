package by.myself.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QWallet is a Querydsl query type for Wallet
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QWallet extends EntityPathBase<Wallet> {

    private static final long serialVersionUID = -1122356377L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QWallet wallet = new QWallet("wallet");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<Double> amount = createNumber("amount", Double.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final SetPath<Payment, QPayment> payments = this.<Payment, QPayment>createSet("payments", Payment.class, QPayment.class, PathInits.DIRECT2);

    public final QUser user;

    public QWallet(String variable) {
        this(Wallet.class, forVariable(variable), INITS);
    }

    public QWallet(Path<? extends Wallet> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QWallet(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QWallet(PathMetadata metadata, PathInits inits) {
        this(Wallet.class, metadata, inits);
    }

    public QWallet(Class<? extends Wallet> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

