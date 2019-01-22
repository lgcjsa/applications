package luiss.it.windows;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.AbstractComponent;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zul.Button;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Fileupload;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Image;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import luiss.it.LGCDB_Clienti.dao.Comuni;
import luiss.it.LGCDB_Clienti.dao.Config;
import luiss.it.LGCDB_Clienti.dao.Contesti;
import luiss.it.LGCDB_Clienti.dao.Controlli;
import luiss.it.LGCDB_Clienti.dao.MiurScuole;
import luiss.it.LGCDB_Clienti.dao.MiurTipiScuole;
import luiss.it.LGCDB_Clienti.dao.Nazioni;
import luiss.it.LGCDB_Clienti.dao.NazioniEng;
import luiss.it.LGCDB_Clienti.dao.Persone;
import luiss.it.LGCDB_Clienti.dao.Province;
import luiss.it.LGCDB_Clienti.dao.Regioni;
import luiss.it.LGCDB_Clienti.dao.TipiTitoloSup;
import luiss.it.LGCDB_Clienti.dao.Tokens;
import luiss.it.LGCDB_Clienti.db.ManageComuni;
import luiss.it.LGCDB_Clienti.db.ManageConfig;
import luiss.it.LGCDB_Clienti.db.ManageContesti;
import luiss.it.LGCDB_Clienti.db.ManageControlli;
import luiss.it.LGCDB_Clienti.db.ManageLabels;
import luiss.it.LGCDB_Clienti.db.ManageLingue;
import luiss.it.LGCDB_Clienti.db.ManageMiurTipiScuole;
import luiss.it.LGCDB_Clienti.db.ManageNazioni;
import luiss.it.LGCDB_Clienti.db.ManageNazioniENG;
import luiss.it.LGCDB_Clienti.db.ManageProvince;
import luiss.it.LGCDB_Clienti.db.ManageRegioni;
import luiss.it.LGCDB_Clienti.db.ManageTipiTitoloSup;
import luiss.it.LGCDB_Clienti.db.ManageTokens;
import luiss.it.beans.GeneratoreCodiceFiscale;
import luiss.it.beans.GeneratoreCodiceFiscaleException;

@SuppressWarnings("serial")
public class Index extends Window {

	private int lingua;
	private String codice_lingua;
	private List<Nazioni> nazioni;
	private List<NazioniEng> nazioniEng;
	private List<Regioni> regioni;
	private List<Province> province;
	private List<Comuni> comuni;
	private Contesti contesto;
	private Config config;
	private List<MiurTipiScuole> tipiScuole;
	private List<TipiTitoloSup> tipiTitolo;
	private List<MiurScuole> scuole;
	private String pagina;
	private Media fotografia;
	private Persone persona;
	private String opzionali[] = new String[1];
	private List<Controlli> controlli;
	private Tokens token;

	public Tokens getToken() {
		return token;
	}

	public void setToken(Tokens token) {
		this.token = token;
	}

	public List<NazioniEng> getNazioniEng() {
		return nazioniEng;
	}

	public void setNazioniEng(List<NazioniEng> nazioniEng) {
		this.nazioniEng = nazioniEng;
	}

	public List<Controlli> getControlli() {
		return controlli;
	}

	public void setControlli(List<Controlli> controlli) {
		this.controlli = controlli;
	}

	public String[] getOpzionali() {
		return opzionali;
	}

	public void setOpzionali(String[] opzionali) {
		this.opzionali = opzionali;
	}

	public Persone getPersona() {
		return persona;
	}

	public void setPersona(Persone persona) {
		this.persona = persona;
	}

	public Media getFotografia() {
		return fotografia;
	}

	public void setFotografia(Media fotografia) {
		this.fotografia = fotografia;
	}

	public String getPagina() {
		return pagina;
	}

	public void setPagina(String pagina) {
		this.pagina = pagina;
	}

	private boolean visibilitaResidenza;
	private boolean visibilitaRecapiti;
	private boolean visibilitaDiploma;
	private boolean visibilitaLaurea;
	private boolean visibilitaGenitore;
	private boolean visibilitaFotografia;

	public Index() {

		String lingua = Executions.getCurrent().getParameter("lingua");
		String contesto = Executions.getCurrent().getParameter("contesto");

		this.contesto = new ManageContesti().getByCodice(contesto);
		this.config = new ManageConfig().getByID(this.contesto.getId());

		this.visibilitaResidenza = this.config.getResidenza().equals("S");
		this.visibilitaRecapiti = this.config.getRecapiti().equals("S");
		this.visibilitaLaurea = this.config.getLaurea().equals("S");
		this.visibilitaDiploma = this.config.getDiploma().equals("S");
		this.visibilitaGenitore = this.config.getGenitore().equals("S");
		this.visibilitaFotografia = this.config.getFotografia().equals("S");

		this.lingua = lingua == null ? 1 : Integer.parseInt(lingua);
		this.codice_lingua = new ManageLingue().getByID(this.lingua).getCodice();
		this.nazioni = new ManageNazioni().getAll();
		this.nazioniEng = new ManageNazioniENG().getAll();
		this.regioni = new ArrayList<Regioni>();
		this.province = new ArrayList<Province>();
		this.comuni = new ArrayList<Comuni>();
		this.scuole = new ArrayList<MiurScuole>();
		this.tipiScuole = new ManageMiurTipiScuole().getAll();
		this.tipiTitolo = new ManageTipiTitoloSup().getAll();
		this.controlli = new ManageControlli().getAll(this.contesto.getId());
				
		this.setBorder(false);		

	}

	public void calcolaCodiceFiscale() {
		System.out.println("Calcolo del codice fiscale");
	}

	public void selezioneNazione(Listitem selected, String id) {

		System.out.println(id);

		Nazioni nazione = (Nazioni) selected.getValue();
		String prefix = id.substring(0, 3);
		this.regioni = new ManageRegioni().getByID_Nazione(nazione.getId());

		Listbox list = (Listbox) this.getFellow(prefix + "_regione");
		list.setModel(new ListModelList<Regioni>(this.regioni));

		this.reset(prefix + "_provincia");
		this.reset(prefix + "_comune");
		((Textbox) this.getFellow(prefix + "_luogo")).setValue("");

		if (nazione.getId() != 1) {
			((Textbox) this.getFellow(prefix + "_luogo")).setReadonly(false);
		} else {
			((Textbox) this.getFellow(prefix + "_luogo")).setReadonly(true);
		}

	}

	public void selezioneNazioneEng(Listitem selected, String id) {

		System.out.println(id);

		NazioniEng nazione = (NazioniEng) selected.getValue();
		String prefix = id.substring(0, 3);
		this.regioni = new ManageRegioni().getByID_Nazione(nazione.getId());

		Listbox list = (Listbox) this.getFellow(prefix + "_regione");
		list.setModel(new ListModelList<Regioni>(this.regioni));

		this.reset(prefix + "_provincia");
		this.reset(prefix + "_comune");
		((Textbox) this.getFellow(prefix + "_luogo")).setValue("");

		if (nazione.getId() != 1) {
			((Textbox) this.getFellow(prefix + "_luogo")).setReadonly(false);
		} else {
			((Textbox) this.getFellow(prefix + "_luogo")).setReadonly(true);
		}

	}

	public void selezioneRegione(Listitem selected, String id) {

		System.out.println(id);
		Regioni regione = (Regioni) selected.getValue();
		String prefix = id.substring(0, 3);
		this.province = new ManageProvince().getByID_Regione(regione.getId());

		Listbox list = (Listbox) this.getFellow(prefix + "_provincia");
		list.setModel(new ListModelList<Province>(this.province));

		this.reset(prefix + "_comune");
		((Textbox) this.getFellow(prefix + "_luogo")).setValue("");

	}

	public void selezioneProvincia(Listitem selected, String id) {

		System.out.println(id);
		Province provincia = (Province) selected.getValue();
		String prefix = id.substring(0, 3);
		this.comuni = new ManageComuni().getByID_Province(provincia.getId());

		Listbox list = (Listbox) this.getFellow(prefix + "_comune");
		list.setModel(new ListModelList<Comuni>(this.comuni));

		((Textbox) this.getFellow(prefix + "_luogo")).setValue("");

	}

	public void selezioneComune(Listitem selected, String id) {

		System.out.println(id);
		Comuni comune = (Comuni) selected.getValue();
		String prefix = id.substring(0, 3);

		Textbox luogo = (Textbox) this.getFellow(prefix + "_luogo");
		luogo.setValue(comune.getComune());

		if (prefix.equals("scu")) {

		}

	}

	private void reset(String id) {

		System.out.println("Reset: " + id);
		Listbox list = (Listbox) this.getFellow(id);

		if (id.endsWith("regione")) {
			this.regioni = new ArrayList<Regioni>();
			list.setModel(new ListModelList<Regioni>(this.regioni));
		}

		if (id.endsWith("provincia")) {
			this.province = new ArrayList<Province>();
			list.setModel(new ListModelList<Province>(this.province));
		}

		if (id.endsWith("comune")) {
			this.comuni = new ArrayList<Comuni>();
			list.setModel(new ListModelList<Comuni>(this.comuni));
		}

	}

	public String getCodice_lingua() {
		return codice_lingua;
	}

	public void setCodice_lingua(String codice_lingua) {
		this.codice_lingua = codice_lingua;
	}

	public int getLingua() {
		return lingua;
	}

	public List<Nazioni> getNazioni() {
		return nazioni;
	}

	public void setNazioni(List<Nazioni> nazioni) {
		this.nazioni = nazioni;
	}

	public List<Regioni> getRegioni() {
		return regioni;
	}

	public void setRegioni(List<Regioni> regioni) {
		this.regioni = regioni;
	}

	public List<Province> getProvince() {
		return province;
	}

	public void setProvince(List<Province> province) {
		this.province = province;
	}

	public List<Comuni> getComuni() {
		return comuni;
	}

	public void setComuni(List<Comuni> comuni) {
		this.comuni = comuni;
	}

	public void setLingua(int lingua) {

		System.out.println("Impostazione della lingua al valore: " + lingua);
		this.codice_lingua = new ManageLingue().getByID(this.lingua).getCodice();
		this.lingua = lingua;
		// String path = Executions.getCurrent().getContextPath();
		Executions.sendRedirect(this.getPagina() + "?lingua=" + this.lingua + "&contesto=" + this.contesto.getCodice());

	}

	public String getLabel(int id) {
		return new ManageLabels().getLabels(id, this.codice_lingua) == null ? "N/D"
				: new ManageLabels().getLabels(id, this.codice_lingua).getLabel();
	}

	public Contesti getContesto() {
		return contesto;
	}

	public void setContesto(Contesti contesto) {
		this.contesto = contesto;
	}

	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}

	public boolean isVisibilitaResidenza() {
		return visibilitaResidenza;
	}

	public void setVisibilitaResidenza(boolean visibilitaResidenza) {
		this.visibilitaResidenza = visibilitaResidenza;
	}

	public boolean isVisibilitaRecapiti() {
		return visibilitaRecapiti;
	}

	public void setVisibilitaRecapiti(boolean visibilitaRecapiti) {
		this.visibilitaRecapiti = visibilitaRecapiti;
	}

	public boolean isVisibilitaDiploma() {
		return visibilitaDiploma;
	}

	public void setVisibilitaDiploma(boolean visibilitaDiploma) {
		this.visibilitaDiploma = visibilitaDiploma;
	}

	public boolean isVisibilitaLaurea() {
		return visibilitaLaurea;
	}

	public void setVisibilitaLaurea(boolean visibilitaLaurea) {
		this.visibilitaLaurea = visibilitaLaurea;
	}

	public boolean isVisibilitaGenitore() {
		return visibilitaGenitore;
	}

	public void setVisibilitaGenitore(boolean visibilitaGenitore) {
		this.visibilitaGenitore = visibilitaGenitore;
	}

	public List<MiurScuole> getScuole() {
		return scuole;
	}

	public void setScuole(List<MiurScuole> scuole) {
		this.scuole = scuole;
	}

	public List<TipiTitoloSup> getTipiTitolo() {
		return tipiTitolo;
	}

	public void setTipiTitolo(List<TipiTitoloSup> tipiTitolo) {
		this.tipiTitolo = tipiTitolo;
	}

	public List<MiurTipiScuole> getTipiScuole() {
		return tipiScuole;
	}

	public void setTipiScuole(List<MiurTipiScuole> tipiScuole) {
		this.tipiScuole = tipiScuole;
	}

	public void conferma() throws Exception {

		System.out.println("Metodo conferma della Classe Index");

		this.controlli();

		Persone persona = new Persone();

		persona.setNome(this.getTextbox("nome").getValue().trim());
		persona.setCognome(this.getTextbox("cognome").getValue().trim());
		persona.setSesso(this.getRadiogroup("sesso").getSelectedItem().getLabel());
		persona.setDataNascita(this.getDatebox("data_nascita").getValue());
		persona.setCodiceFiscale(this.getTextbox("codice_fiscale").getValue());

		int id_nazione = 0;
		String nazione = null;
		String cod_catasto = null;
		
		if (this.getListbox("nas_nazione").getSelectedItem().getValue() instanceof Nazioni) {
		
			Nazioni nazioneNascita = (Nazioni) this.getListbox("nas_nazione").getSelectedItem().getValue();
			id_nazione = nazioneNascita.getId();
			nazione = nazioneNascita.getNazione();
			cod_catasto = nazioneNascita.getNazione();
					
		} 
		
		if (this.getListbox("nas_nazione").getSelectedItem().getValue() instanceof NazioniEng) {
		
			NazioniEng nazioneNascita = (NazioniEng) this.getListbox("nas_nazione").getSelectedItem().getValue();
			id_nazione = nazioneNascita.getId();
			nazione = nazioneNascita.getNazione();
			cod_catasto = nazioneNascita.getNazione();
					
		} 
		
		if (id_nazione != 1) {

			persona.setCodiceCatastaleNazioneNascita(cod_catasto);
			persona.setCodiceCatastaleLuogoNascita("N/D");
			persona.setNazioneNascita(nazione);

		} else {

			Comuni comuneNascita = (Comuni) this.getListbox("nas_comune").getSelectedItem().getValue();

			persona.setCodiceCatastaleNazioneNascita("N/D");
			persona.setCodiceCatastaleLuogoNascita(comuneNascita.getCodiceCatastale());
			persona.setNazioneNascita(nazione);

		}

		persona.setLuogoNascita(this.getTextbox("nas_luogo").getValue());

		this.setPersona(persona);

	}

	private void controlli() throws WrongValueException, GeneratoreCodiceFiscaleException {

		System.out.println("Metodo controlli della Classe Index");

		if (!this.compilazioneTextbox("nome")) {
			throw new WrongValueException(this.getFellow("nome"), this.getLabel(48));
		}

		if (!this.compilazioneTextbox("cognome")) {
			throw new WrongValueException(this.getFellow("cognome"), this.getLabel(48));
		}

		if (this.getRadiogroup("sesso").getSelectedItem() == null) {
			throw new WrongValueException(this.getRadiogroup("sesso"), this.getLabel(48));
		}

		if (this.getDatebox("data_nascita").getValue() == null) {
			throw new WrongValueException(this.getDatebox("data_nascita"), this.getLabel(48));
		}

		if (this.getListbox("nas_nazione").getSelectedItem() == null) {
			throw new WrongValueException(this.getFellow("nas_nazione"), this.getLabel(47));
		}
		
		Nazioni nazioneNascita = null;
		
		if (this.getListbox("nas_nazione").getSelectedItem().getValue() instanceof Nazioni) {
			nazioneNascita = (Nazioni) this.getListbox("nas_nazione").getSelectedItem().getValue();
		} 		
		
		if (this.getListbox("nas_nazione").getSelectedItem().getValue() instanceof NazioniEng) {
			
			NazioniEng nazione = (NazioniEng) this.getListbox("nas_nazione").getSelectedItem().getValue();
			nazioneNascita = new Nazioni();
			nazioneNascita.setId(nazione.getId());
			nazioneNascita.setCodiceCatastale(nazione.getCodiceCatastale());
			nazioneNascita.setCodice(nazione.getCodice());
			nazioneNascita.setNazione(nazione.getNazione());
			
		} 		

		if (!this.compilazioneTextbox("nas_luogo")) {
			throw new WrongValueException(this.getFellow("nas_luogo"), this.getLabel(48));
		}

		GeneratoreCodiceFiscale cf = null;

		if (!this.compilazioneTextbox("codice_fiscale")) {

			if (nazioneNascita.getId() != 1) {

				cf = new GeneratoreCodiceFiscale(this.getTextbox("cognome").getValue().trim(),
						this.getTextbox("nome").getValue().trim(), this.getDatebox("data_nascita").getValue(),
						this.getRadiogroup("sesso").getSelectedItem().getLabel(), nazioneNascita.getCodiceCatastale());

				this.getTextbox("codice_fiscale").setValue(cf.Cacola());

			} else {

				Comuni comune = (Comuni) this.getListbox("nas_comune").getSelectedItem().getValue();

				cf = new GeneratoreCodiceFiscale(this.getTextbox("cognome").getValue().trim(),
						this.getTextbox("nome").getValue().trim(), this.getDatebox("data_nascita").getValue(),
						this.getRadiogroup("sesso").getSelectedItem().getLabel(), comune.getCodiceCatastale());

				this.getTextbox("codice_fiscale").setValue(cf.Cacola());

			}

		} else {

			if (!new GeneratoreCodiceFiscale().formalmenteValido(this.getTextbox("codice_fiscale").getValue())) {
				throw new WrongValueException(this.getFellow("codice_fiscale"), this.getLabel(63));
			}

		}
		
		System.out.println( "Codice fiscale --> " + ((Textbox)this.getFellow("codice_fiscale")).getValue());
		
		if (this.visibilitaFotografia) {
			if (this.fotografia == null) {
				throw new WrongValueException(this.getFellow("fotografia"), this.getLabel(64));
			}
		}

		// --------------------------------------------------------------------------
		//
		// Dati relativi alla residenza
		//
		// --------------------------------------------------------------------------

		if (this.visibilitaResidenza) {

			if (this.getListbox("res_nazione").getSelectedItem() == null) {
				throw new WrongValueException(this.getFellow("res_nazione"), this.getLabel(47));
			}

			if (!this.compilazioneTextbox("res_luogo")) {
				throw new WrongValueException(this.getFellow("res_luogo"), this.getLabel(48));
			}

			if (!this.compilazioneTextbox("res_indirizzo")) {
				throw new WrongValueException(this.getFellow("res_indirizzo"), this.getLabel(48));
			}

			if (!this.compilazioneTextbox("res_civico")) {
				throw new WrongValueException(this.getFellow("res_civico"), this.getLabel(48));
			}

			if (!this.compilazioneTextbox("res_cap")) {
				throw new WrongValueException(this.getFellow("res_cap"), this.getLabel(48));
			}

		}

		if (this.visibilitaRecapiti) {

			if (!this.compilazioneTextbox("email")) {
				throw new WrongValueException(this.getFellow("email"), this.getLabel(48));
			}

			String regex = "[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}";

			if (!Pattern.matches(regex, this.getTextbox("email").getValue().trim())) {
				throw new WrongValueException(this.getTextbox("email"), this.getLabel(63));
			}

			regex = "[0-9]+$";

			if (!Pattern.matches(regex, this.getTextbox("telefono").getValue().trim())) {
				throw new WrongValueException(this.getTextbox("telefono"), this.getLabel(63));
			}

		}

	}

	public Radiogroup getRadiogroup(String id) {
		return (Radiogroup) this.getFellow(id);
	}

	public Datebox getDatebox(String id) {
		return (Datebox) this.getFellow(id);
	}

	public Listbox getListbox(String id) {
		return (Listbox) this.getFellow(id);
	}

	public Textbox getTextbox(String id) {
		return ((Textbox) this.getFellow(id));
	}

	public Intbox getIntbox(String id) {
		return ((Intbox) this.getFellow(id));
	}

	public boolean compilazioneTextbox(String id) {
		return (this.getTextbox(id)).getValue().trim().length() > 0;
	}

	public boolean compilazioneIntbox(String id) {
		return (this.getIntbox(id)).intValue() > 0;
	}

	public boolean isVisibilitaFotografia() {
		return visibilitaFotografia;
	}

	public void setVisibilitaFotografia(boolean visibilitaFotografia) {
		this.visibilitaFotografia = visibilitaFotografia;
	}

	public void uploadFotografia() {

		Media[] media = Fileupload.get(-1);

		for (int i = 0; i < media.length; i++) {

			if (media[i] instanceof org.zkoss.image.Image) {
				this.fotografia = media[i];
				Image foto = (Image) this.getFellow("fotografia");
				foto.setContent((org.zkoss.image.Image) this.getFotografia());
			} else {
				Messagebox.show(this.getLabel(59), "Error", Messagebox.OK, Messagebox.ERROR);
			}

		}

	}

	public void controlloObbigatorieta() throws WrongValueException, GeneratoreCodiceFiscaleException {

		List<AbstractComponent> list = this.getChildren();

		Iterator<AbstractComponent> i = list.iterator();

		while (i.hasNext()) {

			AbstractComponent comp = i.next();

			this.controlloObbigatorieta(comp);

		}

	}

	private void controlloObbigatorieta(AbstractComponent comp) throws WrongValueException, GeneratoreCodiceFiscaleException {

		this.controllo(comp);

		List<AbstractComponent> list = comp.getChildren();

		if (list.isEmpty()) {

		} else {

			Iterator<AbstractComponent> i = list.iterator();

			while (i.hasNext()) {

				AbstractComponent item = i.next();
				this.controlloObbigatorieta(item);

			}

		}

	}

	private Controlli getControllo(String id) {

		Controlli controllo = null;

		Iterator<Controlli> i = this.controlli.iterator();

		while (i.hasNext()) {

			Controlli item = i.next();

			if (item.getInputName().equals(id)) {
				controllo = item;
			}

		}

		return controllo;

	}

	public void controllo(AbstractComponent comp) throws WrongValueException, GeneratoreCodiceFiscaleException {

		if (comp.getId() != null && comp.getId().trim().length() > 0) {

			Controlli controllo = this.getControllo(comp.getId());

			if (controllo != null) {

				if (comp instanceof Textbox) {
					
					if (comp.getId().equals("token")) {
						
						if (this.getTextbox(comp.getId()).getValue().trim().length() > 0) {
							
							System.out.println("controllo del token");
							
							if (! new ManageTokens().exists(this.getTextbox(comp.getId()).getValue().trim())) {
								throw new WrongValueException(this.getFellow("token"), this.getLabel(180));
							} else {
								this.token = new ManageTokens().getByID((this.getTextbox(comp.getId()).getValue().trim()));
							}
							
						}
						
					}
					
					if (comp.getId().equals("codice_fiscale")) {

						if (this.getListbox("nas_nazione").getSelectedItem() == null) {
							throw new WrongValueException(this.getFellow("nas_nazione"), this.getLabel(47));
						}
						
						Nazioni nazioneNascita = null;
						
						if (this.getListbox("nas_nazione").getSelectedItem().getValue() instanceof Nazioni) {
							nazioneNascita = (Nazioni) this.getListbox("nas_nazione").getSelectedItem().getValue();
						} 		
						
						if (this.getListbox("nas_nazione").getSelectedItem().getValue() instanceof NazioniEng) {
							
							NazioniEng nazione = (NazioniEng) this.getListbox("nas_nazione").getSelectedItem().getValue();
							nazioneNascita = new Nazioni();
							nazioneNascita.setId(nazione.getId());
							nazioneNascita.setCodiceCatastale(nazione.getCodiceCatastale());
							nazioneNascita.setCodice(nazione.getCodice());
							nazioneNascita.setNazione(nazione.getNazione());
							
						} 		

						GeneratoreCodiceFiscale cf = null;

						if (!this.compilazioneTextbox("codice_fiscale")) {

							if (nazioneNascita.getId() != 1) {

								cf = new GeneratoreCodiceFiscale(this.getTextbox("cognome").getValue().trim(),
										this.getTextbox("nome").getValue().trim(), this.getDatebox("data_nascita").getValue(),
										this.getRadiogroup("sesso").getSelectedItem().getLabel(), nazioneNascita.getCodiceCatastale());

								this.getTextbox("codice_fiscale").setValue(cf.Cacola());

							} else {

								Comuni comune = (Comuni) this.getListbox("nas_comune").getSelectedItem().getValue();

								cf = new GeneratoreCodiceFiscale(this.getTextbox("cognome").getValue().trim(),
										this.getTextbox("nome").getValue().trim(), this.getDatebox("data_nascita").getValue(),
										this.getRadiogroup("sesso").getSelectedItem().getLabel(), comune.getCodiceCatastale());

								this.getTextbox("codice_fiscale").setValue(cf.Cacola());

							}

						} else {

							if (!new GeneratoreCodiceFiscale().formalmenteValido(this.getTextbox("codice_fiscale").getValue())) {
								throw new WrongValueException(this.getFellow("codice_fiscale"), this.getLabel(63));
							}

						}
						
					}

					System.out.println( "Codice fiscale --> " + ((Textbox)this.getFellow("codice_fiscale")).getValue());
					
					if (controllo.getObbligatorio().equals("S")) {
						if (this.getTextbox(comp.getId()).getValue().trim().length() <= 0) {
							throw new WrongValueException(this.getFellow(comp.getId()), this.getLabel(48));
						}
					}

					if (!controllo.getRegExp().equals("N/D")) {
						if (this.getTextbox(comp.getId()).getValue().trim().length() > 0) {
							if (!Pattern.matches(controllo.getRegExp().trim(),
									this.getTextbox(comp.getId()).getValue().trim())) {
								throw new WrongValueException(comp, this.getLabel(63));
							}
						}
					}

				}

				if (comp instanceof Intbox) {

					if (controllo.getObbligatorio().equals("S")) {
						if (this.getIntbox(comp.getId()).intValue() <= 0) {
							throw new WrongValueException(this.getFellow(comp.getId()), this.getLabel(48));
						}
					}

					if (controllo.getMin() > 0) {

						if (this.getIntbox(comp.getId()).intValue() > 0) {
							if (this.getIntbox(comp.getId()).intValue() < controllo.getMin()) {
								throw new WrongValueException(this.getFellow(comp.getId()), this.getLabel(63));
							}
						}

					}

					if (controllo.getMax() > 0) {

						if (this.getIntbox(comp.getId()).intValue() > 0) {
							if (this.getIntbox(comp.getId()).intValue() > controllo.getMax()) {
								throw new WrongValueException(this.getFellow(comp.getId()), this.getLabel(63));
							}
						}

					}

				}

				if (comp instanceof Datebox) {
					if (controllo.getObbligatorio().equals("S")) {
						if (this.getDatebox(comp.getId()).getValue() == null) {
							throw new WrongValueException(this.getFellow(comp.getId()), this.getLabel(48));
						}
					}
				}

				if (comp instanceof Listbox) {
					if (controllo.getObbligatorio().equals("S")) {
						if (this.getListbox(comp.getId()).getSelectedItem() == null) {
							throw new WrongValueException(this.getFellow(comp.getId()), this.getLabel(47));
						}
					}
				}

				if (comp instanceof Radiogroup) {
					if (controllo.getObbligatorio().equals("S")) {
						if (this.getRadiogroup(comp.getId()).getSelectedItem() == null) {
							throw new WrongValueException(this.getFellow(comp.getId()), this.getLabel(48));
						}
					}
					if (!controllo.getRegExp().equals("N/D")) {
						if ((this.getRadiogroup(comp.getId()).getSelectedItem() != null)
						&&	(!this.getRadiogroup(comp.getId()).getSelectedItem().getLabel().equals(controllo.getRegExp().trim()))	) {
								throw new WrongValueException(comp, this.getLabel(63));
						}
					}
				}

				if (comp instanceof Iframe) {
					if (controllo.getObbligatorio().equals("S")) {
						if (this.getIframe(comp.getId()).getContent() == null) {
							String nome_bottone = "button_" + comp.getId().substring(comp.getId().indexOf("_") + 1); 
							Button button = (Button) this.getFellow(nome_bottone);
							throw new WrongValueException(button, this.getLabel(48));
						}
					}
				}

			}

		}

	}

	public Iframe getIframe(String id) {
		return (Iframe) this.getFellow(id);
	}

	public Image getImage(String id) {
		return (Image) this.getFellow(id);
	}
	
	public String getTextboxValue(String id) {
		return ((Textbox) this.getFellow(id)).getValue();
	}

}
