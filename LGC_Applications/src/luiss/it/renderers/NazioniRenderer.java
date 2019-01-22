package luiss.it.renderers;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import luiss.it.LGCDB_Clienti.dao.Nazioni;

public class NazioniRenderer implements ListitemRenderer<Nazioni> {

	public void render(Listitem item, Nazioni data, int index) throws Exception {

		item.setValue(data);
		item.appendChild(new Listcell(data.getNazione()));

	}

}