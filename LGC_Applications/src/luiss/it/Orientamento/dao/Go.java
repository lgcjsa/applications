package luiss.it.Orientamento.dao;
// Generated 28-nov-2018 11.18.02 by Hibernate Tools 5.2.6.Final

import java.util.Date;

/**
 * Go generated by hbm2java
 */
public class Go implements java.io.Serializable {

	private int id;
	private String cognome;
	private String nome;
	private String codiceFiscale;
	private Date dataNascita;
	private String sesso;
	private int comuneNascita;
	private String telefono;
	private String cellulare;
	private String email;
	private long idScuole;
	private String scuolaDenominazione;
	private String scuolaComune;
	private String scuolaIndirizzo;
	private String scuolaCap;
	private String scuolaProvincia;
	private String tipoScuolaCod;
	private String annoFrequenza;
	private String presente;
	private int idPeriodiGo;
	private Date dataInsert;
	private String userInsert;
	private Date dataUpdate;
	private String userUpdate;
	private String privacy;
	private String luogoNascita;

	public Go() {
	}

	public Go(String cognome, String nome, String codiceFiscale, Date dataNascita, String sesso, int comuneNascita,
			String telefono, String cellulare, String email, long idScuole, String scuolaDenominazione,
			String scuolaComune, String scuolaIndirizzo, String scuolaCap, String scuolaProvincia, String tipoScuolaCod,
			String annoFrequenza, String presente, int idPeriodiGo, Date dataInsert, String userInsert, Date dataUpdate,
			String userUpdate, String privacy, String luogoNascita) {
		this.cognome = cognome;
		this.nome = nome;
		this.codiceFiscale = codiceFiscale;
		this.dataNascita = dataNascita;
		this.sesso = sesso;
		this.comuneNascita = comuneNascita;
		this.telefono = telefono;
		this.cellulare = cellulare;
		this.email = email;
		this.idScuole = idScuole;
		this.scuolaDenominazione = scuolaDenominazione;
		this.scuolaComune = scuolaComune;
		this.scuolaIndirizzo = scuolaIndirizzo;
		this.scuolaCap = scuolaCap;
		this.scuolaProvincia = scuolaProvincia;
		this.tipoScuolaCod = tipoScuolaCod;
		this.annoFrequenza = annoFrequenza;
		this.presente = presente;
		this.idPeriodiGo = idPeriodiGo;
		this.dataInsert = dataInsert;
		this.userInsert = userInsert;
		this.dataUpdate = dataUpdate;
		this.userUpdate = userUpdate;
		this.privacy = privacy;
		this.luogoNascita = luogoNascita;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodiceFiscale() {
		return this.codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public Date getDataNascita() {
		return this.dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getSesso() {
		return this.sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public int getComuneNascita() {
		return this.comuneNascita;
	}

	public void setComuneNascita(int comuneNascita) {
		this.comuneNascita = comuneNascita;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCellulare() {
		return this.cellulare;
	}

	public void setCellulare(String cellulare) {
		this.cellulare = cellulare;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getIdScuole() {
		return this.idScuole;
	}

	public void setIdScuole(long idScuole) {
		this.idScuole = idScuole;
	}

	public String getScuolaDenominazione() {
		return this.scuolaDenominazione;
	}

	public void setScuolaDenominazione(String scuolaDenominazione) {
		this.scuolaDenominazione = scuolaDenominazione;
	}

	public String getScuolaComune() {
		return this.scuolaComune;
	}

	public void setScuolaComune(String scuolaComune) {
		this.scuolaComune = scuolaComune;
	}

	public String getScuolaIndirizzo() {
		return this.scuolaIndirizzo;
	}

	public void setScuolaIndirizzo(String scuolaIndirizzo) {
		this.scuolaIndirizzo = scuolaIndirizzo;
	}

	public String getScuolaCap() {
		return this.scuolaCap;
	}

	public void setScuolaCap(String scuolaCap) {
		this.scuolaCap = scuolaCap;
	}

	public String getScuolaProvincia() {
		return this.scuolaProvincia;
	}

	public void setScuolaProvincia(String scuolaProvincia) {
		this.scuolaProvincia = scuolaProvincia;
	}

	public String getTipoScuolaCod() {
		return this.tipoScuolaCod;
	}

	public void setTipoScuolaCod(String tipoScuolaCod) {
		this.tipoScuolaCod = tipoScuolaCod;
	}

	public String getAnnoFrequenza() {
		return this.annoFrequenza;
	}

	public void setAnnoFrequenza(String annoFrequenza) {
		this.annoFrequenza = annoFrequenza;
	}

	public String getPresente() {
		return this.presente;
	}

	public void setPresente(String presente) {
		this.presente = presente;
	}

	public int getIdPeriodiGo() {
		return this.idPeriodiGo;
	}

	public void setIdPeriodiGo(int idPeriodiGo) {
		this.idPeriodiGo = idPeriodiGo;
	}

	public Date getDataInsert() {
		return this.dataInsert;
	}

	public void setDataInsert(Date dataInsert) {
		this.dataInsert = dataInsert;
	}

	public String getUserInsert() {
		return this.userInsert;
	}

	public void setUserInsert(String userInsert) {
		this.userInsert = userInsert;
	}

	public Date getDataUpdate() {
		return this.dataUpdate;
	}

	public void setDataUpdate(Date dataUpdate) {
		this.dataUpdate = dataUpdate;
	}

	public String getUserUpdate() {
		return this.userUpdate;
	}

	public void setUserUpdate(String userUpdate) {
		this.userUpdate = userUpdate;
	}

	public String getPrivacy() {
		return this.privacy;
	}

	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}

	public String getLuogoNascita() {
		return this.luogoNascita;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

}