package by.myself.dao;

import by.myself.entities.Wallet;

public class WalletDao extends BaseDao<Wallet> {

    private static WalletDao INSTANCE;

    public static WalletDao getInstance() {
        if (INSTANCE == null) {
            synchronized (WalletDao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new WalletDao();
                }
            }
        }
        return INSTANCE;
    }

    private WalletDao() {
    }

    @Override
    protected Class<Wallet> getEntityClass() {
        return Wallet.class;
    }
}
