package pl.fotoszop.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import pl.fotoszop.DAODbImpl.AccountDAODbImpl;
import pl.fotoszop.model.Account;
import pl.fotoszop.modelinterfaces.IAccount;

import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RegistrationTest {
    @Autowired
    private AccountDAODbImpl acc;

    @Autowired
    private Account account;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        acc = mock(AccountDAODbImpl.class);
        account = new Account();
        account.setAccountId(1);
        account.setLogin("pieterm4@wp.pl");
        account.setPassword("1234567890");
        account.setClientId(2);


        Collection<IAccount> accounts = new ArrayList<>();

        accounts.add(account);
        accounts.add(account);
        accounts.add(account);

        when(acc.saveOrUpdate(account)).thenReturn(0);
        when(acc.getAccountByLogin(account.getLogin())).thenReturn(account);
        when(acc.getAllAccounts(1)).thenReturn(accounts);


    }


    @Test
    public void GivenRegistrationService_WhenFormIsEmpty_OutputError() {
        Collection<IAccount> accounts = new ArrayList<>();

        accounts.add(account);
        accounts.add(account);
        accounts.add(account);

        Assert.assertEquals(accounts, acc.getAllAccounts(1));

    }

    @Test
    public void GivenLogin_WhenGettingAccountByLogin_OutputAccountLogin() {
        Account result = (Account) acc.getAccountByLogin("pieterm4@wp.pl");

        Assert.assertEquals("pieterm4@wp.pl", result.getLogin());
    }
}
