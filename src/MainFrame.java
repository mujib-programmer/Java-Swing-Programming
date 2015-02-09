import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class MainFrame extends JFrame {
	
	// deklarasi komponen-komponen yang akan ditampilkan
	private JTextArea textArea;
	private JButton btn;

	public MainFrame() {
		super("Hello World");
		
		// layout menggunakan BorderLayout
		setLayout(new BorderLayout());
		
		// inisiasi komponen
		textArea = new JTextArea();
		btn = new JButton("Click Me!");
		
		// tambahkan event pada tombol Click Me!
		btn.addActionListener(new ActionListener() {
			
			// tambahkan kata hello di text area ketika tombol di klik
			public void actionPerformed(ActionEvent e) {
				textArea.append("Hello \n");
				
			}
			
			
		});
		
		// tambahkan komponen ke MainFrame
		// secara default JFame sudah memiliki ContentPane sendiri
		// jadi bisa langsung ditambahkan
		add(textArea, BorderLayout.CENTER);
		add(btn, BorderLayout.SOUTH);
		
		// atur ukuran frame
		setSize(600, 500);
		
		// tutup frame ketika ikon x diklik
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// tampilkan MainFrame
		setVisible(true);
		
		
	}
}
