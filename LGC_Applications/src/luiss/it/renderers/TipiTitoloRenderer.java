package luiss.it.renderers;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import luiss.it.LGCDB_Clienti.dao.TipiTitoloSup;

public class TipiTitoloRenderer implements ListitemRenderer<TipiTitoloSup> {

	public void render(Listitem item, TipiTitoloSup data, int index) throws Exception {

		item.setValue(data);
		item.appendChild(new Listcell(data.getDes()));

	}

}