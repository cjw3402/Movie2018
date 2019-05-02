package mrs.main;

import javax.swing.UIManager;

import mrs.gui.LoginFrame;

public class MrsMain {

	public static void main(String[] args) {
		
		// look&feel 적용
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		new LoginFrame();
		
	}

}
