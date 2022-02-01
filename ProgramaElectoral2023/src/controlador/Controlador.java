package controlador;

import vista.EstadisticaElectoral;

import modelo.Modelo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controlador implements ActionListener{

	EstadisticaElectoral vista = new EstadisticaElectoral();
	
	
	
	public Controlador(EstadisticaElectoral vista) {
		this.vista = vista;
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}
