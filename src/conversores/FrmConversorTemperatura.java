package conversores;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import principal.Conversion;

public class FrmConversorTemperatura extends FrmConversorMoneda implements ActionListener{

	public FrmConversorTemperatura(int width, int height) {
		super(width, height);
		unidadPrincipal = "grados Celsius";
	}
	
	@Override
	protected void drawHeader() {
		setTitle("Oracle.ONE  - Conversor de Temperatura");
		
		getContentPane().setBackground(new Color(255,227,195));
		
		createLabel("Ingrese temperatura, y presione Convertir a.. o Convertir de..", 10,5,600,30, new Font("Serif", Font.BOLD, 20), new Color(0,0,0));
		createLabel("Celsius", 10, 65, 180, 50, new Font("Serif", Font.BOLD, 48), new Color(100,100,247));
		createLabel("Temp", 295, 55, 180, 50, new Font("Serif", Font.BOLD, 32), new Color(100,100,247));
		
		cmbListaMonedas = createComboBox(295, 100, 280, 30, getArrayFromList(listaConversiones), new Font("Serif", Font.BOLD, 16), Color.white);
	}
	
	@Override
	protected void initListConversions() {
		listaConversiones.add(new Conversion("Farenheit", 33.8));
		listaConversiones.add(new Conversion("Kelvin", 274.15));
		listaConversiones.add(new Conversion("Rankine", 493.47));
		listaConversiones.add(new Conversion("Reaumur", 0.8));
	}
	
}
