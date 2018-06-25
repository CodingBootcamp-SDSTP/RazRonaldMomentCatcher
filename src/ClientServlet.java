import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ClientServlet extends HttpServlet
{
	MomentManagerDatabase mmd;
	ClientCollection clients;

	public void init() throws ServletException {
		mmd = new MomentManagerDatabase();
		clients = mmd.getClientCollection();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/xml");
		PrintWriter out = res.getWriter();
		out.print(exportToXML());
	}

	public String exportToXML() {
		StringBuilder sb = new StringBuilder("<clients>");
		ArrayList<Client> customer = clients.getAllClients();
		for(Client c : customer) {
			sb.append("<client><clientid>");
			sb.append(c.getId());
			sb.append("</clientid><firstname>");
			sb.append(c.getFirstName());
			sb.append("</firstname><lastname>");
			sb.append(c.getLastName());
			sb.append("</lastname><age>");
			sb.append(c.getAge());
			sb.append("</age><sex>");
			sb.append(c.getSex());
			sb.append("</sex><address>");
			sb.append(c.getAddress());
			sb.append("</address></client>");
		}
		sb.append("</clients>");
		return(sb.toString());
	}

	public void destroy() {
		mmd = null;
		clients = null;
	}
}
