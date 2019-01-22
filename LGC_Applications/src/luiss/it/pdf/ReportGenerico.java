package luiss.it.pdf;

import java.net.URL;
import com.lowagie.text.*;

public abstract class ReportGenerico extends Report {
	
	private Image logo;
	
	public void doIntestazionePagina() throws Exception {
		
		this.logo = Image.getInstance(new URL("http://localhost:8080/LGC_Applications/images/logo.jpg"));
		this.logo.scalePercent(70);
		this.logo.setAlignment(Image.ALIGN_LEFT);
		this.add(this.logo);
		
	}

}
