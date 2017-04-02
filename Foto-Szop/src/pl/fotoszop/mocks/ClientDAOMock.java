package pl.fotoszop.mocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import pl.fotoszop.dao.ClientDAO;
import pl.fotoszop.model.Client;
import pl.fotoszop.modelinterfaces.IClient;

public class ClientDAOMock implements ClientDAO {
	private ArrayList<Client> clients = new ArrayList<Client>();

	public ClientDAOMock() {
	Client[] clientExample = 
		{
				new Client(1,"Janusz","Podsiadlo","Warszawa 12","95684717896","56565544565","jano@o2.pl"),
				new Client(2,"Zenek","Wito","Krakow 12","458642","95684717812","zenus@ogmail.pl"),
				new Client(3,"Franio","Nowak","Skarzynskiego 12","96065254786","56565544565","aadsas@o2.pl"),
				new Client(4,"Kuba","Kowalski","Witolda 11","96065251236","56565544565","kubson@o2.pl"),
				new Client(5,"Zdzisek","Zdunczyk","Casdasda 8","96065259996","56565544565","ads@o2.pl"),
				new Client(6,"Janek","Grak","Nienaszow 5","96065211111","56565544565","jan@o2.pl")
		};
	
	this.clients.addAll(Arrays.asList(clientExample));
	}
	
	@Override
	public void saveOrUpdate(IClient client) {
		for(int i =0; i< this.clients.size();i++)
		{
			if(this.clients.get(i).getId() == client.getId() )
			{
				this.clients.remove(i);
				break;				
			}
		}
		this.clients.add((Client) client);
		
	}

	@Override
	public void delete(int clientId) {
		for (Client c : this.clients)
		{
			if(c.getId() == clientId)
			{
				this.clients.remove(c);
			}
		}
	}

	@Override
	public IClient getClientById(int clientId) {
		
		for (Client c : this.clients)
		{
			if(c.getId() == clientId)
			{
				return c;
			}
		}
		
		return null;
	}

	@Override
	public Collection<IClient> getAllContacts() {
		return this.clients.stream().map(x->(IClient) x).collect(Collectors.toList());
	}

}
