package exemplo.jsf.richfaces4.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import exemplo.jsf.richfaces4.modelo.ContaPagar;


public class ContaPagarDao extends Dao<ContaPagar> {

	public ContaPagarDao(Session session) {
		super(session, ContaPagar.class);
	}

	public double avgValor() {
		Criteria c = getSession().createCriteria(ContaPagar.class);
		c.setProjection(Projections.avg("valor"));
		return (Double) (c.uniqueResult());
	}
	
	public double sumValor() {
		Criteria c = getSession().createCriteria(ContaPagar.class);
		c.setProjection(Projections.sum("valor"));
		return (Double) (c.uniqueResult());
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> listaFornecedorValor(int qtd) {
		Criteria c = getSession().createCriteria(ContaPagar.class);
		ProjectionList pl = Projections.projectionList();
		pl.add(Projections.groupProperty("fornecedor"));
		pl.add(Projections.groupProperty("pago"));
		pl.add(Projections.sum("valor"), "soma");
		c.setProjection(pl);
		c.addOrder(Order.asc("soma"));
		c.setMaxResults(qtd);
		return c.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<ContaPagar> listaContasDoFornecedor(String nome) {
		Query q = getSession().createQuery("select cp from ContaPagar cp where " +
				"cp.fornecedor.nome like :nome order by cp.fornecedor.nome");
		q.setParameter("nome", nome);
		return q.list();
	}
}
