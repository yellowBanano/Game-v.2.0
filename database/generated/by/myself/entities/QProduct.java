package by.myself.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProduct is a Querydsl query type for Product
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProduct extends EntityPathBase<Product> {

    private static final long serialVersionUID = -1861625023L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProduct product = new QProduct("product");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<Integer> amount = createNumber("amount", Integer.class);

    public final NumberPath<Double> cost = createNumber("cost", Double.class);

    public final QDiscount discount;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final QImage image;

    public final SetPath<Material, QMaterial> materials = this.<Material, QMaterial>createSet("materials", Material.class, QMaterial.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final SetPath<Order, QOrder> orders = this.<Order, QOrder>createSet("orders", Order.class, QOrder.class, PathInits.DIRECT2);

    public final StringPath producer = createString("producer");

    public final StringPath provider = createString("provider");

    public final NumberPath<Integer> size = createNumber("size", Integer.class);

    public final SetPath<Type, QType> types = this.<Type, QType>createSet("types", Type.class, QType.class, PathInits.DIRECT2);

    public QProduct(String variable) {
        this(Product.class, forVariable(variable), INITS);
    }

    public QProduct(Path<? extends Product> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProduct(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProduct(PathMetadata metadata, PathInits inits) {
        this(Product.class, metadata, inits);
    }

    public QProduct(Class<? extends Product> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.discount = inits.isInitialized("discount") ? new QDiscount(forProperty("discount")) : null;
        this.image = inits.isInitialized("image") ? new QImage(forProperty("image"), inits.get("image")) : null;
    }

}

