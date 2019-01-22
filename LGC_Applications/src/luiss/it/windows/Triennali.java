package luiss.it.windows;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Button;
import org.zkoss.zul.Captcha;
import org.zkoss.zul.Fileupload;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Textbox;

import luiss.it.LGCDB_Clienti.dao.Nazioni;
import luiss.it.LGCDB_Clienti.dao.Sedi;
import luiss.it.LGCDB_Clienti.db.ManageSedi;
import luiss.it.Orientamento.dao.MiurScuole;
import luiss.it.Orientamento.dao.MiurTipiScuole;
import luiss.it.Orientamento.db.ManageMiurScuole;
import luiss.it.TRIENNALI.dao.Diplomi;
import luiss.it.TRIENNALI.db.ManageDiplomi;
import luiss.it.TRIENNALI_INT.dao.Cdlscelta;
import luiss.it.TRIENNALI_INT.db.ManageCdlscelta;

@SuppressWarnings("serial")
public class Triennali extends Index {

	private List<String> regioni_scuole;
	private List<String> province_scuole;
	private List<String> comuni_scuole;
	private List<MiurTipiScuole> tipi_scuole;
	private List<MiurScuole> scuole_miur;
	private List<Diplomi> diplomi;
	private List<Cdlscelta> cds;
	private Media[] media = new Media[3];
	private List<Sedi> sedi;

	private String regione_selezionata;
	private String provincia_selezionata;
	private String comune_selezionato;
	private MiurTipiScuole tipo_selezionato;
	private MiurScuole scuola_selezionata;

	public Triennali() {

		super();

		this.regioni_scuole = new ManageMiurScuole().getRegioni();
		this.province_scuole = new ArrayList<String>();
		this.comuni_scuole = new ArrayList<String>();
		this.tipi_scuole = new ArrayList<MiurTipiScuole>();
		this.scuole_miur = new ArrayList<MiurScuole>();
		this.diplomi = new ManageDiplomi().getAll();
		this.cds = new ManageCdlscelta().getAll();
		this.sedi = new ManageSedi().getByID_Contesti(this.getContesto().getId());

	}

	public List<Sedi> getSedi() {
		return sedi;
	}

	public void setSedi(List<Sedi> sedi) {
		this.sedi = sedi;
	}

	public List<Cdlscelta> getCds() {
		return cds;
	}

	public void setCds(List<Cdlscelta> cds) {
		this.cds = cds;
	}

	public List<Diplomi> getDiplomi() {
		return diplomi;
	}

	public void setDiplomi(List<Diplomi> diplomi) {
		this.diplomi = diplomi;
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

		Executions.sendRedirect(this.getConfig().getUrlOk());

	}

	public void titoloStraniero(Radio radio) {

		if (radio.getLabel().equals("No")) {

			Listbox nazioni = this.getListbox("ordinamento_nazione");

			Iterator<Listitem> i = nazioni.getItems().iterator();

			while (i.hasNext()) {
				Listitem item = i.next();
				Nazioni nazione = item.getValue();
				if (nazione.getNazione().trim().toUpperCase().equals("ITALIA")) {
					item.setSelected(true);
				}
			}
		}

	}

	public void upload(Button button) {

		Media[] media = Fileupload.get(-1);

		for (int i = 0; i < media.length; i++) {
			
			if (button.getLabel().equals(this.getLabel(168))) {

				this.media[0] = media[i];
				Iframe frame = (Iframe) this.getFellow("allegato_sat");
				frame.setContent(this.media[0]);
				this.getFellow("row_allegato_sat").setVisible(true);
			
			}
			
			if (button.getLabel().equals(this.getLabel(173))) {

				this.media[1] = media[i];
				Iframe frame = (Iframe) this.getFellow("allegato_act");
				frame.setContent(this.media[1]);
				this.getFellow("row_allegato_act").setVisible(true);
			
			}
			
			if (button.getLabel().equals(this.getLabel(175))) {

				this.media[2] = media[i];
				Iframe frame = (Iframe) this.getFellow("allegato_ecdl_eipass");
				frame.setContent(this.media[2]);
				this.getFellow("row_allegato_ecdl_eipass").setVisible(true);
			
			}

		}

	}

	public void rigenera() {
		
		Captcha captcha = (Captcha) this.getFellow("captcha");
		String str = RandomStringUtils.randomAlphabetic(5);
		captcha.setValue(str);
		
	}

	public void selezioneSAT(Radio radio) {

		this.getFellow("div_sat_01").setVisible(radio.getLabel().equals("Si"));
		this.getFellow("div_sat_02").setVisible(radio.getLabel().equals("Si"));
		this.getFellow("div_sat_03").setVisible(radio.getLabel().equals("Si"));
		
		if (radio.getLabel().equals("No")) {
			
			Iframe frame = (Iframe) this.getFellow("allegato_sat");
			frame.setContent(null);
			this.media[0] = null;
			this.getFellow("row_allegato_sat").setVisible(false);
			
		}

	}

	public void selezioneACT(Radio radio) {

		this.getFellow("div_act_01").setVisible(radio.getLabel().equals("Si"));
		this.getFellow("div_act_02").setVisible(radio.getLabel().equals("Si"));
		this.getFellow("div_act_03").setVisible(radio.getLabel().equals("Si"));

		if (radio.getLabel().equals("No")) {

			Iframe frame = (Iframe) this.getFellow("allegato_act");
			frame.setContent(null);
			this.media[1] = null;
			this.getFellow("row_allegato_act").setVisible(false);

		}

	}

	public void selezioneECDL_EIPASS(Radio radio) {

		this.getFellow("div_ecdl_eipass_01").setVisible(radio.getLabel().equals("Si"));
		this.getFellow("div_ecdl_eipass_02").setVisible(radio.getLabel().equals("Si"));
		this.getFellow("div_ecdl_eipass_03").setVisible(radio.getLabel().equals("Si"));

		if (radio.getLabel().equals("No")) {

			Iframe frame = (Iframe) this.getFellow("allegato_ecdl_eipass");
			frame.setContent(null);
			this.media[2] = null;
			this.getFellow("row_allegato_ecdl_eipass").setVisible(false);

		}

	}

}
