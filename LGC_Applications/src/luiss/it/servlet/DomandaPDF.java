package luiss.it.servlet;

import java.io.IOException;
import java.io.ByteArrayOutputStream;
import javax.servlet.http.*;
import javax.servlet.*;

import luiss.it.pdf.Report;
import luiss.it.pdf.ReportBuilder;
import luiss.it.pdf.StampaDomanda;


import com.lowagie.text.pdf.*;


public class DomandaPDF extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    	
		Report report;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		try {
			report = new StampaDomanda(request.getParameter("anno"), request.getParameter("sessione"), request.getParameter("cf"));
			PdfWriter.getInstance(report, baos);
			ReportBuilder.getInstance().build(report);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.setContentType("application/pdf");
		response.setContentLength(baos.size());
    	ServletOutputStream sos = response.getOutputStream();
    	baos.writeTo(sos);
    	sos.flush();
    	response.flushBuffer();

    }

}