package exemplo.jsf.richfaces4.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIParameter;
import javax.faces.event.ActionEvent;

import exemplo.jsf.richfaces4.modelo.Fornecedor;

public class FornecedorHandler {

	private Fornecedor fornecedor = new Fornecedor();

	private List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
	
	private long count = 0;
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Fornecedor> getFornecedores() {
		System.out.println("Lendo fornecedores #" + fornecedores.size());
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}
	
	public void salva() {
		System.out.println("Adicionando: " + fornecedor.getNome());
		if (fornecedor.getId() == null) {
			this.fornecedor.setId(++count);
			this.fornecedores.add(fornecedor);
		}
		this.fornecedor = new Fornecedor();
	}
	
	public void escolheFornecedor(ActionEvent event) {
		System.out.println("Escolhendo fornecedor para visualizacao");
		UIParameter val = (UIParameter) event.getComponent().findComponent("editId");
		Long id = Long.valueOf(val.getValue().toString());
		for (Fornecedor f : this.fornecedores) {
			if (f.getId().equals(id)) {
				System.out.println("Achei " + f);
				this.fornecedor = f;
				break;
			}
		}
	}
}
