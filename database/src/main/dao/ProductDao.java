package dao;

import entities.Product;
import support_entities.SessionGetter;

public class ProductDao {
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

    public Product getProduct(Long id) {
        return (Product) SessionGetter.getData(Product.class, id);
    }
}
