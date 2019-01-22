package luiss.it.listners;

import java.util.Map;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.util.Initiator;

import luiss.it.LGCDB_Clienti.db.*;
import luiss.it.LGCDB_Clienti.dao.Config;
import luiss.it.LGCDB_Clienti.dao.Contesti;
import luiss.it.LGCDB_Clienti.dao.Log;



public class AccessControl implements Initiator {

	@Override
	public void doInit(Page page, Map<String, Object> args) throws Exception {
		// TODO Auto-generated method stub
		String uri = page.getRequestPath();
		String remote = Executions.getCurrent().getRemoteAddr();
		Log log = new Log();
		log.setDescrizione(remote +  "-->" + uri);
		new ManageLog().insert(log);
		String codiceContesto = Executions.getCurrent().getParameter("contesto");
		
		if (codiceContesto != null) {
			
			Contesti contesto = new ManageContesti().getByCodice(codiceContesto);
			Config config = new ManageConfig().getByID(contesto.getId());
			
			if (config.getScadenzaVisibilita() != null) {
				
				long now = System.currentTimeMillis();
				long scadenza = config.getScadenzaVisibilita().getTime();
				
				System.out.println(now + " " + scadenza);
				
				if (now > scadenza) {
					Executions.getCurrent().sendRedirect("http://www.luiss.it/node/27641");
				}
				
			}
			
		}
		
		

	}

}
