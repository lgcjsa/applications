package luiss.it.renderers;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

public class StringRenderer implements ListitemRenderer<String> {

	public void render(Listitem item, String data, int index) throws Exception {

		item.setValue(data);
		item.appendChild(new Listcell(data));

	}

}