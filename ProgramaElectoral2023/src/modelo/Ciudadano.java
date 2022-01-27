package modelo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class Ciudadano extends Thread{

	private int edad;
	private int voto;
	private String comunidad;
	private SessionFactory sessionFactory;
	private ColegioElectoral colegioElectoral = null;
	
	
	public Ciudadano(int edad, int voto, String comunidad, SessionFactory sessionFactory) {
		this.edad = edad;
		this.voto = voto;
		this.comunidad = comunidad;
		this.sessionFactory = sessionFactory;
	}

	public void run() {
		
		colegioElectoral = ColegioElectoral.getInstance();
		
		Session session = null;
		
		try {
			
			Boolean comprobarpartido = colegioElectoral.votar(voto,edad);
				
			if(comprobarpartido) {
				
				if(18 >= edad && edad <= 25 ) {
					
					if(0 >= voto && voto <= 30) {
						
					try {
						session = sessionFactory.getCurrentSession();
						session.beginTransaction();
						Votacion votacion1 = new Votacion();
						votacion1.setEdad(edad);
						votacion1.setComunidad(comunidad);
						votacion1.setPartidoVotado("partido X");
						session.saveOrUpdate(votacion1);
						session.getTransaction().commit();
						System.out.println("votado X");
						
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
					
					if(31 >= voto && voto <= 50) {
						
						try {
							session = sessionFactory.getCurrentSession();
							session.beginTransaction();
						Votacion votacion2 = new Votacion();
						votacion2.setEdad(edad);
						votacion2.setComunidad(comunidad);
						votacion2.setPartidoVotado("partido Y");
						session.saveOrUpdate(votacion2);
						session.getTransaction().commit();
						System.out.println("votado Y");
						
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
					
					if(51 >= voto && voto <= 70) {
						
						try {
							session = sessionFactory.getCurrentSession();
							session.beginTransaction();
						Votacion votacion3 = new Votacion();
						votacion3.setEdad(edad);
						votacion3.setComunidad(comunidad);
						votacion3.setPartidoVotado("partido W");
						session.saveOrUpdate(votacion3);
						session.getTransaction().commit();
						System.out.println("votado W");
						
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
					
					if(71 >= voto && voto <= 100) {
						
						try {
							session = sessionFactory.getCurrentSession();
							session.beginTransaction();
						Votacion votacion4 = new Votacion();
						votacion4.setEdad(edad);
						votacion4.setComunidad(comunidad);
						votacion4.setPartidoVotado("partido Z");
						session.saveOrUpdate(votacion4);
						session.getTransaction().commit();
						System.out.println("votado Z");
						
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
				
				if(26 >= edad && edad <= 40) {
					
					if(0 >= voto && voto <= 20) {
						
						try {
							session = sessionFactory.getCurrentSession();
							session.beginTransaction();
						Votacion votacion5 = new Votacion();
						votacion5.setEdad(edad);
						votacion5.setComunidad(comunidad);
						votacion5.setPartidoVotado("partido X");
						session.saveOrUpdate(votacion5);
						session.getTransaction().commit();
						System.out.println("votado X");
						
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
					
					if(21 >= voto && voto <= 55) {
								
						try {
							session = sessionFactory.getCurrentSession();
							session.beginTransaction();
						Votacion votacion6 = new Votacion();
						votacion6.setEdad(edad);
						votacion6.setComunidad(comunidad);
						votacion6.setPartidoVotado("partido Y");
						session.saveOrUpdate(votacion6);
						session.getTransaction().commit();
						System.out.println("votado Y");
						
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
					
					if(56 >= voto && voto <= 85) {
						
						try {
							session = sessionFactory.getCurrentSession();
							session.beginTransaction();
						Votacion votacion7 = new Votacion();
						votacion7.setEdad(edad);
						votacion7.setComunidad(comunidad);
						votacion7.setPartidoVotado("partido W");
						session.saveOrUpdate(votacion7);
						session.getTransaction().commit();
						System.out.println("votado W");
						
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
					
					if(86 >= voto && voto <= 100) {
						
						try {
							session = sessionFactory.getCurrentSession();
							session.beginTransaction();
						Votacion votacion8 = new Votacion();
						votacion8.setEdad(edad);
						votacion8.setComunidad(comunidad);
						votacion8.setPartidoVotado("partido Z");
						session.saveOrUpdate(votacion8);
						session.getTransaction().commit();
						System.out.println("votado Z");
						
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

				if(41 >= edad && edad <= 65 ) {
					
					if(0 >= voto && voto <= 10) {
						
						try {
							session = sessionFactory.getCurrentSession();
							session.beginTransaction();
						Votacion votacion9 = new Votacion();
						votacion9.setEdad(edad);
						votacion9.setComunidad(comunidad);
						votacion9.setPartidoVotado("partido X");
						session.saveOrUpdate(votacion9);
						session.getTransaction().commit();
						System.out.println("votado X");
						
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
					
					if(10 >= voto && voto <= 55) {
								
						try {
							session = sessionFactory.getCurrentSession();
							session.beginTransaction();
						Votacion votacion10 = new Votacion();
						votacion10.setEdad(edad);
						votacion10.setComunidad(comunidad);
						votacion10.setPartidoVotado("partido Y");
						session.saveOrUpdate(votacion10);
						session.getTransaction().commit();
						System.out.println("votado Y");
						
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
					
					if(56 >= voto && voto <= 90) {
						
						try {
							session = sessionFactory.getCurrentSession();
							session.beginTransaction();
						Votacion votacion11 = new Votacion();
						votacion11.setEdad(edad);
						votacion11.setComunidad(comunidad);
						votacion11.setPartidoVotado("partido W");
						session.saveOrUpdate(votacion11);
						session.getTransaction().commit();
						System.out.println("votado W");
						
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
					
					if(91 >= voto && voto <= 100) {
						
						try {
							session = sessionFactory.getCurrentSession();
							session.beginTransaction();
						Votacion votacion12 = new Votacion();
						votacion12.setEdad(edad);
						votacion12.setComunidad(comunidad);
						votacion12.setPartidoVotado("partido Z");
						session.saveOrUpdate(votacion12);
						session.getTransaction().commit();
						System.out.println("votado Z");
						
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


				if(66 >= edad ) {
					
					if(0 >= voto && voto <= 25) {
						
						try {
							session = sessionFactory.getCurrentSession();
							session.beginTransaction();
						Votacion votacion13 = new Votacion();
						votacion13.setEdad(edad);
						votacion13.setComunidad(comunidad);
						votacion13.setPartidoVotado("partido X");
						session.saveOrUpdate(votacion13);
						session.getTransaction().commit();
						System.out.println("votado X");
						
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
					
					if(26 >= voto && voto <= 60) {
								
						try {
							session = sessionFactory.getCurrentSession();
							session.beginTransaction();
						Votacion votacion14 = new Votacion();
						votacion14.setEdad(edad);
						votacion14.setComunidad(comunidad);
						votacion14.setPartidoVotado("partido Y");
						session.saveOrUpdate(votacion14);
						session.getTransaction().commit();
						System.out.println("votado Y");
						
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
					
					if(61 >= voto && voto <= 95) {
						
						try {
							session = sessionFactory.getCurrentSession();
							session.beginTransaction();
						Votacion votacion15 = new Votacion();
						votacion15.setEdad(edad);
						votacion15.setComunidad(comunidad);
						votacion15.setPartidoVotado("partido W");
						session.saveOrUpdate(votacion15);
						session.getTransaction().commit();
						System.out.println("votado W");
						
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
					
					if(96 >= voto && voto <= 100) {
						
						try {
							session = sessionFactory.getCurrentSession();
							session.beginTransaction();
						Votacion votacion16 = new Votacion();
						votacion16.setEdad(edad);
						votacion16.setComunidad(comunidad);
						votacion16.setPartidoVotado("partido Z");
						session.saveOrUpdate(votacion16);
						session.getTransaction().commit();
						System.out.println("votado Z");
						
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
		
				this.sleep(500);
		}catch(HibernateException | InterruptedException e) { 
			e.printStackTrace();
		}
	}

}
