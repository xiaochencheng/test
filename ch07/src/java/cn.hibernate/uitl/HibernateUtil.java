package cn.hibernate.uitl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static Configuration conf;
	private final static SessionFactory sessionFactory;

	static {
		try {
			conf = new Configuration().configure();
			sessionFactory = conf.buildSessionFactory();
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}
	}

	public HibernateUtil() {
	}

	public static Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

}
