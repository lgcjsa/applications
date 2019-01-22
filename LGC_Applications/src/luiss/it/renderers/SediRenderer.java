package luiss.it.renderers;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import luiss.it.LGCDB_Clienti.dao.Sedi;

public class SediRenderer implements ListitemRenderer<Sedi> {

	public void render(Listitem item, Sedi data, int index) throws Exception {

		item.setValue(data);
		item.appendChild(new Listcell(data.getDescrizione()));

	}

}