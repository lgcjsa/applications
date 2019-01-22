package luiss.it.renderers;

import org.zkoss.zul.Comboitem;
import org.zkoss.zul.ComboitemRenderer;

public class StringComboRenderer implements ComboitemRenderer<String> {

	@Override
	public void render(Comboitem item, String data, int index) throws Exception {
		
		item.setValue(data);
		item.setLabel(data);
		
	}
	
}