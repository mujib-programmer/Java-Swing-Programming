import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;


public class MainFrame extends JFrame {
	
	// deklarasi komponen-komponen yang akan ditampilkan
	private Toolbar toolbar;
	private TextPanel textPanel;
	private FormPanel formPanel;

	public MainFrame() {
		super("Hello World");
		
		// layout menggunakan BorderLayout
		setLayout(new BorderLayout());
		
		// inisiasi komponen
		toolbar = new Toolbar();
		textPanel = new TextPanel();
		formPanel = new FormPanel();
		
		setJMenuBar(createMenuBar());
		
		// aktifkan event pada toolbar agar bisa bekerja dengan objek textPanel
		toolbar.setStringListener(new StringListener() {

			public void textEmitted(String text) {
				// TODO Auto-generated method stub
				textPanel.appendText(text);
				
			}
			
		});	
		
		formPanel.setFormListener(new FormListener(){
			public void formEventOccurred(FormEvent e) {
				String name = e.getName();
				String occupation = e.getOccupation();
				int ageCat = e.getAgeCategory();
				String empCat = e.getEmpCategory();
				
				textPanel.appendText(name + ": " + occupation + ": " + ageCat 
						+ ", " + empCat + "\n");
				
				System.out.println(e.getGender());
			}
		});
		
		// tambahkan komponen ke MainFrame
		// secara default JFame sudah memiliki ContentPane sendiri
		// jadi bisa langsung ditambahkan
		add(formPanel, BorderLayout.WEST);
		add(toolbar, BorderLayout.NORTH);
		add(textPanel, BorderLayout.CENTER);		
		
		// atur ukuran frame
		setSize(600, 500);
		
		// tutup frame ketika ikon x diklik
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// tampilkan MainFrame
		setVisible(true);
		
	}
	
	private JMenuBar createMenuBar() {
		JMenuBar menuBar =  new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		
		JMenuItem exportDataItem = new JMenuItem("Export Data...");
		JMenuItem importDataItem = new JMenuItem("Import Data...");
		JMenuItem exitItem = new JMenuItem("Exit");
		
		fileMenu.add(exportDataItem);
		fileMenu.add(importDataItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);
		
		JMenu windowMenu =  new JMenu("Window");
		JMenu showMenu = new JMenu("Show");
		JMenuItem showFormItem = new JMenuItem("Person Form");
		showMenu.add(showFormItem);
		windowMenu.add(showMenu);
		
		menuBar.add(fileMenu);
		menuBar.add(windowMenu);
		
		return menuBar;
	}
}
