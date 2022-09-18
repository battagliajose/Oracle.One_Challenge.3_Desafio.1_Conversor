package principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.print.DocFlavor.URL;
import javax.swing.*;

public class Form extends JFrame implements ActionListener{
	
	private int width;
	private int height;
	
	public Form (int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	public void showForm () {
		java.net.URL url = getClass().getResource("..\\dollar.png");
		ImageIcon imgicon = new ImageIcon(url);
		super.setIconImage(imgicon.getImage());
		
		this.setBounds(0, 0, width, height);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}
	
	protected void hideForm () {
		this.setVisible(false);
	}
	
	protected JLabel createLabel(String text, int x, int y, int width, int height, Font font, Color color) {
		JLabel label = new JLabel(text);
		label.setBounds(x, y, width, height);
		label.setFont(font);
		label.setForeground(color);
		add(label);
		label = new JLabel(text);
		label.setFont(font);
		label.setBounds(x+2, y+2, width, height);
		label.setForeground(Color.white);
		add(label);
		return label;
	}
	
	protected JButton createButton(String text, int x, int y, int width, int height) {
		JButton button = new JButton(text);
		button.setBounds(x, y, width, height);
		button.addActionListener(this);
		add(button);
		
		return button;
	}
	
	protected JTextField createTextField(int x, int y, int width, int height, Color color) {
		JTextField textField = new JTextField();
		textField.setBounds(x, y, width, height);
		textField.setFont(new Font("Serif", Font.PLAIN, 64));
		textField.setBackground(color);
		add(textField);
		return textField;
	}
	
	protected JComboBox createComboBox(int x, int y, int width, int height, String[] arrayCombo, Font font, Color color) {
		JComboBox combo = new JComboBox();
		combo.setBounds(x, y, width, height);
		combo.setBackground(color);
		combo.setBorder(BorderFactory.createLoweredBevelBorder());
		combo.setFont(font);
		add(combo);
				
		for (int i = 0; i < arrayCombo.length; i++) {
			combo.addItem(arrayCombo[i]);
		}

		return combo;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
