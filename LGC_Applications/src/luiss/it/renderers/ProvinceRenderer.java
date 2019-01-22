package luiss.it.renderers;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

import luiss.it.LGCDB_Clienti.dao.Province;

public class ProvinceRenderer implements ListitemRenderer<Province> {

	public void render(Listitem item, Province data, int index) throws Exception {

		item.setValue(data);
		item.appendChild(new Listcell(data.getProvincia()));

	}

}