package exemplo.jsf.richfaces4.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import exemplo.jsf.richfaces4.modelo.Fornecedor;


public class FornecedorDao extends Dao<Fornecedor> {

	public FornecedorDao(Session session) {
		super(session, Fornecedor.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<String> buscaPeloComecoDoNome(String busca) {
		Criteria c = getSession().createCriteria(Fornecedor.class);
		c.add(Restrictions.ilike("nome", busca + "%"));
		c.addOrder(Order.asc("nome"));
		c.setProjection(Projections.property("nome"));
		return c.list();
	}
}
