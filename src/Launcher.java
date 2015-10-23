import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Launcher {
	private static JFrame frame = new JFrame("Tim64 En-/Decryptor");
	private static JButton decryptBtn = new JButton("Decrypt");
	private static JButton encryptBtn = new JButton("Encrypt");

	
	public Launcher() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(960, 540);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.setSize(450, 300);
		frame.setVisible(true);
		
		decryptBtn.setBounds(96, 152, 243, 52);
		frame.getContentPane().add(decryptBtn);
		
		encryptBtn.setBounds(96, 56, 243, 52);
		frame.getContentPane().add(encryptBtn);
		
		setUpListeners();
	}

	public static void setUpListeners() {
		
		// Start-Button Listener
		encryptBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EncryptGUI();
			}
		});
		
		// Start-Button Listener
		decryptBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DecryptGUI();
			}
		});
	}
}