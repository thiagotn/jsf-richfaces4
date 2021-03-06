package exemplo.jsf.richfaces4.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ContaPagar implements Serializable {

	private static final long serialVersionUID = -237288118976052588L;

	@Id @GeneratedValue
	private Long id;
	
	private String descricao;
	
	private Double valor;

	@Temporal(TemporalType.DATE)	
	private Calendar data = new GregorianCalendar();
	
	@ManyToOne	
	private Fornecedor fornecedor;
	
	private boolean pago;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}

	@Override
	public String toString() {
		return "ContaPagar [id=" + id + ", descricao=" + descricao + ", valor="
				+ valor + ", data=" + data + ", fornecedor=" + fornecedor
				+ ", pago=" + pago + "]";
	}
	
}
