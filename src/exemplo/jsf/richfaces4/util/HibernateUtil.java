package exemplo.jsf.richfaces4.util;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {

	private static Logger logger = Logger.getLogger(HibernateUtil.class); 
	private static SessionFactory factory;
	
	static {
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure();
		
		factory = cfg.buildSessionFactory();
	}
	
	public static Session openSession() {
		logger.info("abrindo nova sessão");
		return factory.openSession();
	}
	
}
