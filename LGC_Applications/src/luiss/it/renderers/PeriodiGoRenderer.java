package luiss.it.renderers;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import luiss.it.Orientamento.dao.PeriodiGo;

public class PeriodiGoRenderer implements ListitemRenderer<PeriodiGo> {

	public void render(Listitem item, PeriodiGo data, int index) throws Exception {

		item.setValue(data);
		item.appendChild(new Listcell(data.getDescrizione()));

	}

}