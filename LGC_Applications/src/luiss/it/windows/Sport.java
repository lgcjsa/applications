package luiss.it.windows;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;

import luiss.it.LGCDB_Clienti.dao.AnniAccademici;
import luiss.it.LGCDB_Clienti.dao.Cds;
import luiss.it.LGCDB_Clienti.dao.Comuni;
import luiss.it.LGCDB_Clienti.dao.DatiAccademici;
import luiss.it.LGCDB_Clienti.dao.DatiSportivi;
import luiss.it.LGCDB_Clienti.dao.DisciplineSportive;
import luiss.it.LGCDB_Clienti.dao.Emails;
import luiss.it.LGCDB_Clienti.dao.Fotografie;
import luiss.it.LGCDB_Clienti.dao.Indirizzi;
import luiss.it.LGCDB_Clienti.dao.LivelliSportivi;
import luiss.it.LGCDB_Clienti.dao.Nazioni;
import luiss.it.LGCDB_Clienti.dao.RisultatiSportivi;
import luiss.it.LGCDB_Clienti.dao.Telefoni;
import luiss.it.LGCDB_Clienti.db.ManageAnniAccademici;
import luiss.it.LGCDB_Clienti.db.ManageCds;
import luiss.it.LGCDB_Clienti.db.ManageDatiAccademici;
import luiss.it.LGCDB_Clienti.db.ManageDatiSportivi;
import luiss.it.LGCDB_Clienti.db.ManageDisciplineSportive;
import luiss.it.LGCDB_Clienti.db.ManageEmails;
import luiss.it.LGCDB_Clienti.db.ManageFotografie;
import luiss.it.LGCDB_Clienti.db.ManageIndirizzi;
import luiss.it.LGCDB_Clienti.db.ManageLivelliSportivi;
import luiss.it.LGCDB_Clienti.db.ManagePersone;
import luiss.it.LGCDB_Clienti.db.ManageRisultatiSportivi;
import luiss.it.LGCDB_Clienti.db.ManageTelefoni;
import luiss.it.beans.GeneratoreCodiceFiscaleException;

@SuppressWarnings("serial")
public class Sport extends Index {
	
	private List<DisciplineSportive> sports;
	private List<LivelliSportivi> livelli;
	private List<String> medaglie;
	private List<RisultatiSportivi> risultati;
	private List<Cds> cds;
	private List<AnniAccademici> anniAccademici;
	
	public Sport() {
		
		super();
		
		this.sports = new ManageDisciplineSportive().getAll();
		this.livelli = new ManageLivelliSportivi().getAll();
		this.livelli = new ManageLivelliSportivi().getAll();
		this.cds = new ManageCds().getAll();
		this.anniAccademici = new ManageAnniAccademici().getAll();
		this.medaglie = new ArrayList<String>();
		
		this.medaglie.add("ORO");
		this.medaglie.add("ARGENTO");
		this.medaglie.add("BRONZO");
		
		this.risultati = new ArrayList<RisultatiSportivi>();

		
	}

	public List<DisciplineSportive> getSports() {
		return sports;
	}

	public void setSports(List<DisciplineSportive> sports) {
		this.sports = sports;
	}

	public List<LivelliSportivi> getLivelli() {
		return livelli;
	}

	public void setLivelli(List<LivelliSportivi> livelli) {
		this.livelli = livelli;
	}

	public List<String> getMedaglie() {
		return medaglie;
	}

	public void setMedaglie(List<String> medaglie) {
		this.medaglie = medaglie;
	}

	public List<RisultatiSportivi> getRisultati() {
		return risultati;
	}

	public void setRisultati(List<RisultatiSportivi> risultati) {
		this.risultati = risultati;
	}

	public List<Cds> getCds() {
		return cds;
	}

	public void setCds(List<Cds> cds) {
		this.cds = cds;
	}

	public List<AnniAccademici> getAnniAccademici() {
		return anniAccademici;
	}

	public void setAnniAccademici(List<AnniAccademici> anniAccademici) {
		this.anniAccademici = anniAccademici;
	}

	public void add() {
		
		Listitem selected = this.getListbox("medaglia").getSelectedItem();
		
		if (selected == null) {
			throw new WrongValueException(this.getListbox("medaglia"), this.getLabel(47));
		}
		
		if (this.getTextbox("des_medaglia").getValue().trim().length() <= 0) {
			throw new WrongValueException(this.getTextbox("des_medaglia"), this.getLabel(48));
		}
		
		RisultatiSportivi risultato = new RisultatiSportivi();
		
		String medaglia = (String) selected.getValue();
		
		risultato.setMedaglia(medaglia);
		risultato.setDescrizione(this.getTextbox("des_medaglia").getValue());
		
		this.getListbox("medaglia").setSelectedItem(null);
		this.getTextbox("des_medaglia").setValue("");
		
		this.risultati.add(risultato);
		
		Listbox list = this.getListbox("medagliere");
		list.setModel(new ListModelList<RisultatiSportivi>(this.risultati));
		
	}

	public void delete() {
		
		Listitem selected = this.getListbox("medagliere").getSelectedItem();
		
		if (selected == null) {
			throw new WrongValueException(this.getListbox("medagliere"), this.getLabel(47));
		}
		
		this.risultati.remove(selected.getValue());
		
		Listbox list = this.getListbox("medagliere");
		list.setModel(new ListModelList<RisultatiSportivi>(this.risultati));
		
	}
	
	public void conferma() throws Exception {
		
		super.conferma();
		
		System.out.println(this.getPersona().getCodiceFiscale());
		
		if (new ManagePersone().esiste(this.getPersona().getCodiceFiscale())) {
			throw new WrongValueException(this.getFellow("codice_fiscale"), this.getLabel(65));
		}

		System.out.println("Metodo conferma della Classe Sport");
		
		this.controlli();
		
		new ManagePersone().insert(this.getPersona());
		
		System.out.println("Inserito record in Persone numero " + this.getPersona().getId());

		Telefoni telefono = new Telefoni();
		
		telefono.setIdPersone(this.getPersona().getId());
		telefono.setTelefono(this.getTextbox("telefono").getValue());
		
		new ManageTelefoni().insert(telefono);
		
		System.out.println("Inserito record in Telefoni numero " + telefono.getId());
		
		Emails email = new Emails();
		
		email.setIdPersone(this.getPersona().getId());
		email.setEmail(this.getTextbox("email").getValue());
		
		new ManageEmails().insert(email);
		
		System.out.println("Inserito record in Emails numero " + email.getId());
		
		Indirizzi indirizzo = new Indirizzi();
		
		indirizzo.setIdTipologieIndirizzi(1);
		indirizzo.setIdPersone(this.getPersona().getId());
		
		Nazioni nazioneResidenza = (Nazioni) this.getListbox("res_nazione").getSelectedItem().getValue();
		
		if (nazioneResidenza.getId() != 1) {
			
			indirizzo.setNazioniCodiceCatastale(nazioneResidenza.getCodiceCatastale());
			indirizzo.setComuniCodiceCatastale("N/D");
			indirizzo.setNazioneDenominazione(nazioneResidenza.getNazione());
			
		} else {
			
			Comuni comuneResidenza = (Comuni) this.getListbox("res_comune").getSelectedItem().getValue();
			
			indirizzo.setNazioniCodiceCatastale("N/D");
			indirizzo.setComuniCodiceCatastale(comuneResidenza.getCodiceCatastale());
			indirizzo.setNazioneDenominazione(nazioneResidenza.getNazione());
			
		}
		
		indirizzo.setIndirizzo(this.getTextbox("res_indirizzo").getValue());
		indirizzo.setCivico(this.getTextbox("res_civico").getValue());
		indirizzo.setCap(this.getTextbox("res_cap").getValue());
		indirizzo.setComuneDenominazione(this.getTextbox("res_luogo").getValue());
		
		new ManageIndirizzi().insert(indirizzo);
		
		System.out.println("Inserito record in Indirizzi numero " + indirizzo.getId());
		
		DatiSportivi datiSportivi = new DatiSportivi();
		
		datiSportivi.setIdPersone(this.getPersona().getId());
		
		DisciplineSportive sport = (DisciplineSportive) this.getListbox("sport").getSelectedItem().getValue();
		LivelliSportivi livello = (LivelliSportivi) this.getListbox("livello").getSelectedItem().getValue();

		datiSportivi.setIdDisciplineSportive(sport.getId());
		datiSportivi.setIdLivelliSportivi(livello.getId());
		datiSportivi.setAnnoInizioAgonismo(this.getIntbox("anno_inizio_agonismo").intValue());
		datiSportivi.setSocietaDiAppertenenza(this.getTextbox("societa").getValue());
		datiSportivi.setLetteraMotivazionale(this.getTextbox("lettera_motivazionale").getValue());
		datiSportivi.setLetteraReferenziale(this.getTextbox("lettera_referenziale").getValue());
		
		new ManageDatiSportivi().insert(datiSportivi);
		
		System.out.println("Inserito record in DatiSportivi numero " + datiSportivi.getId());
		
		List<Listitem> risultati = this.getListbox("medagliere").getItems();
		
		Iterator<Listitem> i =  risultati.iterator();
		
		while (i.hasNext()) {
			
			RisultatiSportivi risultato = (RisultatiSportivi) i.next().getValue();
			
			risultato.setIdDatiSportivi(datiSportivi.getId());
			new ManageRisultatiSportivi().insert(risultato);
			System.out.println("Inserito record in RisultatiSportivi numero " + risultato.getId());
			
		}
		
		DatiAccademici datiAccademici = new DatiAccademici();
		
		datiAccademici.setIdPersone(this.getPersona().getId());
		datiAccademici.setAnnoCorso(this.getIntbox("anno_corso").intValue());
		datiAccademici.setAnnoAcc(((AnniAccademici) this.getListbox("anno_accademico").getSelectedItem().getValue()).getId());
		datiAccademici.setCdsScelta(((Cds) this.getListbox("cds").getSelectedItem().getValue()).getCod());
		datiAccademici.setMatricolaLuiss(this.getTextbox("matricola_luiss").getValue());
		datiAccademici.setNota(this.getTextbox("note").getValue());
		
		new ManageDatiAccademici().insert(datiAccademici);
		
		System.out.println("Inserito record in DatiAccademici numero " + datiAccademici.getId());

		Fotografie foto = new Fotografie();
		
		foto.setIdPersone(this.getPersona().getId());
		foto.setFoto(this.getFotografia().getByteData());
		foto.setContentType(this.getFotografia().getContentType());
		foto.setFormat(this.getFotografia().getFormat());
		
		new ManageFotografie().insert(foto);
		
		System.out.println("Inserito record in Fotografie numero " + foto.getId());
		
		Executions.sendRedirect(this.getConfig().getUrlOk());
		
	}
	
	private void controlli() {
		
		System.out.println("Metodo controlli della Classe Sport");
		
		if (this.getListbox("sport").getSelectedItem() == null) {
			throw new WrongValueException(this.getFellow("sport"), this.getLabel(47));
		}
		
		if (this.getListbox("livello").getSelectedItem() == null) {
			throw new WrongValueException(this.getFellow("livello"), this.getLabel(47));
		}
		
		if (!this.compilazioneTextbox("societa")) {
			throw new WrongValueException(this.getFellow("societa"), this.getLabel(48));
		}
		
		if (!this.compilazioneIntbox("anno_inizio_agonismo")) {
			throw new WrongValueException(this.getFellow("anno_inizio_agonismo"), this.getLabel(48));
		}
		
		if (!this.compilazioneTextbox("lettera_motivazionale")) {
			throw new WrongValueException(this.getFellow("lettera_motivazionale"), this.getLabel(48));
		}
		
		if (!this.compilazioneTextbox("lettera_referenziale")) {
			throw new WrongValueException(this.getFellow("lettera_referenziale"), this.getLabel(48));
		}
		
		if (this.getListbox("cds").getSelectedItem() == null) {
			throw new WrongValueException(this.getFellow("cds"), this.getLabel(47));
		}
		
		if (this.getListbox("anno_accademico").getSelectedItem() == null) {
			throw new WrongValueException(this.getFellow("anno_accademico"), this.getLabel(47));
		}
		
		if (!this.compilazioneIntbox("anno_corso")) {
			throw new WrongValueException(this.getFellow("anno_corso"), this.getLabel(48));
		}
		
	}

}
