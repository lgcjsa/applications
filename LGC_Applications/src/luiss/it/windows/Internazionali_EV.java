package luiss.it.windows;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.zkoss.lang.Library;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Fileupload;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Radiogroup;

import luiss.it.Attachments.dao.Allegati;
import luiss.it.Attachments.db.ManageAllegati;
import luiss.it.LGCDB_Clienti.dao.NazioniEng;
import luiss.it.LGCDB_Clienti.dao.Province;
import luiss.it.LGCDB_Clienti.db.ManageTokens;
import luiss.it.TRIENNALI_INT.dao.Cdlscelta;
import luiss.it.TRIENNALI_INT.dao.CdlsceltaId;
import luiss.it.TRIENNALI_INT.dao.Preweb;
import luiss.it.TRIENNALI_INT.dao.PrewebId;
import luiss.it.TRIENNALI_INT.db.ManageCdlscelta;
import luiss.it.TRIENNALI_INT.db.ManagePreweb;
import luiss.it.mail.EmailHtml;
import luiss.it.mail.Mail;
import luiss.it.mail.db.ManageTesti;

@SuppressWarnings("serial")
public class Internazionali_EV extends Index {

	private List<String> diplomi;
	private Media allegati[] = new Media[10];
	private String des_allegati[] = new String[10];
	private List<Cdlscelta> cds;

	public Internazionali_EV() {

		super();

		this.diplomi = new ArrayList<String>();

		if (this.getContesto().getCodice().equals("CINA")) {

			this.diplomi.add("Other Qualification");
			this.diplomi.add("General Certificate of Education (6 different subjects, at least 3 of which must be A levels relevant to the degree course selected)");
			this.diplomi.add("GAO KAO");
			this.diplomi.add("IB diploma");
			
		}

		if (this.getContesto().getCodice().equals("VIETNAM")) {

			this.diplomi.add("Other Qualification");
			this.diplomi.add("International Baccalaureat");
			this.diplomi.add("Ky Thi Tot Nghiep Pho Thong Trung Hoc");
			
		}

		this.des_allegati[1] = "SAT";
		this.des_allegati[2] = "ACT";
		this.des_allegati[3] = "CV";
		this.des_allegati[4] = "Motivation letter";
		this.des_allegati[5] = "Reference letter";
		this.des_allegati[6] = "Transcript";
		this.des_allegati[7] = "Upload Other qualification - 1";
		this.des_allegati[8] = "Upload Other qualification - 2";
		this.des_allegati[9] = "Upload Other qualification - 3";

		this.cds = new ManageCdlscelta().getAll();

		Library.setProperty("org.zkoss.theme.preferred", "iceblue");

	}

	public List<Cdlscelta> getCds() {
		return cds;
	}

	public void setCds(List<Cdlscelta> cds) {
		this.cds = cds;
	}

	public List<String> getDiplomi() {
		return diplomi;
	}

	public void setDiplomi(List<String> diplomi) {
		this.diplomi = diplomi;
	}

	public void conferma() throws Exception {

		super.controlloObbigatorieta();

		System.out.println("Metodo conferma della Classe Internazionali_EV");

		Preweb preweb = new Preweb();

		preweb.setPrewebNome(this.getTextboxValue("nome").trim().toUpperCase());
		preweb.setPrewebCognome(this.getTextboxValue("cognome").trim().toUpperCase());
		preweb.setPrewebSesso(this.getRadiogroup("sesso").getSelectedItem().getLabel());
		preweb.setPrewebNasdata(this.getDatebox("data_nascita").getValue());
		preweb.setPrewebNascom(this.getTextboxValue("nas_luogo").trim());

		if (this.getListbox("nas_provincia").getSelectedItem() != null) {
			Province provincia = (Province) this.getListbox("nas_provincia").getSelectedItem().getValue();
			preweb.setPrewebNaspr(provincia.getSigla());
		} else {
			preweb.setPrewebNaspr("EE");
		}

		NazioniEng nazione = (NazioniEng) this.getListbox("nas_nazione").getSelectedItem().getValue();
		preweb.setPrewenNazioneNascita(nazione.getNazione());
		nazione = (NazioniEng) this.getListbox("nazionalita").getSelectedItem().getValue();
		preweb.setPrewebNazione(nazione.getNazione());
		preweb.setPrewebRescom(this.getTextboxValue("city").trim());
		preweb.setPrewebResind(this.getTextboxValue("permanent_address").trim());
		preweb.setPrewebRescap(this.getTextboxValue("zip").trim());
		preweb.setPrewebStateProvinceRes(this.getTextboxValue("state_province").trim());
		nazione = (NazioniEng) this.getListbox("country").getSelectedItem().getValue();
		preweb.setPrewebNazioneRes(nazione.getNazione());
		preweb.setPrewebCellulare(this.getTextboxValue("mobile").trim());
		preweb.setPrewebTelefono(this.getTextboxValue("telephone").trim());
		preweb.setPrewebEmail(this.getTextboxValue("e_mail").trim());
		preweb.setPrewebIstscol(this.getTextboxValue("school").trim());
		preweb.setPrewebIstcom(this.getTextboxValue("school_city").trim());
		preweb.setPrewebIstind(this.getTextboxValue("school_address").trim());
		preweb.setPrewebStateProvinceScuola(this.getTextboxValue("school_state_province").trim());
		preweb.setPrewebIstcap(this.getTextboxValue("school_zip").trim());
		nazione = (NazioniEng) this.getListbox("school_country").getSelectedItem().getValue();
		preweb.setPrewebNazioneScuola(nazione.getNazione());
		String tipoDiploma = this.getListbox("type_diploma").getSelectedItem().getValue();
		preweb.setPrewebIsttipo(tipoDiploma);
		preweb.setPrewebEuNoneu("non-EU");
		preweb.setPrewebMedia3("000.00");
		preweb.setPrewebMedia4("000.00");
		preweb.setPrewebWebScuola(this.getTextboxValue("school_web_site").trim());
		preweb.setPrewebMmSd(
				new SimpleDateFormat("yyyy-MM").format(this.getDatebox("starting_date").getValue()).substring(5));
		preweb.setPrewebYyyySd(
				new SimpleDateFormat("yyyy-MM").format(this.getDatebox("starting_date").getValue()).substring(0, 4));
		preweb.setPrewebMmEgd(new SimpleDateFormat("yyyy-MM")
				.format(this.getDatebox("expected_graduation_date").getValue()).substring(5));
		preweb.setPrewebYyyyEgd(new SimpleDateFormat("yyyy-MM")
				.format(this.getDatebox("expected_graduation_date").getValue()).substring(0, 4));
		preweb.setPrewebMmGd(
				new SimpleDateFormat("yyyy-MM").format(this.getDatebox("graduation_date").getValue()).substring(5));
		preweb.setPrewebYyyyGd(
				new SimpleDateFormat("yyyy-MM").format(this.getDatebox("graduation_date").getValue()).substring(0, 4));
		preweb.setPrewebAnniScuola(((Radiogroup) this.getFellow("totalYear")).getSelectedItem().getLabel());

		preweb.setPrewebTotale(this.getIntbox("totale").getValue());
		preweb.setPrewebAct(this.getIntbox("totale_act").getValue());

		preweb.setPrewebAltreQualifiche1(this.getTextboxValue("altro1"));
		preweb.setPrewebAltreQualifiche2(this.getTextboxValue("altro2"));
		preweb.setPrewebAltreQualifiche3(this.getTextboxValue("altro3"));

		Cdlscelta scelta = (Cdlscelta) this.getListbox("scelta_cds").getSelectedItem().getValue();
		CdlsceltaId sceltaId = scelta.getId();
		preweb.setPrewebFac(sceltaId.getFac());
		preweb.setPrewebCorsolau(sceltaId.getCds());

		preweb.setPrewebDatadomanda(Date.valueOf(this.getDataCorrente()));
		preweb.setPrewebDatamod(Date.valueOf(this.getDataCorrente()));

		PrewebId keyPreweb = new PrewebId();

		DecimalFormat df = new DecimalFormat("00");

		keyPreweb.setAnno("2019");
		keyPreweb.setSessione(df.format(this.getContesto().getId()));
		keyPreweb.setCf(this.getTextboxValue("codice_fiscale"));

		preweb.setId(keyPreweb);

		if (this.getRadiogroup("privacy").getSelectedItem().getLabel().equals("Yes")) {
			preweb.setPrewebPrivacy("S");
		} else {
			preweb.setPrewebPrivacy("N");
		}

		@SuppressWarnings("unchecked")
		Class<Preweb> c = (Class<luiss.it.TRIENNALI_INT.dao.Preweb>) Class.forName("luiss.it.TRIENNALI_INT.dao.Preweb");
		Field campi[] = c.getDeclaredFields();

		for (int i = 0; i < campi.length; i++) {

			Field campoCorrente = campi[i];

			if (campoCorrente.getType().toString().endsWith("String")) {

				String metodo = "get" + campoCorrente.getName().substring(0, 1).toUpperCase()
						+ campoCorrente.getName().substring(1);
				Method currentMethod = c.getMethod(metodo);

				String str = (String) currentMethod.invoke(preweb, null);

				if (str == null) {

					metodo = "set" + campoCorrente.getName().substring(0, 1).toUpperCase()
							+ campoCorrente.getName().substring(1);
					currentMethod = c.getMethod(metodo, new Class[] { new String().getClass() });

					str = new String("");
					currentMethod.invoke(preweb, str);

				}

			}

			if (campoCorrente.getType().toString().endsWith("Integer")) {

				String metodo = "get" + campoCorrente.getName().substring(0, 1).toUpperCase()
						+ campoCorrente.getName().substring(1);
				Method currentMethod = c.getMethod(metodo);

				Integer str = (Integer) currentMethod.invoke(preweb, null);

				if (str == null) {

					metodo = "set" + campoCorrente.getName().substring(0, 1).toUpperCase()
							+ campoCorrente.getName().substring(1);
					currentMethod = c.getMethod(metodo, new Class[] { new Integer(0).getClass() });

					str = new Integer(0);
					currentMethod.invoke(preweb, str);

				}

			}
			/*
			 * System.out.println("Nome: " + campoCorrente.getName());
			 * System.out.println("Tipo: " + campoCorrente.getType());
			 */
		}

		if (new ManagePreweb().getByID(keyPreweb) == null) {

			new ManagePreweb().insert(preweb);
			new ManageTokens().delete(this.getToken());

			for (int i = 1; i <= 9; i++) {

				if (this.getIframe("image_" + i).getContent() != null) {

					Media image = (Media) this.getIframe("image_" + i).getContent();

					Allegati allegato = new Allegati();
					allegato.setCodiceFiscale(preweb.getId().getCf());
					allegato.setContentType(image.getContentType());
					allegato.setFormat(image.getFormat());
					allegato.setDescrizione(this.des_allegati[i]);
					allegato.setAllegato(image.getByteData());
					allegato.setDataInserimento(new Timestamp(System.currentTimeMillis()));

					new ManageAllegati().insert(allegato);

				}

			}

			Mail mail = new EmailHtml();
			mail.setOggetto("LUISS Guido Carli Application");
			mail.setFrom("ammissione@luiss.it");

			if (this.getContesto().getCodice().equals("CINA")) {

				mail.setTesto(new StringBuffer(new ManageTesti().getByID(6).getTesto()));
				mail.sendTo(preweb.getPrewebEmail());

			}

			if (this.getContesto().getCodice().equals("VIETNAM")) {

				mail.setTesto(new StringBuffer(new ManageTesti().getByID(7).getTesto()));
				mail.sendTo(preweb.getPrewebEmail());

			}

			Executions.sendRedirect(this.getConfig().getUrlOk());

		} else {
			Messagebox.show(this.getLabel(111), "Warning", Messagebox.OK, Messagebox.EXCLAMATION);
			Executions.sendRedirect(this.getConfig().getUrlKo());
		}

	}

	public void upload(int intero) {

		System.out.println("Upload allegato " + this.des_allegati[intero]);

		Media[] media = Fileupload.get(-1);

		for (int i = 0; i < media.length; i++) {

			this.allegati[intero] = media[i];

			Iframe frame = (Iframe) this.getFellow("image_" + intero);
			frame.setContent(media[i]);
			Clients.resize(this.getFellow("image_" + intero));
			Clients.resize(this.getFellow("row_" + intero));
			this.getFellow("row_" + intero).setVisible(true);

		}

	}

	private String getDataCorrente() {

		DecimalFormat df = new DecimalFormat("00");
		GregorianCalendar dataOdierna = new GregorianCalendar();

		return dataOdierna.get(Calendar.YEAR) + "-" + df.format(dataOdierna.get(Calendar.MONTH) + 1) + "-"
				+ df.format(dataOdierna.get(Calendar.DAY_OF_MONTH));

	}

	public static void main(String args[]) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		@SuppressWarnings("unchecked")
		Class<Preweb> c = (Class<luiss.it.TRIENNALI_INT.dao.Preweb>) Class.forName("luiss.it.TRIENNALI_INT.dao.Preweb");
		Field campi[] = c.getDeclaredFields();

		for (int i = 0; i < campi.length; i++) {

			Field campoCorrente = campi[i];
			System.out.println("Nome: " + campoCorrente.getName());
			System.out.println("Tipo: " + campoCorrente.getType());
			String metodo = "set" + campoCorrente.getName().substring(0, 1).toUpperCase()
					+ campoCorrente.getName().substring(1);
			System.out.println("Metodo: " + metodo);
			if (campoCorrente.getType().toString().endsWith("String")) {

				Preweb p = new Preweb();
				metodo = "get" + campoCorrente.getName().substring(0, 1).toUpperCase()
						+ campoCorrente.getName().substring(1);
				Method currentMethod = c.getMethod(metodo);
				System.out.println(currentMethod.toString());
				String str = (String) currentMethod.invoke(p, null);
				System.out.println(str);

				metodo = "set" + campoCorrente.getName().substring(0, 1).toUpperCase()
						+ campoCorrente.getName().substring(1);
				currentMethod = c.getMethod(metodo, new Class[] { new String().getClass() });
				System.out.println(currentMethod.toString());

				str = new String("");
				currentMethod.invoke(p, str);

			}

		}

	}

}
