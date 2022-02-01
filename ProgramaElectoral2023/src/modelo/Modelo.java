package modelo;

import java.math.BigInteger;
import java.util.ArrayList;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class Modelo {

    public static void main (String [] args) throws Exception {

        SessionFactory sessionFactory = null;

        try {
           
        	Modelo modelohelper = new Modelo();
        	
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
   
            sessionFactory = configuration.buildSessionFactory();
            
            sessionFactory.getCurrentSession().beginTransaction();
 
            Query query = sessionFactory.getCurrentSession().createQuery("FROM PorcentajesRangoedad");
            ArrayList<PorcentajesRangoedad> porcentajes = (ArrayList<PorcentajesRangoedad>) query.list();
            
            for(int i=0;i<porcentajes.size();i++) {
            	int edades1825 = porcentajes.get(i).getRango1825();
            	int edades2640 = porcentajes.get(i).getRango2640();
            	int edades4165 = porcentajes.get(i).getRango4165();
            	int edadesmas66 = porcentajes.get(i).getRangoMas66();
            	int totalHabi = porcentajes.get(i).getTotalHabitantes();
            	String nombreComunidad = porcentajes.get(i).getNombreComunidad();
            	
            	modelohelper.calcularPorcentajes(edades1825,edades2640,edades4165,edadesmas66,totalHabi,nombreComunidad,sessionFactory);
            	
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	if(sessionFactory != null) {
        		sessionFactory.close();
        	}
        }


    }

	public void calcularPorcentajes(int edades1825, int edades2640, int edades4165, int edadesmas66,
			int totalHabi, String nombreComunidad, SessionFactory sessionFactory) throws HibernateException, InterruptedException {
		
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
				
				 Ciudadano	ciudadanojoven = new Ciudadano(edadjoven,votojoven,nombreComunidad,sessionFactory);
				
				 ciudadanojoven.start();
				 ciudadanojoven.join();
			 }
	
			 for(int j=0;j<votantes2640;j++) {
				
				 int edadmediana = (int)(Math.random()*(40-26))+26;
				 int votomediano = (int)((Math.random()*100));
				
				 Ciudadano	ciudadanomedianaedad = new Ciudadano(edadmediana,votomediano,nombreComunidad,sessionFactory);
				 ciudadanomedianaedad.start();
				 ciudadanomedianaedad.join();
			 }
		
			 for(int j=0;j<votantes4165;j++) {
				 
				 int edadalta = (int)(Math.random()*(65-41))+41;
				 int votoalto = (int)((Math.random()*100));
				
				 Ciudadano ciudadanomaduro = new Ciudadano(edadalta,votoalto,nombreComunidad,sessionFactory);
				 ciudadanomaduro.start();
				 ciudadanomaduro.join();
			 }
		
			 for(int j=0;j<votantesmas66;j++) {
				 
				 int edad = (int)(int)(Math.random()*(100-66)+66);
				 int voto = (int)((Math.random()*100));
				
				 Ciudadano ciudadanomayores = new Ciudadano(edad,voto,nombreComunidad,sessionFactory);
				 ciudadanomayores.start();
				 ciudadanomayores.join();
			 }
		}

	
	public BigInteger contarByRangoPartido(SessionFactory sessionFactory, int edad1, int edad2, String partido) {
		
		BigInteger nvotos = null;
		
		Session session = null;
		
		try {
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			String consultasql = "SELECT COUNT(*) FROM VOTACION "
					+ "WHERE EDAD BETWEEN :edad1 AND :edad2 AND PARTIDO_VOTADO = :partido";
			
			Query consulta = session.createSQLQuery(consultasql);
			consulta.setParameter("edad", edad1);
			consulta.setParameter("edad", edad2);
			consulta.setParameter("partido_votado", partido);
			
			nvotos = (BigInteger) consulta.getSingleResult();
			
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
		
		
		
		return nvotos; 
	}
	
	public BigInteger contarByComunidadPartido(SessionFactory sessionFactory,String comunidad, String partido) {
		
		BigInteger nvotos = null;
		
		Session session = null;
		
		try {
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			String consultasql = "SELECT COUNT(*) FROM VOTACION "
					+ "WHERE COMUNIDAD = :comunidad AND :edad2 AND PARTIDO_VOTADO = :partido";
			
			Query consulta = session.createSQLQuery(consultasql);
			consulta.setParameter("comunidad", comunidad);
			consulta.setParameter("partido_votado", partido);
			
			nvotos = (BigInteger) consulta.getSingleResult();
			
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
		
		
		
		return nvotos; 
		
		
	}
	
	
	public BigInteger contarByTotalPartido(SessionFactory sessionFactory, String partido) {
		
		BigInteger nvotos = null;
		
		Session session = null;
		
		try {
			
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			
			String consultasql = "SELECT COUNT(*) FROM VOTACION "
					+ "WHERE PARTIDO_VOTADO = :partido";
			
			Query consulta = session.createSQLQuery(consultasql);
			consulta.setParameter("partido_votado", partido);
			
			nvotos = (BigInteger) consulta.getSingleResult();
			
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
		
		return nvotos; 
		
		
		
		
		
		
		
	}
}
