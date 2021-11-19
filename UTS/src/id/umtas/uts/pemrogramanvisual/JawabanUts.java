package id.umtas.uts.pemrogramanvisual;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;


public class JawabanUts extends JFrame {
	
	JTextField textField = new JTextField("", 20);
	JLabel label = new JLabel("Masukan Nama");
	JLabel resultLabel = new JLabel();
	JButton button = new JButton("Proses");
	JTextPane test = new JTextPane();
	
	public JawabanUts() {
		super("UTS Pemrograman Visual");
		setLayout(new FlowLayout());
		
		// setting component
		resultLabel.setForeground(Color.RED);
		
		// process
		// adds event listener which listens to Enter key event
		textField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JOptionPane.showMessageDialog(JawabanUts.this, 
						textField.getText());
			}
		});
		
		// adds key event listener
		textField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent event) {
				String content = textField.getText();
				if (!content.equals("")) {
					button.setEnabled(true);
				} else {
					button.setEnabled(false);
				}
			}			
		});
		
		// adds action listener for the button
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				resultLabel.setText("Selamat Datang. " + textField.getText());
			}
		});
		
		JPanel panelInput = new JPanel(new GridLayout(1, 1));
		panelInput.add(label);
		panelInput.add(textField);
		
		JPanel panelButton = new JPanel(new FlowLayout(2));
		panelButton.add(button);
		
		JPanel panelResultLabel = new JPanel(new FlowLayout(2));
		panelResultLabel.add(resultLabel);
		
		JPanel buttonPanel = new JPanel(new GridLayout(3, 2));
	    buttonPanel.add(panelInput);
	    buttonPanel.add(panelButton);
	    buttonPanel.add(panelResultLabel);
	    add(buttonPanel);
	        
		
		setSize(700, 700);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new JawabanUts();
			}
		});
	}

}
