package luiss.it.pdf;

import com.lowagie.text.*;

public abstract class Report extends Document {
	
	public final static String smtpHost = "mail.luiss.it";
	
	public abstract void doIntestazionePagina() throws Exception;
	public abstract void doCorpo() throws Exception;
	public abstract void doPieDiPagina() throws Exception;
	
}
