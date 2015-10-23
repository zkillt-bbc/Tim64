import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

public class EncryptGUI {

	private static JFrame frame = new JFrame("Tim64 Encrypt");
	private JButton encryptButton = new JButton("Encrypt");
	private JTextPane inputField = new JTextPane();
	private JTextArea textArea = new JTextArea();
	
	public EncryptGUI() {
		
		JScrollPane scroll = new JScrollPane (ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setLocation(44, 134);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.setSize(900, 300);
		
		scroll.setSize(689, 117);
		
		inputField.setBounds(44, 55, 689, 20);
		frame.getContentPane().add(inputField);
		
		JLabel lblNewLabel = new JLabel("Enter message to encrypt:");
		lblNewLabel.setBounds(44, 30, 153, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblEncryptedMessage = new JLabel("Encrypted message:");
		lblEncryptedMessage.setBounds(44, 105, 153, 14);
		frame.getContentPane().add(lblEncryptedMessage);
		
		encryptButton.setBounds(766, 55, 89, 20);
		frame.getContentPane().add(encryptButton);
		
		frame.getContentPane().add(scroll);
		scroll.setViewportView(textArea);
		textArea.setRows(1);
		
		textArea.setEditable(false);
		textArea.setEditable(false);
		textArea.setColumns(10);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(false);
		frame.setVisible(true);

		setUpListeners();
	}
	
	private void setUpListeners() {

		encryptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.setText(Converter.encrypt(inputField.getText()));
				} catch (IOException e1) {
					System.out.println("Irgendwas ist nicht gut");
					//					e1.printStackTrace();
				}
				System.out.println("Encrypt gedrückt");
			}
		});
	}
}
