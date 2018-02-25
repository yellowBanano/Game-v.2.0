package by.myself.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QType is a Querydsl query type for Type
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QType extends EntityPathBase<Type> {

    private static final long serialVersionUID = 1147367976L;

    public static final QType type = new QType("type1");

    public final QBaseEntity _super = new QBaseEntity(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    public final SetPath<Product, QProduct> products = this.<Product, QProduct>createSet("products", Product.class, QProduct.class, PathInits.DIRECT2);

    public QType(String variable) {
        super(Type.class, forVariable(variable));
    }

    public QType(Path<? extends Type> path) {
        super(path.getType(), path.getMetadata());
    }

    public QType(PathMetadata metadata) {
        super(Type.class, metadata);
    }

}

