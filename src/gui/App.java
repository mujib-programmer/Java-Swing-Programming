package gui;
import javax.swing.SwingUtilities;


public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MainFrame();
			}			
		});
		

	}

}
