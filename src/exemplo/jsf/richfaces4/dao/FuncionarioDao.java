package exemplo.jsf.richfaces4.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import exemplo.jsf.richfaces4.modelo.Funcionario;


public class FuncionarioDao extends Dao<Funcionario> {

	public FuncionarioDao(Session session) {
		super(session, Funcionario.class);
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> buscaFuncionario(String nome) {
		Criteria c = getSession().createCriteria(Funcionario.class);
		c.add(Restrictions.like("nome", nome));
		c.addOrder(Order.asc("email"));
		return c.list();
	}

	@SuppressWarnings("unchecked")
	public List<Funcionario> buscaFuncionarioPorNomeEEmail(String nome, String email) {
		Criteria c = getSession().createCriteria(Funcionario.class);
		c.add(Restrictions.ilike("nome", nome));
		c.add(Restrictions.ilike("email", email));
		return c.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> buscaFuncionarioOr(String nome, String email) {
		Criteria c = getSession().createCriteria(Funcionario.class);
		Criterion c1 = Restrictions.ilike("nome", nome);
		Criterion c2 = Restrictions.ilike("email", email);
		Criterion c3 = Restrictions.or(c1, c2);
		c.add(c3);
		return c.list();
	}
	
	public long countTotalFuncionarios() {
		Criteria c = getSession().createCriteria(Funcionario.class);
		c.setProjection(Projections.rowCount());
		return (Long) (c.uniqueResult());
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> buscaFuncionarioHQL(String nome) {
		Query q = getSession().createQuery("select f from Funcionario f where f.nome like :nome");
		q.setParameter("nome", nome);
		return q.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> buscafuncionarioSQL(){
		SQLQuery q = getSession().createSQLQuery("select * from Funcionario");
		q.addEntity(Funcionario.class);
		return q.list();
	}
}
