package principal;

import javax.swing.*;

import conversores.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class FrmSeleccionConversor extends Form implements ActionListener{
	private JLabel lblElijaConversor;
	private JButton btnOk, btnSalir;
	private JComboBox cmbLista;
	
	public FrmSeleccionConversor(int width, int height) {
		super(width, height);
		setLayout(null);
		
		setTitle("Oracle.ONE  - Conversores - Challenge");
		
		lblElijaConversor = createLabel("Elija Conversor", 10, 5, 200, 30, new Font("Serif", Font.PLAIN, 22), Color.black);
		
		String[] arrayCombo = {"Conversor de Moneda", "Conversor de Temperatura", "Conversor de Distancia"};
		cmbLista = createComboBox(10, 50, 365, 30, arrayCombo, new Font("Serif", Font.BOLD, 16), Color.white);
		
		btnOk = new JButton("Iniciar");
		btnOk.setBounds(100, 200, 80, 20);
		btnOk.addActionListener(this);
		add(btnOk);
	
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(200,200,80,20);
		btnSalir.addActionListener(this);
		add(btnSalir);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btnOk) {
			
			int selectedItem = cmbLista.getSelectedIndex();
			
			switch (selectedItem) {
				case 0:
					FrmConversorMoneda frmConversorMoneda = new FrmConversorMoneda(600,500);
					this.hideForm();
					frmConversorMoneda.showForm();
					break;
				case 1:
					FrmConversorTemperatura frmConversorTemperatura = new FrmConversorTemperatura(600,500);
					this.hideForm();
					frmConversorTemperatura.showForm();
					break;
				case 2:
					FrmConversorDistancia frmConversorDistancia = new FrmConversorDistancia(600,500);
					this.hideForm();
					frmConversorDistancia.showForm();
					break;
				default:
					System.out.println("Error!");
			}

		}
		
		if(e.getSource()==btnSalir) {
			JOptionPane.showMessageDialog(null, "Programa Finalizado!", "Oracle.ONE Conversor", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
	}
}
