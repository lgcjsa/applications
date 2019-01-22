package luiss.it.renderers;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import luiss.it.LGCDB_Clienti.dao.DisciplineSportive;

public class SportsRenderer implements ListitemRenderer<DisciplineSportive> {

	public void render(Listitem item, DisciplineSportive data, int index) throws Exception {

		item.setValue(data);
		item.appendChild(new Listcell(data.getSport()));

	}

}