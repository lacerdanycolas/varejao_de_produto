package negocio.entities;

import java.sql.Date;

import dados.MeuId;

public class Fatura {
	@MeuId
	private Integer id;
	private Date data_vencimento;
	private Double valor_pago_atual;
	private Situacao_Fatura Sfatura;
	private Date data_paga;
	private Double multa;
	private Integer  id_pedido_fornecedor;
	
	public Fatura(){
		
	}
	
	public Fatura(Date data_vencimento, Double valor_pago_atual, Situacao_Fatura sfatura, Date data_paga,
			Double multa, Integer id_pedido_fornecedor) {
		
		this.data_vencimento = data_vencimento;
		this.valor_pago_atual = valor_pago_atual;
		Sfatura = sfatura;
		this.data_paga = data_paga;
		this.multa = multa;
		this.id_pedido_fornecedor = id_pedido_fornecedor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData_vencimento() {
		return data_vencimento;
	}

	public void setData_vencimento(Date data_vencimento) {
		this.data_vencimento = data_vencimento;
	}

	public double getValor_pago_atual() {
		return valor_pago_atual;
	}

	public void setValor_pago_atual(Double valor_pago_atual) {
		this.valor_pago_atual = valor_pago_atual;
	}

	public Situacao_Fatura getSfatura() {
		return Sfatura;
	}

	public void setSfatura(Situacao_Fatura sfatura) {
		Sfatura = sfatura;
	}

	public Date getData_paga() {
		return data_paga;
	}

	public void setData_paga(Date data_paga) {
		this.data_paga = data_paga;
	}

	public Double getMulta() {
		return multa;
	}

	public void setMulta(Double multa) {
		this.multa = multa;
	}

	public Integer getId_pedido_fornecedor() {
		return id_pedido_fornecedor;
	}

	public void setId_pedido_fornecedor(Integer id_pedido_fornecedor) {
		this.id_pedido_fornecedor = id_pedido_fornecedor;
	}

	@Override
	public String toString() {
		return "Fatura [id=" + id + ", data_vencimento=" + data_vencimento + ", valor_pago_atual=" + valor_pago_atual
				+ ", Sfatura=" + Sfatura + ", data_paga=" + data_paga + ", multa=" + multa + ", id_pedido_fornecedor="
				+ id_pedido_fornecedor + "]";
	}
	
	
	
}
