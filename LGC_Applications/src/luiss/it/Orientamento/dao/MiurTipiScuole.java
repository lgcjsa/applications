package luiss.it.Orientamento.dao;
// Generated 28-nov-2018 11.18.02 by Hibernate Tools 5.2.6.Final

import java.util.Date;

/**
 * MiurTipiScuole generated by hbm2java
 */
public class MiurTipiScuole implements java.io.Serializable {

	private String tipoScuolaCod;
	private String des;
	private boolean statoCaric;
	private Date dataCaric;

	public MiurTipiScuole() {
	}

	public MiurTipiScuole(String tipoScuolaCod, boolean statoCaric) {
		this.tipoScuolaCod = tipoScuolaCod;
		this.statoCaric = statoCaric;
	}

	public MiurTipiScuole(String tipoScuolaCod, String des, boolean statoCaric, Date dataCaric) {
		this.tipoScuolaCod = tipoScuolaCod;
		this.des = des;
		this.statoCaric = statoCaric;
		this.dataCaric = dataCaric;
	}

	public String getTipoScuolaCod() {
		return this.tipoScuolaCod;
	}

	public void setTipoScuolaCod(String tipoScuolaCod) {
		this.tipoScuolaCod = tipoScuolaCod;
	}

	public String getDes() {
		return this.des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public boolean isStatoCaric() {
		return this.statoCaric;
	}

	public void setStatoCaric(boolean statoCaric) {
		this.statoCaric = statoCaric;
	}

	public Date getDataCaric() {
		return this.dataCaric;
	}

	public void setDataCaric(Date dataCaric) {
		this.dataCaric = dataCaric;
	}

}
