package by.myself.dao;

import by.myself.entities.Image;

public class ImageDao extends BaseDao<Image> {

    private static ImageDao INSTANCE;

    public static ImageDao getInstance() {
        if (INSTANCE == null) {
            synchronized (ImageDao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ImageDao();
                }
            }
        }
        return INSTANCE;
    }

    private ImageDao() {
    }

    @Override
    protected Class<Image> getEntityClass() {
        return Image.class;
    }
}
