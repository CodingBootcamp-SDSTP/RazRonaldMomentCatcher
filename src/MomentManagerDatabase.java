import java.util.ArrayList;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class MomentManagerDatabase
{
	private PhotographerCollection photographers;
	private ClientCollection clients;

	public MomentManagerDatabase() {
		photographers = new PhotographerCollection();
		clients = new ClientCollection();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/momentcatcher?user=razr&password=p4ssw0rd&serverTimezone=UTC&useSSL=false");
			readFromDB(conn);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public PhotographerCollection getPhotographerCollection() {
		return(photographers);
	}

	public ClientCollection getClientCollection() {
		return(clients);
	}

	public Photographer getPhotographerById(String id) {
		return(photographers.getPhotographerById(id));
	}


	public Client getClientById(String id) {
		return(clients.getClientById(id));
	}

	public ArrayList<Object> search(String s) {
		ArrayList<Object> ol = new ArrayList<Object>();
		ArrayList<Person> pl = photographers.search(s);
		ArrayList<Location> cl = clients.search(s);
		ao.addAll(pl);
		ao.addAll(cl);
		return(ol);
	}

	public boolean readFromDB(Connection conn) {
		System.out.println("readFromDB******************..");
		Statement stmt = null;
		ResultSet rs = null;
		boolean b = false;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM photographers;");
			while(rs.next()) {
				String[] str = {
					rs.getString("pid"),
					rs.getString("fname"),
					rs.getString("lname"),
					rs.getString("age"),
					rs.getString("sex"),
					rs.getString("address"),
					"photographers"
				};
				createObject(str);
			}
			rs = stmt.executeQuery("SELECT * FROM clients;");
			while(rs.next()) {
				String[] str = {
					rs.getString("cid"),
					rs.getString("fname"),
					rs.getString("lname"),
					rs.getString("age"),
					rs.getString("sex"),
					rs.getString("address"),
					"clients"
				};
				createObject(str);
			}
			b = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try { if(stmt!=null) {stmt=null;}} catch(Exception e) {};
			try { if(rs!=null) {rs=null;}} catch(Exception e) {};
		}
		return(true);
	}

	public void createObject(String... details) {
		int len = details.length-1;
		String d = details[len];
		if("photographers".equals(d)) {
			Photographer p = new Photographer(details[0], details[1], details[2], Integer.parseInt(details[3]), details[4], details[5]);
			persons.addPerson(p);
		}
		else if("clients".equals(d)) {
			Client c = new Client(details[0], details[1], details[2], Integer.parseInt(details[3]), details[4], details[5]);
			locations.addLocation(l);
		}
	}

	public String getCollectionContent() {
		ArrayList<Photographer> p = photographers.getAllPhotographers();
		ArrayList<Client> c = clients.getAllClients();
		StringBuffer sb = new StringBuffer("");
		for(int i = 0; i < p.size(); i++) {
			Photographer photographer = p.get(i);
			sb.append(photographer.getDetails() + "\n");
		}
		for(int i = 0; i < c.size(); i++) {
			Client client = c.get(i);
			sb.append(client.getDetails() + "\n");
		}
		return(sb.toString());
	}
}
