package negocio.beans;

import java.sql.Date;

public class Pedido_Fornecedor {
	private int id;
	private double total_desconto;
	private double valor_total;
	private double ipi;
	private String cfop;
	private Date data_pedido;
	private Situacao situacao;
	private double valor_frete;
	private String cpf_coordenador;
	
	
	public Pedido_Fornecedor(int id, double total_desconto, double valor_total, double ipi, String cfop,
			Date data_pedido, Situacao situacao, double valor_frete, String cpf_coordenador) {
		this.id = id;
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


	public double getTotal_desconto() {
		return total_desconto;
	}


	public void setTotal_desconto(double total_desconto) {
		this.total_desconto = total_desconto;
	}


	public double getValor_total() {
		return valor_total;
	}


	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}


	public double getIpi() {
		return ipi;
	}


	public void setIpi(double ipi) {
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


	public double getValor_frete() {
		return valor_frete;
	}


	public void setValor_frete(double valor_frete) {
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
