package modelo;

import java.math.BigInteger;
import java.util.ArrayList;

import java.util.List;

import javax.swing.JTextArea;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class Modelo {

    public void arrancar  (JTextArea textArea) throws Exception {

        SessionFactory sessionFactory = null;

        try {
           
        	Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
		
			sessionFactory = configuration.buildSessionFactory();
			
			sessionFactory.getCurrentSession().beginTransaction();
			
        	Modelo modelohelper = new Modelo();
        	
           
 
            Query query = sessionFactory.getCurrentSession().createQuery("FROM PorcentajesRangoedad");
            ArrayList<PorcentajesRangoedad> porcentajes = (ArrayList<PorcentajesRangoedad>) query.list();
            
            for(int i=0;i<porcentajes.size();i++) {
            	int edades1825 = porcentajes.get(i).getRango1825();
            	int edades2640 = porcentajes.get(i).getRango2640();
            	int edades4165 = porcentajes.get(i).getRango4165();
            	int edadesmas66 = porcentajes.get(i).getRangoMas66();
            	int totalHabi = porcentajes.get(i).getTotalHabitantes();
            	String nombreComunidad = porcentajes.get(i).getNombreComunidad();
            	
            	modelohelper.calcularPorcentajes(edades1825,edades2640,edades4165,edadesmas66,totalHabi,nombreComunidad,sessionFactory,textArea);
            	
            	
            	
            }
           
            
            
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
        	if(sessionFactory != null) {
        		sessionFactory.close();
        	}
        }
		

        
    }


	public void calcularPorcentajes(int edades1825, int edades2640, int edades4165, int edadesmas66,
			int totalHabi, String nombreComunidad, SessionFactory sessionFactory, JTextArea textArea) throws HibernateException, InterruptedException {
		
		ArrayList<Datoshilos> ldatoshilos = new ArrayList<Datoshilos>();
		
		
		int votantes1825 = (int)Math.round(((edades1825*totalHabi)/100)/100000);
		int votantes2640 = (int)Math.round(((edades2640*totalHabi)/100)/100000);
		int votantes4165 = (int)Math.round(((edades4165*totalHabi)/100)/100000);
		int votantesmas66 = (int)Math.round(((edadesmas66*totalHabi)/100)/100000);
	
		if(votantes1825 == 0) {
			votantes1825 = 1;
		}
		
		if(votantes2640 == 0){
			votantes2640 = 1;
		}
		
		if(votantes4165 == 0){
			votantes4165 = 1;
		}
		
		if(votantesmas66 == 0){
			votantesmas66 = 1;
		}
		
		ldatoshilos.add(new Datoshilos(nombreComunidad,votantes1825,votantes2640,votantes4165,votantesmas66));
		  
			 for(int j=0;j<votantes1825;j++) {
				 
				 int edadjoven = (int)(Math.random()*(25-18))+18;
				 int votojoven = (int)((Math.random()*100));
				
				 Ciudadano	ciudadanojoven = new Ciudadano(edadjoven,votojoven,nombreComunidad,sessionFactory,textArea);
				
				
						 
				 ciudadanojoven.start();
				 ciudadanojoven.join();
			 }
	
			 for(int j=0;j<votantes2640;j++) {
				
				 int edadmediana = (int)(Math.random()*(40-26))+26;
				 int votomediano = (int)((Math.random()*100));
				
				 Ciudadano	ciudadanomedianaedad = new Ciudadano(edadmediana,votomediano,nombreComunidad,sessionFactory,textArea);
				 
				
				 
				 ciudadanomedianaedad.start();
				 ciudadanomedianaedad.join();
			 }
		
			 for(int j=0;j<votantes4165;j++) {
				 
				 int edadalta = (int)(Math.random()*(65-41))+41;
				 int votoalto = (int)((Math.random()*100));
				
				 Ciudadano ciudadanomaduro = new Ciudadano(edadalta,votoalto,nombreComunidad,sessionFactory,textArea);
				 
				
				 
				 ciudadanomaduro.start();
				 ciudadanomaduro.join();
			 }
		
			 for(int j=0;j<votantesmas66;j++) {
				 
				 int edad = (int)(int)(Math.random()*(100-66)+66);
				 int voto = (int)((Math.random()*100));
				
				 Ciudadano ciudadanomayores = new Ciudadano(edad,voto,nombreComunidad,sessionFactory,textArea);
				 
				
				 
				 ciudadanomayores.start();
				 ciudadanomayores.join();
			 }
			
		}

	
	public Integer contarByRangoPartido(SessionFactory sessionFactory, int edad1, int edad2, String partido) {
		
		Integer nmvotos = null;
		BigInteger nvotos = null;
		
		Session session = null;
		
		try {
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			String consultasql = "SELECT COUNT(*) FROM VOTACION "
					+ "WHERE EDAD BETWEEN :edad1 AND :edad2 AND PARTIDO_VOTADO = :partido";
			
			Query consulta = session.createSQLQuery(consultasql);
			consulta.setParameter("edad1", edad1);
			consulta.setParameter("edad2", edad2);
			consulta.setParameter("partido", partido);
			
			nvotos = (BigInteger) consulta.getSingleResult();
			String nvoto = String.valueOf(nvotos);
			nmvotos = Integer.parseInt(nvoto);
			
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
		
		
		
		return nmvotos; 
	}
	
	public Integer contarByComunidadPartido(SessionFactory sessionFactory,String comunidad, String partido) {
		
		Integer nmvotos = null;
		BigInteger nvotos = null;
		
		Session session = null;
		
		try {
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			String consultasql = "SELECT COUNT(*) FROM VOTACION "
					+ "WHERE COMUNIDAD = :comunidad AND PARTIDO_VOTADO = :partido";
			
			Query consulta = session.createSQLQuery(consultasql);
			consulta.setParameter("comunidad", comunidad);
			consulta.setParameter("partido", partido);
			
			nvotos = (BigInteger) consulta.getSingleResult();
			String nvoto = String.valueOf(nvotos);
			nmvotos = Integer.parseInt(nvoto);
			
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
		
		
		
		return nmvotos; 
		
		
	}
	
	
	public Integer contarByTotalPartido(SessionFactory sessionFactory, String partido) {
		
		Integer nmvotos = null;
		BigInteger nvotos = null;
		
		Session session = null;
		
		try {
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			String consultasql = "SELECT COUNT(*) FROM VOTACION "
					+ "WHERE PARTIDO_VOTADO = :partido";
			
			Query consulta = session.createSQLQuery(consultasql);
			consulta.setParameter("partido", partido);
			
			nvotos = (BigInteger) consulta.getSingleResult();
			String nvoto = String.valueOf(nvotos);
			nmvotos = Integer.parseInt(nvoto);
			
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
		
		return nmvotos; 
		
	}
	
	
	public void eliminarDatosTable(SessionFactory sessionFactory) {
		
		Session session = null;
		
		try {
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			String consultasql = "DELETE FROM Votacion";
		
			Query consulta = session.createQuery(consultasql);
			consulta.executeUpdate();
			
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
	
	
	public void resetearIdTable(SessionFactory sessionFactory) {
		
		Session session = null;
		
		try {
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			String consultasql = "ALTER TABLE VOTACION AUTO_INCREMENT=1";
			
			Query consulta = session.createSQLQuery(consultasql);
			consulta.executeUpdate();
		
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
