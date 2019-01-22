package luiss.it.renderers;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import luiss.it.TRIENNALI.dao.Diplomi;

public class DiplomiRenderer implements ListitemRenderer<Diplomi> {

	public void render(Listitem item, Diplomi data, int index) throws Exception {

		item.setValue(data);
		item.appendChild(new Listcell(data.getDenominazione()));

	}

}