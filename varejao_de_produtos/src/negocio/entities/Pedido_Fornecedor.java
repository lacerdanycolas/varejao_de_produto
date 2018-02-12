package negocio.entities;
import dados.MeuId;

import java.math.BigDecimal;
import java.sql.Date;

public class Pedido_Fornecedor {
	@MeuId
	private int id;
	private BigDecimal total_desconto;
	private BigDecimal valor_total;
	private BigDecimal ipi;
	private String cfop;
	private Date data_pedido;
	private Situacao situacao;
	private BigDecimal valor_frete;
	private String cpf_coordenador;

	public Pedido_Fornecedor(){

	}

	public Pedido_Fornecedor(BigDecimal total_desconto, BigDecimal valor_total, BigDecimal ipi, String cfop,
			Date data_pedido, Situacao situacao, BigDecimal valor_frete, String cpf_coordenador) {
		this.total_desconto = total_desconto;
		this.valor_total = valor_total;
		this.ipi = ipi;
		this.cfop = cfop;
		this.data_pedido = data_pedido;
		this.situacao = situacao;
		this.valor_frete = valor_frete;
		this.cpf_coordenador = cpf_coordenador;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public BigDecimal getTotal_desconto() {
		return total_desconto;
	}


	public void setTotal_desconto(BigDecimal total_desconto) {
		this.total_desconto = total_desconto;
	}


	public BigDecimal getValor_total() {
		return valor_total;
	}


	public void setValor_total(BigDecimal valor_total) {
		this.valor_total = valor_total;
	}


	public BigDecimal getIpi() {
		return ipi;
	}


	public void setIpi(BigDecimal ipi) {
		this.ipi = ipi;
	}


	public String getCfop() {
		return cfop;
	}


	public void setCfop(String cfop) {
		this.cfop = cfop;
	}


	public Date getData_pedido() {
		return data_pedido;
	}


	public void setData_pedido(Date data_pedido) {
		this.data_pedido = data_pedido;
	}


	public Situacao getSituacao() {
		return situacao;
	}


	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}


	public BigDecimal getValor_frete() {
		return valor_frete;
	}


	public void setValor_frete(BigDecimal valor_frete) {
		this.valor_frete = valor_frete;
	}


	public String getCpf_coordenador() {
		return cpf_coordenador;
	}


	public void setCpf_coordenador(String cpf_coordenador) {
		this.cpf_coordenador = cpf_coordenador;
	}


	@Override
	public String toString() {
		return "Pedido_Fornecedor [id=" + id + ", total_desconto=" + total_desconto + ", valor_total=" + valor_total
				+ ", ipi=" + ipi + ", cfop=" + cfop + ", data_pedido=" + data_pedido + ", situacao=" + situacao
				+ ", valor_frete=" + valor_frete + ", cpf_coordenador=" + cpf_coordenador + "]";
	}



}
