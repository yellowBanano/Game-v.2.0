package by.myself.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDiscount is a Querydsl query type for Discount
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDiscount extends EntityPathBase<Discount> {

    private static final long serialVersionUID = -598855377L;

    public static final QDiscount discount1 = new QDiscount("discount1");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<Double> discount = createNumber("discount", Double.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final SetPath<Product, QProduct> products = this.<Product, QProduct>createSet("products", Product.class, QProduct.class, PathInits.DIRECT2);

    public QDiscount(String variable) {
        super(Discount.class, forVariable(variable));
    }

    public QDiscount(Path<? extends Discount> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDiscount(PathMetadata metadata) {
        super(Discount.class, metadata);
    }

}

