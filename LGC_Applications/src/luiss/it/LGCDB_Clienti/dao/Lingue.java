package luiss.it.LGCDB_Clienti.dao;
// Generated 11-dic-2018 16.15.27 by Hibernate Tools 5.2.6.Final

/**
 * Lingue generated by hbm2java
 */
public class Lingue implements java.io.Serializable {

	private Integer id;
	private String lingua;
	private String codice;

	public Lingue() {
	}

	public Lingue(String lingua, String codice) {
		this.lingua = lingua;
		this.codice = codice;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLingua() {
		return this.lingua;
	}

	public void setLingua(String lingua) {
		this.lingua = lingua;
	}

	public String getCodice() {
		return this.codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

}
