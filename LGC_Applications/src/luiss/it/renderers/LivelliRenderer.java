package luiss.it.renderers;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import luiss.it.LGCDB_Clienti.dao.LivelliSportivi;

public class LivelliRenderer implements ListitemRenderer<LivelliSportivi> {

	public void render(Listitem item, LivelliSportivi data, int index) throws Exception {

		item.setValue(data);
		item.appendChild(new Listcell(data.getLivello()));

	}

}