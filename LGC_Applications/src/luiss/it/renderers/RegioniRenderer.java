package luiss.it.renderers;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import luiss.it.LGCDB_Clienti.dao.Regioni;

public class RegioniRenderer implements ListitemRenderer<Regioni> {

	public void render(Listitem item, Regioni data, int index) throws Exception {

		item.setValue(data);
		item.appendChild(new Listcell(data.getRegione()));

	}

}