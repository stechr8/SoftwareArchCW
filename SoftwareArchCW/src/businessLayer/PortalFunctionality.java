package businessLayer;

import java.awt.Desktop;
import java.net.URI;

import org.slf4j.LoggerFactory;

public class PortalFunctionality {
	
	private static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(PortalFunctionality.class);
	
	public void OpenPortal() {
				
		try {
			if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
			    Desktop.getDesktop().browse(new URI("https://www.theaccessgroup.com/finance/solutions/cloud-accounting-software/"));
			}
		} 
		catch(Exception ex) {
			LOGGER.error(ex.getMessage());
			System.out.println(ex.getMessage());
		}

	}


}
