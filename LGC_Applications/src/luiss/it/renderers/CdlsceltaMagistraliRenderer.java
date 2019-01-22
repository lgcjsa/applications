package luiss.it.renderers;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import luiss.it.MAGISTRALI_INT.dao.Cdlscelta;

public class CdlsceltaMagistraliRenderer implements ListitemRenderer<Cdlscelta> {

	public void render(Listitem item, Cdlscelta data, int index) throws Exception {

		item.setValue(data);
		item.appendChild(new Listcell(data.getDescrizione()));

	}

}