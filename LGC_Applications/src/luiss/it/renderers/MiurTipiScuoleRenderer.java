package luiss.it.renderers;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import luiss.it.Orientamento.dao.MiurTipiScuole;

public class MiurTipiScuoleRenderer implements ListitemRenderer<MiurTipiScuole> {

	public void render(Listitem item, MiurTipiScuole data, int index) throws Exception {

		item.setValue(data);
		item.appendChild(new Listcell(data.getDes()));

	}

}