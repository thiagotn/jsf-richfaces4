package exemplo.jsf.richfaces4.dao;

import org.hibernate.Session;

import exemplo.jsf.richfaces4.modelo.Fornecedor;


public class FornecedorDao extends Dao<Fornecedor> {

	public FornecedorDao(Session session) {
		super(session, Fornecedor.class);
	}
}
