package luiss.it.renderers;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import luiss.it.LGCDB_Clienti.dao.Comuni;

public class ComuniRenderer implements ListitemRenderer<Comuni> {

	public void render(Listitem item, Comuni data, int index) throws Exception {

		item.setValue(data);
		item.appendChild(new Listcell(data.getComune()));

	}

}