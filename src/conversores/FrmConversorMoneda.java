package conversores;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.*;

import principal.*;

public class FrmConversorMoneda extends FrmConversor implements ActionListener{

	public FrmConversorMoneda(int width, int height) {
		super(width, height);
	}
	
	@Override
	protected void drawHeader() {
		setTitle("Oracle.ONE  - Conversor de Moneda");
		
		getContentPane().setBackground(new Color(195,227,255));
		
		createLabel("Ingrese cantidad de pesos u otra moneda, seleccione tipo de moneda", 10,5,600,30, new Font("Serif", Font.BOLD, 20), new Color(0,0,0));
		createLabel("y presione Convertir a.. o Convertir de..", 10,30,600,30, new Font("Serif", Font.BOLD, 20), new Color(0,0,0));
		createLabel("Pesos", 10, 65, 120, 50, new Font("Serif", Font.BOLD, 48), new Color(100,100,247));
		createLabel("Moneda", 295, 55, 160, 50, new Font("Serif", Font.BOLD, 32), new Color(100,100,247));
		
		cmbListaMonedas = createComboBox(295, 100, 280, 30, getArrayFromList(listaConversiones), new Font("Serif", Font.BOLD, 16), Color.white);
	}
	
	@Override
	protected void initListConversions() {
		listaConversiones.add(new Conversion("Bolivianos", 0.048));
		listaConversiones.add(new Conversion("Dólares", 0.0068d));
		listaConversiones.add(new Conversion("Euros", 0.0070d));
		listaConversiones.add(new Conversion("Guaranís paraguayos", 48.64));
		listaConversiones.add(new Conversion("Libras Esterlinas", 0.0061d));
		listaConversiones.add(new Conversion("Pesos Mexicanos", 0.14d));
		listaConversiones.add(new Conversion("Rupias Indias", 0.56d));
		listaConversiones.add(new Conversion("Yen Japonés", 1));
		listaConversiones.add(new Conversion("Won sur-coreanos", 9.65));
	}

}
