package pl.fotoszop.dao;

import pl.fotoszop.modelinterfaces.IAccount;

import java.util.Collection;

public interface AccountDAO {

    /**
     * @param account
     */

    public IAccount getAccountByLogin(String login);

    public int saveOrUpdate(IAccount account);

    public Collection<IAccount> getAllAccounts(int id);

}
