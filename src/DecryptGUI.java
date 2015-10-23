import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class DecryptGUI {

	private static JFrame frame = new JFrame("Tim64 Decrypt");
	private JButton decryptButton = new JButton("Decrypt");
	private JTextArea textArea = new JTextArea(10, 1);
	private JTextArea inputField = new JTextArea();

	
	public DecryptGUI() {
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setSize(900, 300);
		
		JLabel lblNewLabel = new JLabel("Enter encrypted code to decrypt:");
		lblNewLabel.setBounds(44, 30, 225, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblEncryptedMessage = new JLabel("Decrypted message:");
		lblEncryptedMessage.setBounds(44, 182, 153, 14);
		frame.getContentPane().add(lblEncryptedMessage);
		
		decryptButton.setBounds(766, 55, 89, 20);
		frame.getContentPane().add(decryptButton);
		textArea.setEditable(false);
		textArea.setColumns(10);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(false);
		
		textArea.setBounds(44, 207, 689, 44);
		frame.getContentPane().add(textArea);
		
		JScrollPane scrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(44, 55, 689, 117);
		frame.getContentPane().add(scrollPane);
		
		inputField.setRows(1);
		inputField.setLineWrap(true);
		inputField.setWrapStyleWord(false);
		inputField.setColumns(10);
		scrollPane.setViewportView(inputField);
		
		setUpListeners();
	}
	
	private void setUpListeners() {
		
		// Start-Button Listener
		decryptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.setText(Converter.decrypt(inputField.getText()));
				} catch (IOException e1) {
					System.out.println("Irgendwas ist nicht gut");
					//					e1.printStackTrace();
				}
				System.out.println("Encrypt gedrückt");
			}
		});
	}
}
