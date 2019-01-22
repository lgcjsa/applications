package luiss.it.pdf;

public class ReportBuilder {
	
	public static ReportBuilder getInstance() {
		return new ReportBuilder();
	}
	
	public void build(Report report) throws Exception {
		report.open();
		report.doIntestazionePagina();
		report.doCorpo();
		report.doPieDiPagina();
		report.close();
	}

}
