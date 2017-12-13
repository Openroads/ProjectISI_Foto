package pl.fotoszop.dto;

import pl.fotoszop.modelinterfaces.IAccount;
import pl.fotoszop.modelinterfaces.IPerson;

public class AccountAndAssociatedPerson {
	private IAccount account;
	private IPerson person;
	
	public IAccount getAccount() {
		return account;
	}
	public void setAccount(IAccount account) {
		this.account = account;
	}
	public IPerson getPerson() {
		return person;
	}
	public void setPerson(IPerson person) {
		this.person = person;
	}
	
	
	
}
