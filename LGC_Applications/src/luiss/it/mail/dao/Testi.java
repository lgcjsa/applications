package luiss.it.mail.dao;
// Generated 7-nov-2018 10.18.00 by Hibernate Tools 5.2.6.Final

/**
 * Testi generated by hbm2java
 */
public class Testi implements java.io.Serializable {

	private Integer id;
	private String testo;

	public Testi() {
	}

	public Testi(String testo) {
		this.testo = testo;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTesto() {
		return this.testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

}
