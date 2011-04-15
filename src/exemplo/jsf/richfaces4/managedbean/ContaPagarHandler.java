package exemplo.jsf.richfaces4.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.hibernate.Session;

import exemplo.jsf.richfaces4.dao.Dao;
import exemplo.jsf.richfaces4.modelo.ContaPagar;
import exemplo.jsf.richfaces4.modelo.Fornecedor;
import exemplo.jsf.richfaces4.util.HibernateUtil;

public class ContaPagarHandler {

	private ContaPagar contaPagar = new ContaPagar();
	
	private HtmlSelectOneMenu fornecedorSelecionado;
	
	@SuppressWarnings("deprecation")
	private FornecedorHandler pegaFornecedorHandler() {
		FacesContext fc = FacesContext.getCurrentInstance();
		FornecedorHandler handler = (FornecedorHandler) fc.getApplication()
			.getVariableResolver().resolveVariable(fc, "FornecedorHandler");
		return handler;
	}
	
	public List<SelectItem> getFornecedoresParaComboBox() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		FornecedorHandler handler = pegaFornecedorHandler();
		for (Fornecedor f : handler.getFornecedores()) {
			lista.add(new SelectItem(f.getId().toString(),f.getNome()));
		}
		return lista;
	}

	public void salva(ActionEvent event) {
		Session session = HibernateUtil.currentSession();
		Dao<Fornecedor> fornecedorDao = new Dao<Fornecedor>(session, Fornecedor.class);
		Long id = Long.parseLong(fornecedorSelecionado.getValue().toString());
		Fornecedor f = fornecedorDao.load(id);
		contaPagar.setFornecedor(f);
		Dao<ContaPagar> contaPagarDao = new Dao<ContaPagar>(session, ContaPagar.class);
		contaPagarDao.saveOrUpdate(contaPagar);	
		contaPagar = new ContaPagar();
	}
	
	public ContaPagar getContaPagar() {
		return contaPagar;
	}

	public void setContaPagar(ContaPagar contaPagar) {
		this.contaPagar = contaPagar;
	}

	public List<ContaPagar> getContas() {
		Session session = HibernateUtil.currentSession();
		Dao<ContaPagar> dao = new Dao<ContaPagar>(session, ContaPagar.class);
		return dao.list();
	}

	public HtmlSelectOneMenu getFornecedorSelecionado() {
		return fornecedorSelecionado;
	}

	public void setFornecedorSelecionado(HtmlSelectOneMenu fornecedorSelecionado) {
		this.fornecedorSelecionado = fornecedorSelecionado;
	}
	
}
