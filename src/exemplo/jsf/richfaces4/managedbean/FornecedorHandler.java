package exemplo.jsf.richfaces4.managedbean;

import java.util.List;

import javax.faces.component.UIParameter;
import javax.faces.event.ActionEvent;

import org.hibernate.Session;

import exemplo.jsf.richfaces4.dao.Dao;
import exemplo.jsf.richfaces4.modelo.Fornecedor;
import exemplo.jsf.richfaces4.util.HibernateUtil;

public class FornecedorHandler {

	private Fornecedor fornecedor = new Fornecedor();
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Fornecedor> getFornecedores() {
		Session session = HibernateUtil.currentSession();
		Dao<Fornecedor> dao = new Dao<Fornecedor>(session, Fornecedor.class);
		return dao.list();
	}

	public void salva() {
		Session session = HibernateUtil.currentSession();
		Dao<Fornecedor> dao = new Dao<Fornecedor>(session, Fornecedor.class);
		dao.saveOrUpdate(fornecedor);
		fornecedor = new Fornecedor();
	}
	
	public void escolheFornecedor(ActionEvent event) {
		System.out.println("Escolhendo fornecedor para visualizacao");
		UIParameter val = (UIParameter) event.getComponent().findComponent("editId");
		Long id = Long.valueOf(val.getValue().toString());
		
		Session session = HibernateUtil.currentSession();
		Dao<Fornecedor> dao = new Dao<Fornecedor>(session, Fornecedor.class);
		this.fornecedor = dao.load(id);
	}
	
	public void removeFornecedor(ActionEvent event) {
		System.out.println("Escolhendo fornecedor para remover");
		UIParameter val = (UIParameter) event.getComponent().findComponent("removeId");
		Long id = Long.valueOf(val.getValue().toString());
		
		Session session = HibernateUtil.currentSession();
		Dao<Fornecedor> dao = new Dao<Fornecedor>(session, Fornecedor.class);
		this.fornecedor = dao.load(id);
		dao.delete(fornecedor);
		this.fornecedor = new Fornecedor();
	}
}
