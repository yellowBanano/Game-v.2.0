package by.myself.dao;

import by.myself.entities.QWallet;
import by.myself.entities.Wallet;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;

import java.util.List;

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
    public List<Wallet> findAll(Session session) {
        JPAQuery<Wallet> query = new JPAQuery<>(session);
        QWallet wallet = QWallet.wallet;
        query.select(wallet)
                .from(wallet);
        return query.fetchResults().getResults();
    }

    @Override
    public Wallet findById(Session session, Long id) {
        JPAQuery<Wallet> query = new JPAQuery<>();
        QWallet wallet = QWallet.wallet;
        query.select(wallet)
                .from(wallet)
                .where(wallet.id.eq(id));
        return query.fetchOne();
    }
}
