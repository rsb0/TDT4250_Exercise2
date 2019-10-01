package tdt4250.unitConverter.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

import org.osgi.service.component.annotations.*;
import org.osgi.service.http.whiteboard.propertytypes.HttpWhiteboardServletPattern;
import tdt4250.unitConverter.api.ConversionResult;
import tdt4250.unitConverter.api.Unit;
import tdt4250.unitConverter.api.Converter;
import org.osgi.framework.BundleContext;


@Component
@HttpWhiteboardServletPattern("/conversion/*")
public class ConversionServlet extends HttpServlet implements Servlet {
	
	private static final String VALID_QUERY = "[a-z]\\d+(\\.\\d+)?[a-z]";
	private static final long serialVersionUID = 1L;
	private Converter converter = new Converter();
	
	@Reference(
			cardinality = ReferenceCardinality.MULTIPLE,
			policy = ReferencePolicy.DYNAMIC,
			bind = "addUnit",
			unbind = "removeUnit"
			)
	public void addUnit(Unit unit) {
		converter.addUnit(unit);
	}
	public void removeUnit(Unit unit) {
		converter.addUnit(unit);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String q = request.getParameter("q").toLowerCase();
		if(q.matches(VALID_QUERY)) {
			ConversionResult result = converter.convert(q);
			writer.print(result.getMessage());
		} else {
			writer.print(q + " is not a valid searchterm");
		}
		
	}

}