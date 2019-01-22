package luiss.it.pdf;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import com.lowagie.text.Chunk;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;

import luiss.it.TRIENNALI_INT.dao.CdlsceltaId;
import luiss.it.TRIENNALI_INT.dao.Preweb;
import luiss.it.TRIENNALI_INT.dao.PrewebId;
import luiss.it.TRIENNALI_INT.db.ManageCdlscelta;
import luiss.it.TRIENNALI_INT.db.ManagePreweb;

public class StampaDomanda extends ReportGenerico {

	private Preweb preweb;
	
	public StampaDomanda(String anno, String sessione, String codiceFiscale) throws Exception {
		
		PrewebId key = new PrewebId();
		
		key.setAnno(anno);
		key.setSessione(sessione);
		key.setCf(codiceFiscale);
		
		this.preweb = new ManagePreweb().getByID(key);
		
	}
	  
	public void doIntestazionePagina() throws Exception {
		
		super.doIntestazionePagina();
		
		Paragraph paragraph = new Paragraph();
		paragraph.setAlignment(Element.ALIGN_CENTER);
		
		paragraph.add(Chunk.NEWLINE);
		paragraph.add(new Phrase("Undergraduate degree program a.y. 2019/2020",FontFactory.getFont(FontFactory.COURIER,9, Font.BOLD)));
		paragraph.add(Chunk.NEWLINE);
		paragraph.add(Chunk.NEWLINE);
		
		this.add(paragraph);
		
	}
	
	public void doCorpo() throws Exception {
		
		 
		PdfPTable table = new PdfPTable(2);
		table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
		table.setWidthPercentage(100);
		int widths[] = {45,55};
		table.setWidths(widths);

		table.addCell(new Phrase("Name:",FontFactory.getFont(FontFactory.COURIER, 9, Font.COURIER)));
		table.addCell(new Phrase(this.preweb.getPrewebNome(),FontFactory.getFont(FontFactory.COURIER, 9, Font.BOLD)));
		table.addCell(new Phrase("Last Name/Surname:",FontFactory.getFont(FontFactory.COURIER, 9, Font.COURIER)));
		table.addCell(new Phrase(this.preweb.getPrewebCognome(),FontFactory.getFont(FontFactory.COURIER, 9, Font.BOLD)));
		/**
		table.addCell(new Phrase("Tax code:",FontFactory.getFont(FontFactory.COURIER, 9, Font.COURIER)));
		table.addCell(new Phrase(this.preweb.getId().getCf(),FontFactory.getFont(FontFactory.COURIER, 9, Font.BOLD)));
		*/
		table.addCell(new Phrase("Gender:",FontFactory.getFont(FontFactory.COURIER, 9, Font.COURIER)));
		table.addCell(new Phrase(this.preweb.getPrewebSesso(),FontFactory.getFont(FontFactory.COURIER, 9, Font.BOLD)));
		table.addCell(new Phrase("Date of birth:",FontFactory.getFont(FontFactory.COURIER, 9, Font.COURIER)));
		table.addCell(new Phrase(new SimpleDateFormat("MM/dd/yyyy").format(this.preweb.getPrewebNasdata()),FontFactory.getFont(FontFactory.COURIER, 9, Font.BOLD)));
		table.addCell(new Phrase("Place of birth:",FontFactory.getFont(FontFactory.COURIER, 9, Font.COURIER)));
		table.addCell(new Phrase(this.preweb.getPrewebNascom(),FontFactory.getFont(FontFactory.COURIER, 9, Font.BOLD)));
		table.addCell(new Phrase("Country of birth:",FontFactory.getFont(FontFactory.COURIER, 9, Font.COURIER)));
		table.addCell(new Phrase(this.preweb.getPrewebNazione(),FontFactory.getFont(FontFactory.COURIER, 9, Font.BOLD)));
		table.addCell(new Phrase("Nationality:",FontFactory.getFont(FontFactory.COURIER, 9, Font.COURIER)));
		table.addCell(new Phrase(this.preweb.getPrewebNazione(),FontFactory.getFont(FontFactory.COURIER, 9, Font.BOLD)));
		table.addCell(new Phrase("Permanent address:",FontFactory.getFont(FontFactory.COURIER, 9, Font.COURIER)));
		table.addCell(new Phrase(this.preweb.getPrewebResind(),FontFactory.getFont(FontFactory.COURIER, 9, Font.BOLD)));
		table.addCell(new Phrase("City:",FontFactory.getFont(FontFactory.COURIER, 9, Font.COURIER)));
		table.addCell(new Phrase(this.preweb.getPrewebRescom(),FontFactory.getFont(FontFactory.COURIER, 9, Font.BOLD)));
		table.addCell(new Phrase("State/Province:",FontFactory.getFont(FontFactory.COURIER, 9, Font.COURIER)));
		table.addCell(new Phrase(this.preweb.getPrewebStateProvinceRes(),FontFactory.getFont(FontFactory.COURIER, 9, Font.BOLD)));
		table.addCell(new Phrase("Zip/Postal:",FontFactory.getFont(FontFactory.COURIER, 9, Font.COURIER)));
		table.addCell(new Phrase(this.preweb.getPrewebRescap(),FontFactory.getFont(FontFactory.COURIER, 9, Font.BOLD)));
		table.addCell(new Phrase("Country:",FontFactory.getFont(FontFactory.COURIER, 9, Font.COURIER)));
		table.addCell(new Phrase(this.preweb.getPrewebNazioneRes(),FontFactory.getFont(FontFactory.COURIER, 9, Font.BOLD)));
		table.addCell(new Phrase("Telephone:",FontFactory.getFont(FontFactory.COURIER, 9, Font.COURIER)));
		table.addCell(new Phrase(this.preweb.getPrewebTelefono(),FontFactory.getFont(FontFactory.COURIER, 9, Font.BOLD)));
		table.addCell(new Phrase("Mobile:",FontFactory.getFont(FontFactory.COURIER, 9, Font.COURIER)));
		table.addCell(new Phrase(this.preweb.getPrewebCellulare(),FontFactory.getFont(FontFactory.COURIER, 9, Font.BOLD)));
		table.addCell(new Phrase("Email:",FontFactory.getFont(FontFactory.COURIER, 9, Font.COURIER)));
		table.addCell(new Phrase(this.preweb.getPrewebEmail(),FontFactory.getFont(FontFactory.COURIER, 9, Font.BOLD)));
		table.addCell(new Phrase("School attended/attending:",FontFactory.getFont(FontFactory.COURIER, 9, Font.COURIER)));
		table.addCell(new Phrase(this.preweb.getPrewebIstscol(),FontFactory.getFont(FontFactory.COURIER, 9, Font.BOLD)));
		table.addCell(new Phrase("School address:",FontFactory.getFont(FontFactory.COURIER, 9, Font.COURIER)));
		table.addCell(new Phrase(this.preweb.getPrewebIstind(),FontFactory.getFont(FontFactory.COURIER, 9, Font.BOLD)));
		table.addCell(new Phrase("City:",FontFactory.getFont(FontFactory.COURIER, 9, Font.COURIER)));
		table.addCell(new Phrase(this.preweb.getPrewebIstcom(),FontFactory.getFont(FontFactory.COURIER, 9, Font.BOLD)));
		table.addCell(new Phrase("State/Province:",FontFactory.getFont(FontFactory.COURIER, 9, Font.COURIER)));
		table.addCell(new Phrase(this.preweb.getPrewebStateProvinceScuola(),FontFactory.getFont(FontFactory.COURIER, 9, Font.BOLD)));
		table.addCell(new Phrase("Zip/Postal:",FontFactory.getFont(FontFactory.COURIER, 9, Font.COURIER)));
		table.addCell(new Phrase(this.preweb.getPrewebIstcap(),FontFactory.getFont(FontFactory.COURIER, 9, Font.BOLD)));
		table.addCell(new Phrase("Country:",FontFactory.getFont(FontFactory.COURIER, 9, Font.COURIER)));
		table.addCell(new Phrase(this.preweb.getPrewebNazioneScuola(),FontFactory.getFont(FontFactory.COURIER, 9, Font.BOLD)));
		table.addCell(new Phrase("School website:",FontFactory.getFont(FontFactory.COURIER, 9, Font.COURIER)));
		table.addCell(new Phrase(this.preweb.getPrewebWebScuola(),FontFactory.getFont(FontFactory.COURIER, 9, Font.BOLD)));
		table.addCell(new Phrase("Starting date (month/year):",FontFactory.getFont(FontFactory.COURIER, 9, Font.COURIER)));
		table.addCell(new Phrase(this.preweb.getPrewebMmSd() + "/" + this.preweb.getPrewebYyyySd(),FontFactory.getFont(FontFactory.COURIER, 9, Font.BOLD)));
		table.addCell(new Phrase("Graduation date (month/year):",FontFactory.getFont(FontFactory.COURIER, 9, Font.COURIER)));
		table.addCell(new Phrase(this.preweb.getPrewebMmGd() + "/" + this.preweb.getPrewebYyyyGd(),FontFactory.getFont(FontFactory.COURIER, 9, Font.BOLD)));
		table.addCell(new Phrase("Expected graduation date (month/year):",FontFactory.getFont(FontFactory.COURIER, 9, Font.COURIER)));
		table.addCell(new Phrase(this.preweb.getPrewebMmEgd() + "/" + this.preweb.getPrewebYyyyEgd(),FontFactory.getFont(FontFactory.COURIER, 9, Font.BOLD)));
		table.addCell(new Phrase("Type of diploma conferred/to be conferred:",FontFactory.getFont(FontFactory.COURIER, 9, Font.COURIER)));
		table.addCell(new Phrase(this.preweb.getPrewebIsttipo(), FontFactory.getFont(FontFactory.COURIER, 9, Font.BOLD)));
		table.addCell(new Phrase("Primary and secondary education total years:",FontFactory.getFont(FontFactory.COURIER, 9, Font.COURIER)));
		table.addCell(new Phrase(this.preweb.getPrewebAnniScuola(), FontFactory.getFont(FontFactory.COURIER, 9, Font.BOLD)));
		table.addCell(new Phrase("SAT Total Score:",FontFactory.getFont(FontFactory.COURIER, 9, Font.COURIER)));
		table.addCell(new Phrase(new DecimalFormat("####").format(this.preweb.getPrewebTotale()),FontFactory.getFont(FontFactory.COURIER, 9, Font.BOLD)));
		table.addCell(new Phrase("ACT Total Score:",FontFactory.getFont(FontFactory.COURIER, 9, Font.COURIER)));
		table.addCell(new Phrase(new DecimalFormat("####").format(this.preweb.getPrewebAct()),FontFactory.getFont(FontFactory.COURIER, 9, Font.BOLD)));
		table.addCell(new Phrase("Other qualifications (Languages/ECDL) - 1:",FontFactory.getFont(FontFactory.COURIER, 9, Font.COURIER)));
		table.addCell(new Phrase(this.preweb.getPrewebAltreQualifiche1(), FontFactory.getFont(FontFactory.COURIER, 9, Font.BOLD)));
		table.addCell(new Phrase("Other qualifications (Languages/ECDL) - 2:",FontFactory.getFont(FontFactory.COURIER, 9, Font.COURIER)));
		table.addCell(new Phrase(this.preweb.getPrewebAltreQualifiche2(), FontFactory.getFont(FontFactory.COURIER, 9, Font.BOLD)));
		table.addCell(new Phrase("Other qualifications (Languages/ECDL) - 3:",FontFactory.getFont(FontFactory.COURIER, 9, Font.COURIER)));
		table.addCell(new Phrase(this.preweb.getPrewebAltreQualifiche3(), FontFactory.getFont(FontFactory.COURIER, 9, Font.BOLD)));
		table.addCell(new Phrase("Course chosen:",FontFactory.getFont(FontFactory.COURIER, 9, Font.COURIER)));
		CdlsceltaId scelta = new CdlsceltaId();
		scelta.setFac(this.preweb.getPrewebFac());
		scelta.setCds(this.preweb.getPrewebCorsolau());
		table.addCell(new Phrase((new ManageCdlscelta().getByID(scelta).getDescrizione()),FontFactory.getFont(FontFactory.COURIER, 9, Font.BOLD)));
		
		this.add(table);
		 
	}
	
	public void doPieDiPagina() throws Exception {

		String testo = "";
		
		Paragraph paragraph = new Paragraph();		
		paragraph.add(Chunk.NEWLINE);
		this.add(paragraph);

		testo = "I the undersigned declare that I have read the Call for Applications published on the University’s website.";
		paragraph.add(new Phrase(testo,FontFactory.getFont(FontFactory.COURIER, 7, Font.ITALIC)));		
		this.add(paragraph);
		
		this.add(new Phrase("Declaration in lieu of certification",FontFactory.getFont(FontFactory.COURIER, 7, Font.BOLDITALIC)));		

		paragraph = new Paragraph();
		paragraph.setLeading(7);
		paragraph.setAlignment(Element.ALIGN_JUSTIFIED);		
		testo = "Pursuant to Presidential Decree No. 445 of 28 December 2000 I, the undersigned, hereby declare that the data set out in this form is true, that I am aware of the criminal implications of making declarations that are false, untrue or no longer true and that I am further aware that the data set out in this form may be checked by LUISS University in order to establish the veracity thereof.";
		paragraph.add(new Phrase(testo,FontFactory.getFont(FontFactory.COURIER, 7, Font.ITALIC)));
		paragraph.add(Chunk.NEWLINE);
		paragraph.add(Chunk.NEWLINE);
		this.add(paragraph);
		
		this.add(new Phrase("Privacy statement",FontFactory.getFont(FontFactory.COURIER, 7, Font.BOLDITALIC)));		
		paragraph = new Paragraph();
		paragraph.setLeading(7);
		paragraph.setAlignment(Element.ALIGN_JUSTIFIED);		
		testo = "I, the undersigned, declare that I have read the privacy statement on the processing of personal data at the following link http://www.luiss.edu/admissions/undergraduate-admissions/privacy-statement \r\n" + 
				"I hereby consent to the processing of my personal data for promotional purposes."; 
				
				
		paragraph.add(new Phrase(testo,FontFactory.getFont(FontFactory.COURIER, 7, Font.ITALIC)));
		this.add(paragraph);
   		
	}
	
}
