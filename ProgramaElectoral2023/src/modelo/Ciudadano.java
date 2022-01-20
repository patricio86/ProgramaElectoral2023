package modelo;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Ciudadano extends Thread{

	private int edad;
	private int voto;
	private String comunidad;
	private ColegioElectoral colegioElectoral = null;
	
	


	public Ciudadano(int edad, int voto, String comunidad) {
		this.edad = edad;
		this.voto = voto;
		this.comunidad = comunidad;
	}




	public void run() {
		
		ArrayList<Votacion> registroelectoral = new ArrayList<Votacion>();
		
		colegioElectoral = colegioElectoral.getInstance();
		
		try {
			
			Boolean comprobarpartido = colegioElectoral.votar(voto,edad);
			if(comprobarpartido) {
				
				if(18 >= edad && edad <= 25 ) {
					
					if(0 <= voto && voto <= 30) {
						
						registroelectoral.add(new Votacion(edad,comunidad,"partido X"));
						
					} 
					
					if(31 <= voto && voto <= 50) {
								
						registroelectoral.add(new Votacion(edad,comunidad,"partido Y"));
					
					}
					
					if(51 <= voto && voto <= 70) {
						
						registroelectoral.add(new Votacion(edad,comunidad,"partido W"));
						
					}
					
					if(71 <= voto && voto <= 100) {
						
						registroelectoral.add(new Votacion(edad,comunidad,"partido Z"));
					
					}
					
				}
				
				if(26 >= edad && edad <= 40) {
					
					if(0 <= voto && voto <= 20) {
						
						registroelectoral.add(new Votacion(edad,comunidad,"partido X"));
						
					}
					
					if(21 <= voto && voto <= 55) {
								
						registroelectoral.add(new Votacion(edad,comunidad,"partido Y"));
						
					}
					
					if(56 <= voto && voto <= 85) {
						
						registroelectoral.add(new Votacion(edad,comunidad,"partido W"));
						
						
					}
					
					if(86 <= voto && voto <= 100) {
						
						
						registroelectoral.add(new Votacion(edad,comunidad,"partido Z"));
						
						
					}
					
					
				}

				if(41 >= edad && edad <= 65 ) {
					
					if(0 <= voto && voto <= 10) {
						
						
						registroelectoral.add(new Votacion(edad,comunidad,"partido X"));
						
						
					}
					
					if(10 <= voto && voto <= 55) {
								
						
						registroelectoral.add(new Votacion(edad,comunidad,"partido Y"));
						
						
					}
					
					if(56 <= voto && voto <= 90) {
						
						
						registroelectoral.add(new Votacion(edad,comunidad,"partido W"));
						
						
					}
					
					if(91 <= voto && voto <= 100) {
						
						
						registroelectoral.add(new Votacion(edad,comunidad,"partido Z"));
						
						
					}
					
					
				}


				if(66 >= edad ) {
					
					if(0 <= voto && voto <= 25) {
						
						
						registroelectoral.add(new Votacion(edad,comunidad,"partido X"));
						
						
					}
					
					if(26 <= voto && voto <= 60) {
								
						
						registroelectoral.add(new Votacion(edad,comunidad,"partido Y"));
						
						
					}
					
					if(61 <= voto && voto <= 95) {
						
						registroelectoral.add(new Votacion(edad,comunidad,"partido W"));
						
						
					}
					
					if(96 <= voto && voto <= 100) {
						
						registroelectoral.add(new Votacion(edad,comunidad,"partido Z"));
					
					}
					
					
			}
				
				
		}
			
			
			this.sleep(1000);
		}catch(Exception e) {
	
					e.printStackTrace();
				
			}
	}

}
