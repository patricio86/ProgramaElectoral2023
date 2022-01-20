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
		
		SessionFactory sessionFactory = null;
		colegioElectoral = colegioElectoral.getInstance();
		
		try {
			
	        Configuration configuration = new Configuration();
	        configuration.configure("hibernate.cfg.xml");

	        sessionFactory = configuration.buildSessionFactory();
	        
	        sessionFactory.getCurrentSession().beginTransaction();
	        
			Boolean comprobarpartido = colegioElectoral.votar(voto,edad);
			
			if(comprobarpartido) {
				
				if(18 >= edad && edad <= 25 ) {
					
					if(0 <= voto && voto <= 30) {
						
						Votacion votacion = new Votacion();
						votacion.setEdad(edad);
						votacion.setComunidad(comunidad);
						votacion.setPartidovotado("partido X");
						sessionFactory.getCurrentSession().save(votacion);
						
					} 
					
					if(31 <= voto && voto <= 50) {
								
						Votacion votacion = new Votacion();
						votacion.setEdad(edad);
						votacion.setComunidad(comunidad);
						votacion.setPartidovotado("partido Y");
						sessionFactory.getCurrentSession().save(votacion);
					
					}
					
					if(51 <= voto && voto <= 70) {
						
						Votacion votacion = new Votacion();
						votacion.setEdad(edad);
						votacion.setComunidad(comunidad);
						votacion.setPartidovotado("partido W");
						sessionFactory.getCurrentSession().save(votacion);
						
					}
					
					if(71 <= voto && voto <= 100) {
						
						Votacion votacion = new Votacion();
						votacion.setEdad(edad);
						votacion.setComunidad(comunidad);
						votacion.setPartidovotado("partido Z");
						sessionFactory.getCurrentSession().save(votacion);
					
					}
					
				}
				
				if(26 >= edad && edad <= 40) {
					
					if(0 <= voto && voto <= 20) {
						
						Votacion votacion = new Votacion();
						votacion.setEdad(edad);
						votacion.setComunidad(comunidad);
						votacion.setPartidovotado("partido X");
						sessionFactory.getCurrentSession().save(votacion);
						
					}
					
					if(21 <= voto && voto <= 55) {
								
						Votacion votacion = new Votacion();
						votacion.setEdad(edad);
						votacion.setComunidad(comunidad);
						votacion.setPartidovotado("partido Y");
						sessionFactory.getCurrentSession().save(votacion);
						
					}
					
					if(56 <= voto && voto <= 85) {
						
						Votacion votacion = new Votacion();
						votacion.setEdad(edad);
						votacion.setComunidad(comunidad);
						votacion.setPartidovotado("partido W");
						sessionFactory.getCurrentSession().save(votacion);
						
					}
					
					if(86 <= voto && voto <= 100) {
						
						Votacion votacion = new Votacion();
						votacion.setEdad(edad);
						votacion.setComunidad(comunidad);
						votacion.setPartidovotado("partido Z");
						sessionFactory.getCurrentSession().save(votacion);
						
					}
				}

				if(41 >= edad && edad <= 65 ) {
					
					if(0 <= voto && voto <= 10) {
						
						Votacion votacion = new Votacion();
						votacion.setEdad(edad);
						votacion.setComunidad(comunidad);
						votacion.setPartidovotado("partido X");
						sessionFactory.getCurrentSession().save(votacion);
						
					}
					
					if(10 <= voto && voto <= 55) {
								
						Votacion votacion = new Votacion();
						votacion.setEdad(edad);
						votacion.setComunidad(comunidad);
						votacion.setPartidovotado("partido Y");
						sessionFactory.getCurrentSession().save(votacion);
						
					}
					
					if(56 <= voto && voto <= 90) {
						
						Votacion votacion = new Votacion();
						votacion.setEdad(edad);
						votacion.setComunidad(comunidad);
						votacion.setPartidovotado("partido W");
						sessionFactory.getCurrentSession().save(votacion);
						
					}
					
					if(91 <= voto && voto <= 100) {
						
						Votacion votacion = new Votacion();
						votacion.setEdad(edad);
						votacion.setComunidad(comunidad);
						votacion.setPartidovotado("partido Z");
						sessionFactory.getCurrentSession().save(votacion);
						
					}
					
				}


				if(66 >= edad ) {
					
					if(0 <= voto && voto <= 25) {
						
						Votacion votacion = new Votacion();
						votacion.setEdad(edad);
						votacion.setComunidad(comunidad);
						votacion.setPartidovotado("partido X");
						sessionFactory.getCurrentSession().save(votacion);
							
					}
					
					if(26 <= voto && voto <= 60) {
								
						Votacion votacion = new Votacion();
						votacion.setEdad(edad);
						votacion.setComunidad(comunidad);
						votacion.setPartidovotado("partido Y");
						sessionFactory.getCurrentSession().save(votacion);
					
					}
					
					if(61 <= voto && voto <= 95) {
						
						Votacion votacion = new Votacion();
						votacion.setEdad(edad);
						votacion.setComunidad(comunidad);
						votacion.setPartidovotado("partido W");
						sessionFactory.getCurrentSession().save(votacion);
						
					}
					
					if(96 <= voto && voto <= 100) {
						
						Votacion votacion = new Votacion();
						votacion.setEdad(edad);
						votacion.setComunidad(comunidad);
						votacion.setPartidovotado("partido Z");
						sessionFactory.getCurrentSession().save(votacion);
					
					}
					
					
			}
				
				
		}
			
			
			this.sleep(1000);
		}catch(Exception e) {
	
					e.printStackTrace();
				
			}
	}

}
