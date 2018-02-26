package by.myself.dao;

import by.myself.entities.Product;
import by.myself.entities.QProduct;
import by.myself.utils.entities.Sort;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;

import java.util.List;

public class  ProductDao extends BaseDao<Product> {

    private static ProductDao INSTANCE;

    public static ProductDao getInstance() {
        if (INSTANCE == null) {
            synchronized (ProductDao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ProductDao();
                }
            }
        }
        return INSTANCE;
    }

    private ProductDao() {
    }

    public List<Product> searchProducts(Session session, String userQuery, int limit, int offset, Sort typeOfSorting) {
        JPAQuery<Product> query = new JPAQuery<>(session);
        QProduct product = QProduct.product;
        query.select(product)
                .from(product)
                .where(product.name.containsIgnoreCase(userQuery)
                        .or(product.producer.containsIgnoreCase(userQuery))
//                        .or(product.cost.eq(Double.valueOf(userQuery)))
                )
                .limit(limit)
                .offset(offset);

        if (typeOfSorting.equals(Sort.NAMEASC)) {
            query.orderBy(product.name.asc());
        } else if (typeOfSorting.equals(Sort.COSTASC)) {
            query.orderBy(product.cost.asc());
        } else if (typeOfSorting.equals(Sort.COSTDESC)) {
            query.orderBy(product.cost.desc());
        } else if (typeOfSorting.equals(Sort.NAMEDESC)) {
            query.orderBy(product.name.desc());
        } else {
            query.orderBy(product.name.asc());
        }

        return query.fetchResults().getResults();
    }

    @Override
    protected Class<Product> getEntityClass() {
        return Product.class;
    }
}
