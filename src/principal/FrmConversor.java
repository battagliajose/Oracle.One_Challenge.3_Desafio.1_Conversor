package principal;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.*;

import principal.Conversion;
import principal.Form;
import principal.FrmSeleccionConversor;


public class FrmConversor extends Form implements ActionListener{
	
	protected JTextField txtMedidaPrincipal, txtMedidaSecundaria;
	protected JButton btnConvertirA, btnConvertirDe, btnSalir, btnVolver;
	protected JComboBox cmbListaMonedas;
	protected JTextArea txtAreaLog;
	
	protected String unidadPrincipal = "Unidad";
	
	protected List<Conversion> listaConversiones = new ArrayList<Conversion>();

	public FrmConversor(int width, int height) {
		super(width, height);
		initListConversions();
		drawForm();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int selectedMoneda = cmbListaMonedas.getSelectedIndex();
		
		if (e.getSource() == btnConvertirA) {
			if(validateTextFieldNumber(txtMedidaPrincipal)) {
				Double pesos = Double.parseDouble(txtMedidaPrincipal.getText());
				Double conversion = pesos * listaConversiones.get(selectedMoneda).getTasaDeCambio();
				Double textConversion = (double) Math.round(conversion * 100d) / 100;
				txtMedidaSecundaria.setText(textConversion.toString());
				
				log(pesos + " " + unidadPrincipal + " son " + textConversion + " " + cmbListaMonedas.getSelectedItem());
			}
		}
		
		if (e.getSource() == btnConvertirDe) {
			if(validateTextFieldNumber(txtMedidaSecundaria)) {
				Double moneda = Double.parseDouble(txtMedidaSecundaria.getText());
				Double conversion = moneda / listaConversiones.get(selectedMoneda).getTasaDeCambio();
				
				Double textConversion = (double) Math.round(conversion * 100d) / 100;
				txtMedidaPrincipal.setText(textConversion.toString());
				
				log(moneda + " " + cmbListaMonedas.getSelectedItem() + " son " + textConversion + " " + unidadPrincipal);
			}
		}
		
		if (e.getSource() == btnSalir) {
			JOptionPane.showMessageDialog(null, "Programa Finalizado!", "Oracle.ONE Conversor", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
		
		if (e.getSource() == btnVolver) {
			this.setVisible(false);
			FrmSeleccionConversor frmSeleccionConversor = new FrmSeleccionConversor(400, 300);
			frmSeleccionConversor.showForm();
		
		}
	}
	
	private void log(String text) {
		txtAreaLog.setText(text + "\n" + txtAreaLog.getText());
	}
	
	protected void initListConversions() {
	}
	
	protected String[] getArrayFromList (List<Conversion> listaMonedas) {
		String[] array = new String[listaMonedas.size()];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = listaMonedas.get(i).getNombre();
		}

		return array;
	}
	
	private boolean validateTextFieldNumber(JTextField textField) {
		try {
			String valor = textField.getText();
			if (valor != null && valor.length()> 0) {
				Double valorNumerico = Double.parseDouble(valor.toString().replaceAll("[^\\.0123456789]",""));
				if (valor.length() > valorNumerico.toString().length()) {
					System.out.println(valor.length());
					System.out.println(valorNumerico.toString().length());
					log("Por favor ingrese solo numeros y punto, se eliminaron los caracteres no validos..");
				}
				textField.setText(valorNumerico.toString());
				return true;
			} else {
				log("Por favor ingrese un valor númerico primero");
			}
		} catch (Exception e) {
			textField.setText("");
			log("Por favor verifique el valor ingresado e intente de nuevo");
		}
		return false;
	}
	
	private void drawForm() {
		setLayout(null);
		
		drawHeader();
		
		txtMedidaPrincipal = createTextField(10, 135, 280, 80, Color.white);
		txtMedidaSecundaria = createTextField(295, 135, 280, 80, Color.white);
		
		btnConvertirA = new JButton("Convertir a ->");
		btnConvertirA.setBounds(160, 220, 130, 40);
		btnConvertirA.addActionListener(this);
		btnConvertirA.setFont(new Font("Serif", Font.PLAIN, 16));
		add(btnConvertirA);
		
		btnConvertirDe = new JButton("<- Convertir de");
		btnConvertirDe.setBounds(295, 220, 130, 40);
		btnConvertirDe.addActionListener(this);
		btnConvertirDe.setFont(new Font("Serif", Font.PLAIN, 16));
		add(btnConvertirDe);
		
		txtAreaLog = new JTextArea();
		txtAreaLog.setBounds(10,270,563,120);
		txtAreaLog.setFont(new Font("Serif", Font.BOLD, 14));
		txtAreaLog.setEditable(false);
		txtAreaLog.setBackground(new Color(249, 249, 249));
		txtAreaLog.setBorder(BorderFactory.createLoweredBevelBorder());
		add(txtAreaLog);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(160,400,130,40);
		btnSalir.addActionListener(this);
		btnSalir.setFont(new Font("Serif", Font.PLAIN, 16));
		add(btnSalir);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(295, 400, 130, 40);
		btnVolver.addActionListener(this);
		btnVolver.setFont(new Font("Serif", Font.PLAIN, 16));
		add(btnVolver);
	}
	
	protected void drawHeader() {

	}

}
