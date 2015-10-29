import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class DecryptGUI {

	private static JFrame frame = new JFrame("Tim64 Decrypt");
	private JButton decryptButton = new JButton("Decrypt");
	private JTextArea textArea = new JTextArea(10, 1);
	private JTextArea inputField = new JTextArea();
	private JTextField multiplier;
	private JTextField divider;

	
	public DecryptGUI() {
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setSize(900, 300);
		frame.setLocation(730, 870);

		
		JLabel lblNewLabel = new JLabel("Enter encrypted code to decrypt:");
		lblNewLabel.setBounds(44, 30, 225, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblEncryptedMessage = new JLabel("Decrypted message:");
		lblEncryptedMessage.setBounds(44, 182, 153, 14);
		frame.getContentPane().add(lblEncryptedMessage);
		
		decryptButton.setBounds(766, 152, 89, 20);
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
		
		multiplier = new JTextField();
		multiplier.setEnabled(true);
		multiplier.setBounds(766, 87, 86, 20);
		frame.getContentPane().add(multiplier);
		multiplier.setColumns(1);
		
		divider = new JTextField();
		divider.setEnabled(true);
		divider.setBounds(766, 121, 86, 20);
		frame.getContentPane().add(divider);
		divider.setColumns(1);
		
		decryptButton.setEnabled(false);
		
		JLabel lblEnterDecryptionKey = new JLabel("Decryption key:");
		lblEnterDecryptionKey.setBounds(766, 55, 118, 14);
		frame.getContentPane().add(lblEnterDecryptionKey);
		
		setUpListeners();
	}
	
	private void setUpListeners() {
		
		// Start-Button Listener
		decryptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.setText(Converter.decrypt(inputField.getText(), multiplier.getText(), divider.getText()));
				} catch (IOException e1) {
					System.out.println("Irgendwas ist nicht gut");
				}
			}
		});
		
		// Start-Button Listener
		divider.addKeyListener(new KeyAdapter() {
		
			public void keyReleased(KeyEvent e) {
				if(multiplier.getText().equals("") || multiplier.getText().equals(null) || divider.getText().equals("") || divider.getText().equals(null)) {
	        		decryptButton.setEnabled(false);
	        	} else {
	        		decryptButton.setEnabled(true);
	        	}
			}
		});
		
		// Start-Button Listener
		multiplier.addKeyListener(new KeyAdapter() {
		
			public void keyReleased(KeyEvent e) {
				if(multiplier.getText().equals("") || multiplier.getText().equals(null) || divider.getText().equals("") || divider.getText().equals(null)) {
	        		decryptButton.setEnabled(false);
	        	} else {
	        		decryptButton.setEnabled(true);
	        	}
			}
		});
	}
}
