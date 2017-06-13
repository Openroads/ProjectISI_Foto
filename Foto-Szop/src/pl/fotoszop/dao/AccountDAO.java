package pl.fotoszop.dao;

import pl.fotoszop.modelinterfaces.IAccount;

import java.util.Collection;

public interface AccountDAO {

    /**
     * @param account
     */

    IAccount getAccountByLogin(String login);

    int saveOrUpdate(IAccount account);

    Collection<IAccount> getAllAccounts();

}
