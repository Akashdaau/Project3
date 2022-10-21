package in.co.rays.project_3.util;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate DataSource is provides the object of sessionfactory and session
 * 
 *  @author Akash
 *
 */
public class HibDataSource {
	private static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {

		if (sessionFactory == null) {
			sessionFactory = new Configuration().configure().buildSessionFactory();
			
		}
		return sessionFactory;
		
	}

	public static Session getSession() {

		Session session = getSessionFactory().openSession();
		return session;
		//.getCurrentSesion() jab transaction end hoga automatically session flush ho jayega
		//bound to lifecycle of transaction
		

	}

	public static void closeSession(Session session) {
		
		if (session != null) {
			session.close();
		}
	}
}
