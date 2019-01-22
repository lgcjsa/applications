package luiss.it.windows;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Textbox;

import luiss.it.LGCDB_Clienti.dao.Comuni;
import luiss.it.Orientamento.dao.DipartimentiScelteGo;
import luiss.it.Orientamento.dao.Go;
import luiss.it.Orientamento.dao.MiurScuole;
import luiss.it.Orientamento.dao.MiurTipiScuole;
import luiss.it.Orientamento.dao.PeriodiGo;
import luiss.it.Orientamento.db.ManageDipartimentiScelteGo;
import luiss.it.Orientamento.db.ManageGo;
import luiss.it.Orientamento.db.ManageMiurScuole;
import luiss.it.Orientamento.db.ManagePeriodiGo;
import luiss.it.mail.Mail;
import luiss.it.mail.MailGO;

@SuppressWarnings("serial")
public class GO extends Index {

	private List<PeriodiGo> giornate;
	private List<String> regioni_scuole;
	private List<String> province_scuole;
	private List<String> comuni_scuole;
	private List<MiurTipiScuole> tipi_scuole;
	private List<MiurScuole> scuole_miur;

	private String regione_selezionata;
	private String provincia_selezionata;
	private String comune_selezionato;
	private MiurTipiScuole tipo_selezionato;
	private MiurScuole scuola_selezionata;

	public GO() {

		super();

		this.giornate = new ManagePeriodiGo().getAll();
		this.regioni_scuole = new ManageMiurScuole().getRegioni();
		this.province_scuole = new ArrayList<String>();
		this.comuni_scuole = new ArrayList<String>();
		this.tipi_scuole = new ArrayList<MiurTipiScuole>();
		this.scuole_miur = new ArrayList<MiurScuole>();

	}

	public List<MiurScuole> getScuole_miur() {
		return scuole_miur;
	}

	public void setScuole_miur(List<MiurScuole> scuole_miur) {
		this.scuole_miur = scuole_miur;
	}

	public List<String> getProvince_scuole() {
		return province_scuole;
	}

	public void setProvince_scuole(List<String> province_scuole) {
		this.province_scuole = province_scuole;
	}

	public List<String> getComuni_scuole() {
		return comuni_scuole;
	}

	public void setComuni_scuole(List<String> comuni_scuole) {
		this.comuni_scuole = comuni_scuole;
	}

	public List<MiurTipiScuole> getTipi_scuole() {
		return tipi_scuole;
	}

	public void setTipi_scuole(List<MiurTipiScuole> tipi_scuole) {
		this.tipi_scuole = tipi_scuole;
	}

	public List<String> getRegioni_scuole() {
		return regioni_scuole;
	}

	public void setRegioni_scuole(List<String> regioni_scuole) {
		this.regioni_scuole = regioni_scuole;
	}

	public List<PeriodiGo> getGiornate() {
		return giornate;
	}

	public void setGiornate(List<PeriodiGo> giornate) {
		this.giornate = giornate;
	}

	public void selezioneRegioneScuola(Listitem selected) {

		this.regione_selezionata = selected.getValue();

		Listbox province = this.getListbox("province_scuole");
		province.setModel(new ListModelList<String>(new ManageMiurScuole().getProvince(this.regione_selezionata)));

		Listbox comuni = this.getListbox("comuni_scuole");
		comuni.setModel(new ListModelList<String>(new ArrayList<String>()));

		Listbox tipi = this.getListbox("tipi_scuole");
		tipi.setModel(new ListModelList<String>(new ArrayList<String>()));

		Listbox scuole = this.getListbox("scuole");
		scuole.setModel(new ListModelList<MiurScuole>(new ArrayList<MiurScuole>()));

		((Textbox) this.getFellow("des_scuola")).setValue("");
		((Textbox) this.getFellow("des_scuola")).setReadonly(true);

	}

	public void selezioneProvinciaScuola(Listitem selected) {

		this.provincia_selezionata = selected.getValue();

		Listbox comuni = this.getListbox("comuni_scuole");
		comuni.setModel(new ListModelList<String>(
				new ManageMiurScuole().getComuni(this.regione_selezionata, this.provincia_selezionata)));

		Listbox tipi = this.getListbox("tipi_scuole");
		tipi.setModel(new ListModelList<String>(new ArrayList<String>()));

		Listbox scuole = this.getListbox("scuole");
		scuole.setModel(new ListModelList<MiurScuole>(new ArrayList<MiurScuole>()));

		((Textbox) this.getFellow("des_scuola")).setValue("");
		((Textbox) this.getFellow("des_scuola")).setReadonly(true);

	}

	public void selezioneComuneScuola(Listitem selected) {

		this.comune_selezionato = selected.getValue();

		Listbox tipi = this.getListbox("tipi_scuole");
		tipi.setModel(new ListModelList<MiurTipiScuole>(new ManageMiurScuole().getTipiScuole(this.regione_selezionata,
				this.provincia_selezionata, this.comune_selezionato)));

		Listbox scuole = this.getListbox("scuole");
		scuole.setModel(new ListModelList<MiurScuole>(new ArrayList<MiurScuole>()));

		((Textbox) this.getFellow("des_scuola")).setValue("");
		((Textbox) this.getFellow("des_scuola")).setReadonly(true);

	}

	public void selezioneTipoScuola(Listitem selected) {

		this.tipo_selezionato = selected.getValue();

		Listbox scuole = this.getListbox("scuole");
		scuole.setModel(new ListModelList<MiurScuole>(new ManageMiurScuole().getScuole(this.regione_selezionata,
				this.provincia_selezionata, this.comune_selezionato, this.tipo_selezionato)));

		((Textbox) this.getFellow("des_scuola")).setValue("");
		((Textbox) this.getFellow("des_scuola")).setReadonly(true);

	}

	public void selezioneScuola(Listitem selected) {

		this.scuola_selezionata = selected.getValue();

		if (this.scuola_selezionata.getIdScuola() == 9999998) {
			((Textbox) this.getFellow("des_scuola")).setReadonly(false);
		} else {
			((Textbox) this.getFellow("des_scuola")).setValue(this.scuola_selezionata.getDenominazione());
		}

	}

	public void conferma() throws Exception {

		super.controlloObbigatorieta();
		
		Listbox comune = this.getListbox("nas_comune");

		System.out.println("Metodo conferma della Classe GO");

		Go go = new Go();

		go.setNome(this.getTextboxValue("nome").trim().toUpperCase());
		go.setCognome(this.getTextboxValue("cognome").trim().toUpperCase());

		go.setDataNascita(this.getDatebox("data_nascita").getValue());

		Radiogroup sesso = (Radiogroup) this.getFellow("sesso");

		go.setSesso(sesso.getSelectedItem().getLabel().toUpperCase());
		go.setLuogoNascita(this.getTextboxValue("nas_luogo"));
		
		if (comune.getSelectedItem() != null) {
			go.setComuneNascita(((Comuni) comune.getSelectedItem().getValue()).getId());
		}
		

		go.setEmail(this.getTextboxValue("email").trim());
		go.setCellulare(this.getTextboxValue("telefono").trim());

		Listbox scuole = this.getListbox("scuole");

		MiurScuole scuola = ((MiurScuole) scuole.getSelectedItem().getValue());

		go.setIdScuole(scuola.getIdScuola());
		go.setScuolaDenominazione(scuola.getDenominazione());
		go.setScuolaComune(scuola.getComune());
		go.setScuolaIndirizzo(scuola.getIndirizzo());
		go.setScuolaProvincia(scuola.getTarga());
		go.setScuolaCap(scuola.getCap());
		go.setTipoScuolaCod(scuola.getTipoScuolaMiurCod());

		Radiogroup anno = (Radiogroup) this.getFellow("anno");

		go.setAnnoFrequenza(anno.getSelectedItem().getLabel());

		Listbox data_go = this.getListbox("date_go");

		go.setIdPeriodiGo(((PeriodiGo) data_go.getSelectedItem().getValue()).getId());

		Checkbox em = ((Checkbox) getFellow("EM"));
		Checkbox cs = ((Checkbox) getFellow("CS"));
		Checkbox eb = ((Checkbox) getFellow("EB"));
		Checkbox sp = ((Checkbox) getFellow("SP"));
		Checkbox gp = ((Checkbox) getFellow("GP"));

		boolean flag = false;

		if (em.isChecked()) {
			flag = true;
		}

		if (cs.isChecked()) {
			flag = true;
		}

		if (eb.isChecked()) {
			flag = true;
		}
		if (sp.isChecked()) {
			flag = true;
		}

		if (gp.isChecked()) {
			flag = true;
		}
		if (!flag) {
			throw new WrongValueException(((Checkbox) getFellow("EM")), this.getLabel(47));
		}

		go.setPresente("N");
		go.setCodiceFiscale(this.getTextboxValue("codice_fiscale"));
		go.setDataInsert(new Timestamp(System.currentTimeMillis()));
		go.setPrivacy(((Radiogroup) getFellow("privacy")).getSelectedItem().getLabel().substring(0, 1));

		if (new ManageGo().exists(go)) {
			throw new WrongValueException(((Listbox) getFellow("date_go")), this.getLabel(111));
		}

		new ManageGo().insert(go);

		Iterator<DipartimentiScelteGo> i = new ManageDipartimentiScelteGo().getByIdGo(go.getId()).iterator();

		while (i.hasNext()) {
			new ManageDipartimentiScelteGo().delete(i.next());
		}

		if (em.isChecked()) {

			DipartimentiScelteGo dsgo = new DipartimentiScelteGo();
			dsgo.setIdGo(go.getId());
			dsgo.setDipartimento("Economia e management");
			new ManageDipartimentiScelteGo().insert(dsgo);

		}

		if (sp.isChecked()) {

			DipartimentiScelteGo dsgo = new DipartimentiScelteGo();
			dsgo.setIdGo(go.getId());
			dsgo.setDipartimento("Scienze Politiche");
			new ManageDipartimentiScelteGo().insert(dsgo);

		}

		if (gp.isChecked()) {

			DipartimentiScelteGo dsgo = new DipartimentiScelteGo();
			dsgo.setIdGo(go.getId());
			dsgo.setDipartimento("Giurisprudenza");
			new ManageDipartimentiScelteGo().insert(dsgo);

		}

		if (eb.isChecked()) {

			DipartimentiScelteGo dsgo = new DipartimentiScelteGo();
			dsgo.setIdGo(go.getId());
			dsgo.setDipartimento("Economics and Business");
			new ManageDipartimentiScelteGo().insert(dsgo);

		}

		if (cs.isChecked()) {

			DipartimentiScelteGo dsgo = new DipartimentiScelteGo();
			dsgo.setIdGo(go.getId());
			dsgo.setDipartimento("Management and Computer Science");
			new ManageDipartimentiScelteGo().insert(dsgo);

		}
		
		int id = go.getId(); 
		
		go = new ManageGo().getByID(id);
		
		String testo = "Non rispondere a questa email in quanto generata in modo automatico."  + "<br>" +
						"<br>" + 
				        "Ti confermiamo la registrazione per la Giornata di Orientamento di " + new ManagePeriodiGo().getByID(go.getIdPeriodiGo()).getDescrizione() +  "." + "<br>" +
				        "Iscrizione di " + go.getNome() + " " + go.getCognome() + " codice fiscale " + go.getCodiceFiscale()  + "." + "<br>" +
				        "Ti aspettiamo." + "<br>" +
				        "<br>" + 
				        "Cordiali saluti" + "<br>" + 
				        "Ufficio Orientamento - LUISS Guido Carli";
		
		Mail mail = new MailGO();
		mail.setOggetto("Conferma d'iscrizione alla giornata d'orientamento");
		mail.setFrom("no-reply@luiss.it");
		mail.setTesto(new StringBuffer(testo));
		mail.sendTo(go.getEmail());

		Executions.sendRedirect(this.getConfig().getUrlOk());

	}

}
