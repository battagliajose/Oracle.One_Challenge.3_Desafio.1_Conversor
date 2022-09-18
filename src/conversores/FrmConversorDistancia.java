package conversores;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import principal.Conversion;
import principal.FrmConversor;

public class FrmConversorDistancia extends FrmConversor implements ActionListener {
	
	public FrmConversorDistancia (int width, int height) {
		super(width, height);
		unidadPrincipal = "Metros";
	}
	
	@Override
	protected void drawHeader() {
		setTitle("Oracle.ONE  - Conversor de Distancia");
		
		getContentPane().setBackground(new Color(227,255,195));
		
		createLabel("Ingrese distancia en metros, y presione Convertir a.. o Convertir de..", 10,5,600,30, new Font("Serif", Font.BOLD, 20), new Color(0,0,0));
		createLabel("Metros", 10, 65, 180, 50, new Font("Serif", Font.BOLD, 48), new Color(100,100,247));
		createLabel("Distancia", 295, 55, 180, 50, new Font("Serif", Font.BOLD, 32), new Color(100,100,247));
		
		cmbListaMonedas = createComboBox(295, 100, 280, 30, getArrayFromList(listaConversiones), new Font("Serif", Font.BOLD, 16), Color.white);
	}
	
	@Override
	protected void initListConversions() {
		listaConversiones.add(new Conversion("Millas", 0.000621371d));
		listaConversiones.add(new Conversion("Yardas", 1.09361d));
		listaConversiones.add(new Conversion("Pies", 3.28084d));
		listaConversiones.add(new Conversion("Millas Náuticas", 0.00053995682073434d));
	}
}
