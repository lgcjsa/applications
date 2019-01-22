package luiss.it.renderers;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import luiss.it.LGCDB_Clienti.dao.NazioniEng;

public class NazioniEngRenderer implements ListitemRenderer<NazioniEng> {

	public void render(Listitem item, NazioniEng data, int index) throws Exception {

		item.setValue(data);
		item.appendChild(new Listcell(data.getNazione()));

	}

}