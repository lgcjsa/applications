package luiss.it.renderers;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import luiss.it.Orientamento.dao.MiurScuole;

public class MiurScuoleRenderer implements ListitemRenderer<MiurScuole> {

	public void render(Listitem item, MiurScuole data, int index) throws Exception {

		item.setValue(data);
		item.appendChild(new Listcell(data.getDenominazione()));

	}

}