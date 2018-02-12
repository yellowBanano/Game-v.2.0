package by.myself;

import by.myself.dao.ProductDao;

public class ProductService {

    private static ProductService INSTANCE;

    public static ProductService getInstance() {
        if (INSTANCE == null) {
            synchronized (ProductService.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ProductService();
                }
            }
        }
        return INSTANCE;
    }

    private ProductService() {
    }

    public ProductDao getProductDao() {
        return ProductDao.getInstance();
    }
}
