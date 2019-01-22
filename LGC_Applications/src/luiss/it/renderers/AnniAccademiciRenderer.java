package luiss.it.renderers;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import luiss.it.LGCDB_Clienti.dao.AnniAccademici;

public class AnniAccademiciRenderer implements ListitemRenderer<AnniAccademici> {

	public void render(Listitem item, AnniAccademici data, int index) throws Exception {

		item.setValue(data);
		item.appendChild(new Listcell(data.getDes()));

	}

}