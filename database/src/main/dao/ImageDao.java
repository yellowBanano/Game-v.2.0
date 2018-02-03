package dao;

import entities.Image;
import support_entities.SessionGetter;

public class ImageDao {
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

    public Image getImage(Long id) {
        return (Image) SessionGetter.getData(Image.class, id);
    }
}
