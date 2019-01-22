package luiss.it.renderers;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import luiss.it.TRIENNALI_INT.dao.Cdlscelta;

public class CdlsceltaRenderer implements ListitemRenderer<Cdlscelta> {

	public void render(Listitem item, Cdlscelta data, int index) throws Exception {

		item.setValue(data);
		item.appendChild(new Listcell(data.getDescrizione()));

	}

}