package exemplo.jsf.richfaces4.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

public class Dao<T> {

	private static Logger logger = Logger.getLogger(Dao.class);
	
	@SuppressWarnings("rawtypes")
	private Class persistentClass;
	private Session session;
	
	@SuppressWarnings("rawtypes")
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

	@SuppressWarnings("unchecked")
	public List<T> list(){
		return session.createCriteria(persistentClass).list();
	}

	public void saveOrUpdate(T t){
		logger.info("salvando " + t);
		session.saveOrUpdate(t);
	}
	
	protected Session getSession(){
		return this.session;
	}
}
