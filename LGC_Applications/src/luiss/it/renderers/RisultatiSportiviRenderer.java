package luiss.it.renderers;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import luiss.it.LGCDB_Clienti.dao.RisultatiSportivi;

public class RisultatiSportiviRenderer implements ListitemRenderer<RisultatiSportivi> {

	public void render(Listitem item, RisultatiSportivi data, int index) throws Exception {

		item.setValue(data);
		item.appendChild(new Listcell(data.getMedaglia()));
		item.appendChild(new Listcell(data.getDescrizione()));

	}

}