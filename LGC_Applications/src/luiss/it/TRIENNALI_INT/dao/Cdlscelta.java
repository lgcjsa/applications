package luiss.it.TRIENNALI_INT.dao;
// Generated 15-nov-2018 17.14.10 by Hibernate Tools 5.2.6.Final

/**
 * Cdlscelta generated by hbm2java
 */
public class Cdlscelta implements java.io.Serializable {

	private CdlsceltaId id;
	private String descrizione;
	private String selezionabile;

	public Cdlscelta() {
	}

	public Cdlscelta(CdlsceltaId id, String descrizione, String selezionabile) {
		this.id = id;
		this.descrizione = descrizione;
		this.selezionabile = selezionabile;
	}

	public CdlsceltaId getId() {
		return this.id;
	}

	public void setId(CdlsceltaId id) {
		this.id = id;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getSelezionabile() {
		return this.selezionabile;
	}

	public void setSelezionabile(String selezionabile) {
		this.selezionabile = selezionabile;
	}

}
