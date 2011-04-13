package exemplo.jsf.richfaces4.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 5633388803016611567L;

	@Id @GeneratedValue
	private Long id;
	
	private String nome;
	
	private String usuario;
	
	private String senha;
	
	private String email;

	@OneToMany(mappedBy="fornecedor")
	private List<ContaPagar> contas;
	
	@ManyToMany(mappedBy="contatos")
	private List<Fornecedor> fornecedores;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<ContaPagar> getContas() {
		return contas;
	}

	public void setContas(List<ContaPagar> contas) {
		this.contas = contas;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", usuario="
				+ usuario + ", senha=" + senha + ", email=" + email
				+ ", contas=" + contas + ", fornecedores=" + fornecedores + "]";
	}
	
}
