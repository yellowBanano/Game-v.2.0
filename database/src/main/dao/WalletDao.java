package dao;

import entities.Wallet;
import support_entities.SessionGetter;

public class WalletDao {
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

    public Wallet getWallet(Long id) {
        return (Wallet) SessionGetter.getData(Wallet.class, id);
    }
}
