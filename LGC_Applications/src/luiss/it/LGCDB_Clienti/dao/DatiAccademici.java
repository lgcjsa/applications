package luiss.it.LGCDB_Clienti.dao;
// Generated 11-dic-2018 16.15.27 by Hibernate Tools 5.2.6.Final

import java.util.Date;

/**
 * DatiAccademici generated by hbm2java
 */
public class DatiAccademici implements java.io.Serializable {

	private Integer id;
	private String matricolaLuiss;
	private Integer idPersone;
	private String cdsScelta;
	private Integer annoCorso;
	private Integer annoAcc;
	private String nota;
	private Date dataInsert;
	private Date dataUpdate;

	public DatiAccademici() {
	}

	public DatiAccademici(String matricolaLuiss, Integer idPersone, String cdsScelta, Integer annoCorso,
			Integer annoAcc, String nota, Date dataInsert, Date dataUpdate) {
		this.matricolaLuiss = matricolaLuiss;
		this.idPersone = idPersone;
		this.cdsScelta = cdsScelta;
		this.annoCorso = annoCorso;
		this.annoAcc = annoAcc;
		this.nota = nota;
		this.dataInsert = dataInsert;
		this.dataUpdate = dataUpdate;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMatricolaLuiss() {
		return this.matricolaLuiss;
	}

	public void setMatricolaLuiss(String matricolaLuiss) {
		this.matricolaLuiss = matricolaLuiss;
	}

	public Integer getIdPersone() {
		return this.idPersone;
	}

	public void setIdPersone(Integer idPersone) {
		this.idPersone = idPersone;
	}

	public String getCdsScelta() {
		return this.cdsScelta;
	}

	public void setCdsScelta(String cdsScelta) {
		this.cdsScelta = cdsScelta;
	}

	public Integer getAnnoCorso() {
		return this.annoCorso;
	}

	public void setAnnoCorso(Integer annoCorso) {
		this.annoCorso = annoCorso;
	}

	public Integer getAnnoAcc() {
		return this.annoAcc;
	}

	public void setAnnoAcc(Integer annoAcc) {
		this.annoAcc = annoAcc;
	}

	public String getNota() {
		return this.nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public Date getDataInsert() {
		return this.dataInsert;
	}

	public void setDataInsert(Date dataInsert) {
		this.dataInsert = dataInsert;
	}

	public Date getDataUpdate() {
		return this.dataUpdate;
	}

	public void setDataUpdate(Date dataUpdate) {
		this.dataUpdate = dataUpdate;
	}

}
