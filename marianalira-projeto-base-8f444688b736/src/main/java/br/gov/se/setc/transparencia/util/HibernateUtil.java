package br.gov.se.setc.transparencia.util;

//import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	//private static final ThreadLocal threadlocal = new ThreadLocal();
	
	static {
		try {
			sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}catch (Throwable e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static SessionFactory getInstance() {
//		Session session = (Session) threadlocal.get();
//		session = sessionFactory.openSession();
//		threadlocal.set(session);
//		return session;
		//System.out.println("getInstance()");
		return sessionFactory;
	}
	
}
