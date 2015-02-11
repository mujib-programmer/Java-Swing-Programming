import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import com.sun.glass.events.KeyEvent;


public class MainFrame extends JFrame {
	
	// deklarasi komponen-komponen yang akan ditampilkan
	private Toolbar toolbar;
	private TextPanel textPanel;
	private FormPanel formPanel;
	private JFileChooser fileChooser;

	public MainFrame() {
		super("Hello World");
		
		// layout menggunakan BorderLayout
		setLayout(new BorderLayout());
		
		// inisiasi komponen
		toolbar = new Toolbar();
		textPanel = new TextPanel();
		formPanel = new FormPanel();
		
		fileChooser =  new JFileChooser();
		fileChooser.addChoosableFileFilter(new PersonFileFilter());
		
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
		setMinimumSize(new Dimension(500, 400));
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
		
		JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Person Form");
		showFormItem.setSelected(true);
		
		showMenu.add(showFormItem);
		windowMenu.add(showMenu);
		
		menuBar.add(fileMenu);
		menuBar.add(windowMenu);
		
		showFormItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev) {
				JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) ev.getSource();
				
				formPanel.setVisible(menuItem.isSelected());
			}
			
		});
		
		fileMenu.setMnemonic(KeyEvent.VK_F);
		exitItem.setMnemonic(KeyEvent.VK_X);
		
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		
		importDataItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					System.out.println(fileChooser.getSelectedFile());
				}
			}
			
		});
		
		exportDataItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
					System.out.println(fileChooser.getSelectedFile());
				}
			}
			
		});
		
		exitItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(MainFrame.this
						, "Do you really want to exit the application?"
						, "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);
				
				if (action == JOptionPane.OK_OPTION) {
					System.exit(0);				
				}
			}
			
		});
		
		return menuBar;
	}
}
