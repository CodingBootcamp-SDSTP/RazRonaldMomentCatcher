import java.util.ArrayList;

class ClientCollection
{
	ArrayList<Client> Clients;

	public ClientCollection() {
		clients = new ArrayList<Client>();
	}

	public void addClient(Client client) {
		clients.add(client);
	}

	public void removeClient(Client client) {
		clients.remove(client);
	}

	public ArrayList<Client> getAllClient() {
		return(clients);
	}

	public Client getClientByIndex(int n) {
		return(clients.get(n));
	}

	public int getClientCount() {
		return(clients.size());
	}

	public Client getClientById(String id) {
		Client client = null;
		for(int i=0; i<getClientCount(); i++) {
			if(getClientByIndex(i).getId().equalsIgnoreCase(id)) {
				client = getClientByIndex(i);
			}
		}
		return(client);
	}

	public ArrayList<Client> search(String s) {
		Client c = null;
		ArrayList<Client> cl = new ArrayList<Client>();
		String str = s.toLowerCase();
		for(int i=0; i<getClientCount(); i++) {
			c = getClientByIndex(i);
			if(matches(c, str)) {
				cl.add(c);
			}
		}
		return(cl);
	}

	public boolean matches(Client p, String str) {
		String id = p.getId().toLowerCase();
		String firstName = p.getFirstName().toLowerCase();
		String lastName = p.getLastName().toLowerCase();
		int age = p.getAge();
		String sex = p.getSex().toLowerCase();
		String address = p.getAddress().toLowerCase();
		String a = Integer.toString(age);
		if(id.contains(str) || firstName.contains(str) || lastName.contains(str) || a.contains(str) || sex.contains(str) || address.contains(str)) {
			return(true);
		}
		return(false);
	}
}
