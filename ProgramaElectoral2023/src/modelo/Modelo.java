package modelo;

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
		
		 for(int i=0;i<ldatoshilos.size();i++) {
			 for(int j=0;j<ldatoshilos.get(i).getRango1825();j++) {
				 
				 int edadjoven = (int)(18+(Math.random()*25));
				 int votojoven = (int)(0+(Math.random()*100));
				
				 Ciudadano	ciudadanojoven = new Ciudadano(edadjoven,votojoven,ldatoshilos.get(i).getNombreComunidad(),sessionFactory);
				 ciudadanojoven.start();
				 ciudadanojoven.join();
			 }
		 }
		 
		 for(int i=0;i<ldatoshilos.size();i++) {
			 for(int j=0;j<ldatoshilos.get(i).getRango2640();j++) {
				 int edadmediana = (int)(26+(Math.random()*40));
				 int votomediano = (int)(0+(Math.random()*100));
				 
				  Ciudadano	ciudadanomedianaedad = new Ciudadano(edadmediana,votomediano,ldatoshilos.get(i).getNombreComunidad(),sessionFactory);
				 ciudadanomedianaedad.start();
				 ciudadanomedianaedad.join();
			 }
		 }
		 
		 for(int i=0;i<ldatoshilos.size();i++) {
			 for(int j=0;j<ldatoshilos.get(i).getRango4165();j++) {
				 int edadalta = (int)(41+(Math.random()*65));
				 int votoalto = (int)(0+(Math.random()*100));
				;
			
				 Ciudadano ciudadanomaduro = new Ciudadano(edadalta,votoalto,ldatoshilos.get(i).getNombreComunidad(),sessionFactory);
				 ciudadanomaduro.start();
				 ciudadanomaduro.join();
			 }
		 }
		 
		 for(int i=0;i<ldatoshilos.size();i++) {
			 for(int j=0;j<ldatoshilos.get(i).getRango66();j++) {
				 int edad = (int)(65+(Math.random()*100));
				 int voto = (int)(0+(Math.random()*100));
				
				 Ciudadano ciudadanomayores = new Ciudadano(edad,voto,ldatoshilos.get(i).getNombreComunidad(),sessionFactory);
				 ciudadanomayores.start();
				 ciudadanomayores.join();
			 }
		 }
		 
		
		 
		 
		 
		 
		
	}

}
