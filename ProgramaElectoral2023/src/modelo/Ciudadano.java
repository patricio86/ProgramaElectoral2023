package modelo;

import javax.swing.JOptionPane;
import vista.EstadisticaElectoral;
import javax.swing.JTextArea;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class Ciudadano extends Thread{

	private int edad;
	private int voto;
	private String comunidad;
	private SessionFactory sessionFactory;
	private ColegioElectoral colegioElectoral = null;
	private JTextArea textArea;
	
	public Ciudadano(int edad, int voto, String comunidad, SessionFactory sessionFactory, JTextArea textArea) {
		this.edad = edad;
		this.voto = voto;
		this.comunidad = comunidad;
		this.sessionFactory = sessionFactory;
		this.textArea = textArea;
	}

	public void run() {
		
		colegioElectoral = ColegioElectoral.getInstance();
		Session session = null;
		
		try {
			
			Boolean comprobarpartido = colegioElectoral.votar(voto,edad);
				
			if(comprobarpartido == true) {
				
				if(18 <= edad && edad <= 25 ) {
					
					if(0 <= voto && voto <= 30) {
						
					try {
						
						session = sessionFactory.getCurrentSession();
						session.beginTransaction();
						Votacion votacion1 = new Votacion();
						votacion1.setEdad(edad);
						votacion1.setComunidad(comunidad);
						votacion1.setPartidoVotado("PSOE");
						session.save(votacion1);
						session.getTransaction().commit();
						textArea.append("El ciudadano cuya edad es " + edad + " ha ejercido el derecho al voto en " + comunidad + " a la hora\n");
					
					}catch(HibernateException e) { 
						e.printStackTrace();
						if(null != session) {
							session.getTransaction().rollback();
						}
					}finally {
						if(null != session) {
							session.close();
						}
					}
						
						
					} else if(31 <= voto && voto <= 50) {
						
						try {
							session = sessionFactory.getCurrentSession();
							session.beginTransaction();
						Votacion votacion2 = new Votacion();
						votacion2.setEdad(edad);
						votacion2.setComunidad(comunidad);
						votacion2.setPartidoVotado("PP");
						session.save(votacion2);
						session.getTransaction().commit();
						textArea.append("El ciudadano cuya edad es " + edad + " ha ejercido el derecho al voto en " + comunidad + " a la hora\n");
						
						}catch(HibernateException e) { 
							e.printStackTrace();
							if(null != session) {
								session.getTransaction().rollback();
							}
						}finally {
							if(null != session) {
								session.close();
							}
						}
					} else if(51 <= voto && voto <= 70) {
						
						try {
							session = sessionFactory.getCurrentSession();
							session.beginTransaction();
						Votacion votacion3 = new Votacion();
						votacion3.setEdad(edad);
						votacion3.setComunidad(comunidad);
						votacion3.setPartidoVotado("UP");
						session.save(votacion3);
						session.getTransaction().commit();
						textArea.append("El ciudadano cuya edad es " + edad + " ha ejercido el derecho al voto en " + comunidad + " a la hora\n");
						
						}catch(HibernateException e) { 
							e.printStackTrace();
							if(null != session) {
								session.getTransaction().rollback();
							}
						}finally {
							if(null != session) {
								session.close();
							}
						}
					} else if(71 <= voto && voto <= 100) {
						
						try {
							session = sessionFactory.getCurrentSession();
							session.beginTransaction();
						Votacion votacion4 = new Votacion();
						votacion4.setEdad(edad);
						votacion4.setComunidad(comunidad);
						votacion4.setPartidoVotado("VOX");
						session.save(votacion4);
						session.getTransaction().commit();
						textArea.append("El ciudadano cuya edad es " + edad + " ha ejercido el derecho al voto en " + comunidad + " a la hora\n");
						
						}catch(HibernateException e) { 
							e.printStackTrace();
							if(null != session) {
								session.getTransaction().rollback();
							}
						}finally {
							if(null != session) {
								session.close();
							}
						}
					}
					
				} else if(26 <= edad && edad <= 40) {
					
					if(0 <= voto && voto <= 20) {
						
						try {
							session = sessionFactory.getCurrentSession();
							session.beginTransaction();
						Votacion votacion5 = new Votacion();
						votacion5.setEdad(edad);
						votacion5.setComunidad(comunidad);
						votacion5.setPartidoVotado("PSOE");
						session.save(votacion5);
						session.getTransaction().commit();
						textArea.append("El ciudadano cuya edad es " + edad + " ha ejercido el derecho al voto en " + comunidad + " a la hora\n");
						
						}catch(HibernateException e) { 
							e.printStackTrace();
							if(null != session) {
								session.getTransaction().rollback();
							}
						}finally {
							if(null != session) {
								session.close();
							}
						}
					} else if(21 <= voto && voto <= 55) {
								
						try {
							session = sessionFactory.getCurrentSession();
							session.beginTransaction();
						Votacion votacion6 = new Votacion();
						votacion6.setEdad(edad);
						votacion6.setComunidad(comunidad);
						votacion6.setPartidoVotado("PP");
						session.save(votacion6);
						session.getTransaction().commit();
						textArea.append("El ciudadano cuya edad es " + edad + " ha ejercido el derecho al voto en " + comunidad + " a la hora\n");
						
						}catch(HibernateException e) { 
							e.printStackTrace();
							if(null != session) {
								session.getTransaction().rollback();
							}
						}finally {
							if(null != session) {
								session.close();
							}
						}
					} else if(56 <= voto && voto <= 85) {
						
						try {
							session = sessionFactory.getCurrentSession();
							session.beginTransaction();
						Votacion votacion7 = new Votacion();
						votacion7.setEdad(edad);
						votacion7.setComunidad(comunidad);
						votacion7.setPartidoVotado("UP");
						session.save(votacion7);
						session.getTransaction().commit();
						textArea.append("El ciudadano cuya edad es " + edad + " ha ejercido el derecho al voto en " + comunidad + " a la hora\n");
						
						}catch(HibernateException e) { 
							e.printStackTrace();
							if(null != session) {
								session.getTransaction().rollback();
							}
						}finally {
							if(null != session) {
								session.close();
							}
						}
					} else if(86 <= voto && voto <= 100) {
						
						try {
							session = sessionFactory.getCurrentSession();
							session.beginTransaction();
						Votacion votacion8 = new Votacion();
						votacion8.setEdad(edad);
						votacion8.setComunidad(comunidad);
						votacion8.setPartidoVotado("VOX");
						session.save(votacion8);
						session.getTransaction().commit();
						textArea.append("El ciudadano cuya edad es " + edad + " ha ejercido el derecho al voto en " + comunidad + " a la hora\n");
						
						}catch(HibernateException e) { 
							e.printStackTrace();
							if(null != session) {
								session.getTransaction().rollback();
							}
						}finally {
							if(null != session) {
								session.close();
							}
						}
					}
				} else if(41 <= edad && edad <= 65 ) {
					
					if(0 <= voto && voto <= 10) {
						
						try {
							session = sessionFactory.getCurrentSession();
							session.beginTransaction();
						Votacion votacion9 = new Votacion();
						votacion9.setEdad(edad);
						votacion9.setComunidad(comunidad);
						votacion9.setPartidoVotado("PSOE");
						session.save(votacion9);
						session.getTransaction().commit();
						textArea.append("El ciudadano cuya edad es " + edad + " ha ejercido el derecho al voto en " + comunidad + " a la hora\n");
						
						}catch(HibernateException e) { 
							e.printStackTrace();
							if(null != session) {
								session.getTransaction().rollback();
							}
						}finally {
							if(null != session) {
								session.close();
							}
						} 
					} else if(11 <= voto && voto <= 55) {
								
						try {
							session = sessionFactory.getCurrentSession();
							session.beginTransaction();
						Votacion votacion10 = new Votacion();
						votacion10.setEdad(edad);
						votacion10.setComunidad(comunidad);
						votacion10.setPartidoVotado("PP");
						session.save(votacion10);
						session.getTransaction().commit();
						textArea.append("El ciudadano cuya edad es " + edad + " ha ejercido el derecho al voto en " + comunidad + " a la hora\n");
						
						}catch(HibernateException e) { 
							e.printStackTrace();
							if(null != session) {
								session.getTransaction().rollback();
							}
						}finally {
							if(null != session) {
								session.close();
							}
						} 
						
					} else if(56 <= voto && voto <= 90) {
						
						try {
							session = sessionFactory.getCurrentSession();
							session.beginTransaction();
						Votacion votacion11 = new Votacion();
						votacion11.setEdad(edad);
						votacion11.setComunidad(comunidad);
						votacion11.setPartidoVotado("UP");
						session.save(votacion11);
						session.getTransaction().commit();
						textArea.append("El ciudadano cuya edad es " + edad + " ha ejercido el derecho al voto en " + comunidad + " a la hora\n");
						
						}catch(HibernateException e) { 
							e.printStackTrace();
							if(null != session) {
								session.getTransaction().rollback();
							}
						}finally {
							if(null != session) {
								session.close();
							}
						}
					} else if(91 <= voto && voto <= 100) {
						
						try {
							session = sessionFactory.getCurrentSession();
							session.beginTransaction();
						Votacion votacion12 = new Votacion();
						votacion12.setEdad(edad);
						votacion12.setComunidad(comunidad);
						votacion12.setPartidoVotado("VOX");
						session.save(votacion12);
						session.getTransaction().commit();
						textArea.append("El ciudadano cuya edad es " + edad + " ha ejercido el derecho al voto en " + comunidad + " a la hora\n");
						
						}catch(HibernateException e) { 
							e.printStackTrace();
							if(null != session) {
								session.getTransaction().rollback();
							}
						}finally {
							if(null != session) {
								session.close();
							}
						}
					}
					
				} else if(66 <= edad ) {
					
					if(0 <= voto && voto <= 25) {
						
						try {
							session = sessionFactory.getCurrentSession();
							session.beginTransaction();
						Votacion votacion13 = new Votacion();
						votacion13.setEdad(edad);
						votacion13.setComunidad(comunidad);
						votacion13.setPartidoVotado("PSOE");
						session.save(votacion13);
						session.getTransaction().commit();
						textArea.append("El ciudadano cuya edad es " + edad + " ha ejercido el derecho al voto en " + comunidad + " a la hora\n");
						
						}catch(HibernateException e) { 
							e.printStackTrace();
							if(null != session) {
								session.getTransaction().rollback();
							}
						}finally {
							if(null != session) {
								session.close();
							}
						}
					} else if(26 <= voto && voto <= 60) {
								
						try {
							session = sessionFactory.getCurrentSession();
							session.beginTransaction();
						Votacion votacion14 = new Votacion();
						votacion14.setEdad(edad);
						votacion14.setComunidad(comunidad);
						votacion14.setPartidoVotado("PP");
						session.save(votacion14);
						session.getTransaction().commit();
						textArea.append("El ciudadano cuya edad es " + edad + " ha ejercido el derecho al voto en " + comunidad + " a la hora\n");
						
						}catch(HibernateException e) { 
							e.printStackTrace();
							if(null != session) {
								session.getTransaction().rollback();
							}
						}finally {
							if(null != session) {
								session.close();
							}
						}
						
					} else if(61 <= voto && voto <= 95) {
						
						try {
							session = sessionFactory.getCurrentSession();
							session.beginTransaction();
						Votacion votacion15 = new Votacion();
						votacion15.setEdad(edad);
						votacion15.setComunidad(comunidad);
						votacion15.setPartidoVotado("UP");
						session.save(votacion15);
						session.getTransaction().commit();
						textArea.append("El ciudadano cuya edad es " + edad + " ha ejercido el derecho al voto en " + comunidad + " a la hora\n");
						
						}catch(HibernateException e) { 
							e.printStackTrace();
							if(null != session) {
								session.getTransaction().rollback();
							}
						}finally {
							if(null != session) {
								session.close();
							}
						}
					} else if(96 <= voto && voto <= 100) {
						
						try {
							session = sessionFactory.getCurrentSession();
							session.beginTransaction();
						Votacion votacion16 = new Votacion();
						votacion16.setEdad(edad);
						votacion16.setComunidad(comunidad);
						votacion16.setPartidoVotado("VOX");
						session.save(votacion16);
						session.getTransaction().commit();
						textArea.append("El ciudadano cuya edad es " + edad + " ha ejercido el derecho al voto en " + comunidad + " a la hora\n");
						
						}catch(HibernateException e) { 
							e.printStackTrace();
							if(null != session) {
								session.getTransaction().rollback();
							}
						}finally {
							if(null != session) {
								session.close();
							}
						}
						
					}		
		}
		}
		
				this.sleep(20);
		}catch(HibernateException | InterruptedException e) { 
			e.printStackTrace();
		}
	}

}
