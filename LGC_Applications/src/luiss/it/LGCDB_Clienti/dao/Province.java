package luiss.it.LGCDB_Clienti.dao;
// Generated 11-dic-2018 16.15.27 by Hibernate Tools 5.2.6.Final

/**
 * Province generated by hbm2java
 */
public class Province implements java.io.Serializable {

	private Integer id;
	private String provincia;
	private String sigla;
	private Integer idRegioni;

	public Province() {
	}

	public Province(String provincia, String sigla, Integer idRegioni) {
		this.provincia = provincia;
		this.sigla = sigla;
		this.idRegioni = idRegioni;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getSigla() {
		return this.sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Integer getIdRegioni() {
		return this.idRegioni;
	}

	public void setIdRegioni(Integer idRegioni) {
		this.idRegioni = idRegioni;
	}

}
