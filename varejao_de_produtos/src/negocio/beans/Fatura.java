package negocio.beans;

import java.sql.Date;

public class Fatura {
	private int id;
	private Date data_vencimento;
	private double valor_pago_atual;
	private Situacao_Fatura Sfatura;
	private Date data_paga;
	private double multa;
	private int  id_pedido_fornecedor;
	
	public Fatura(int id, Date data_vencimento, double valor_pago_atual, Situacao_Fatura sfatura, Date data_paga,
			double multa, int id_pedido_fornecedor) {
		
		this.id = id;
		this.data_vencimento = data_vencimento;
		this.valor_pago_atual = valor_pago_atual;
		Sfatura = sfatura;
		this.data_paga = data_paga;
		this.multa = multa;
		this.id_pedido_fornecedor = id_pedido_fornecedor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public void setValor_pago_atual(double valor_pago_atual) {
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

	public double getMulta() {
		return multa;
	}

	public void setMulta(double multa) {
		this.multa = multa;
	}

	public int getId_pedido_fornecedor() {
		return id_pedido_fornecedor;
	}

	public void setId_pedido_fornecedor(int id_pedido_fornecedor) {
		this.id_pedido_fornecedor = id_pedido_fornecedor;
	}

	@Override
	public String toString() {
		return "Fatura [id=" + id + ", data_vencimento=" + data_vencimento + ", valor_pago_atual=" + valor_pago_atual
				+ ", Sfatura=" + Sfatura + ", data_paga=" + data_paga + ", multa=" + multa + ", id_pedido_fornecedor="
				+ id_pedido_fornecedor + "]";
	}
	
	
	
}
