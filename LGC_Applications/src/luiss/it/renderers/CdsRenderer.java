package luiss.it.renderers;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import luiss.it.LGCDB_Clienti.dao.Cds;

public class CdsRenderer implements ListitemRenderer<Cds> {

	public void render(Listitem item, Cds data, int index) throws Exception {

		item.setValue(data);
		item.appendChild(new Listcell(data.getDes()));

	}

}