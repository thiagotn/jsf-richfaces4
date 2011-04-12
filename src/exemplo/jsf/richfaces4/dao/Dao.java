package exemplo.jsf.richfaces4.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;

public class Dao<T> {

	private static Logger logger = Logger.getLogger(Dao.class);
	@SuppressWarnings("unchecked")
	private Class persistentClass;
	private Session session;
	
	@SuppressWarnings("unchecked")
	public Dao(Session session, Class persistentClass){
		this.session = session;
		this.persistentClass = persistentClass;
	}
	
	@SuppressWarnings("unchecked")
	public T load(Long id) {
		logger.info("buscando " + persistentClass + " com o id " + id);
		return (T) session.load(persistentClass, id);
	}
	
	public void save(T t){
		logger.info("salvando " + t);
		session.save(t);
	}
	
	public void delete(T t){
		logger.info("deletando " + persistentClass);
		session.delete(t);
	}
	
	protected Session getSession(){
		return this.session;
	}
}
