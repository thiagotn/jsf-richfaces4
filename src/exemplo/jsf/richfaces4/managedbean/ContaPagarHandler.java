package exemplo.jsf.richfaces4.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import exemplo.jsf.richfaces4.modelo.ContaPagar;
import exemplo.jsf.richfaces4.modelo.Fornecedor;

public class ContaPagarHandler {

	private ContaPagar contaPagar = new ContaPagar();
	
	private List<ContaPagar> contas = new ArrayList<ContaPagar>();
	
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
		System.out.println("gravando conta: " + contaPagar.getDescricao());
		System.out.println("pago: " + contaPagar.isPago());
		int id = Integer.parseInt(fornecedorSelecionado.getValue().toString());
		Fornecedor f = pegaFornecedorHandler().getFornecedores().get(id -1);
		contaPagar.setFornecedor(f);
		System.out.println("fornecedor: " + contaPagar.getFornecedor().getNome());
		this.contas.add(contaPagar);
		contaPagar = new ContaPagar();
	}
	
	public ContaPagar getContaPagar() {
		return contaPagar;
	}

	public void setContaPagar(ContaPagar contaPagar) {
		this.contaPagar = contaPagar;
	}

	public List<ContaPagar> getContas() {
		return contas;
	}

	public void setContas(List<ContaPagar> contas) {
		this.contas = contas;
	}

	public HtmlSelectOneMenu getFornecedorSelecionado() {
		return fornecedorSelecionado;
	}

	public void setFornecedorSelecionado(HtmlSelectOneMenu fornecedorSelecionado) {
		this.fornecedorSelecionado = fornecedorSelecionado;
	}
	
}
