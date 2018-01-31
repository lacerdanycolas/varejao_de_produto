package negocio.entities;

import java.sql.Date;

public class Pagamento {

	private int id;
	private Date data_pagamento;
	private double valor_pago;
	private Situacao_Fatura situacaoP;
	private Tipo_Pagamento TPG;
	private int id_tipo_pagamento;
	private int  id_fatura;
	private int id_venda;
	private int id_nota_fiscal_fornecedor;
	
	public Pagamento(int id, Date data_pagamento, double valor_pago, Situacao_Fatura situacaoP, Tipo_Pagamento tPG,
			int id_tipo_pagamento, int id_fatura, int id_venda, int id_nota_fiscal_fornecedor) {
		
		this.id = id;
		this.data_pagamento = data_pagamento;
		this.valor_pago = valor_pago;
		this.situacaoP = situacaoP;
		TPG = tPG;
		this.id_tipo_pagamento = id_tipo_pagamento;
		this.id_fatura = id_fatura;
		this.id_venda = id_venda;
		this.id_nota_fiscal_fornecedor = id_nota_fiscal_fornecedor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData_pagamento() {
		return data_pagamento;
	}

	public void setData_pagamento(Date data_pagamento) {
		this.data_pagamento = data_pagamento;
	}

	public double getValor_pago() {
		return valor_pago;
	}

	public void setValor_pago(double valor_pago) {
		this.valor_pago = valor_pago;
	}

	public Situacao_Fatura getSituacaoP() {
		return situacaoP;
	}

	public void setSituacaoP(Situacao_Fatura situacaoP) {
		this.situacaoP = situacaoP;
	}

	public Tipo_Pagamento getTPG() {
		return TPG;
	}

	public void setTPG(Tipo_Pagamento tPG) {
		TPG = tPG;
	}

	public int getId_tipo_pagamento() {
		return id_tipo_pagamento;
	}

	public void setId_tipo_pagamento(int id_tipo_pagamento) {
		this.id_tipo_pagamento = id_tipo_pagamento;
	}

	public int getId_fatura() {
		return id_fatura;
	}

	public void setId_fatura(int id_fatura) {
		this.id_fatura = id_fatura;
	}

	public int getId_venda() {
		return id_venda;
	}

	public void setId_venda(int id_venda) {
		this.id_venda = id_venda;
	}

	public int getId_nota_fiscal_fornecedor() {
		return id_nota_fiscal_fornecedor;
	}

	public void setId_nota_fiscal_fornecedor(int id_nota_fiscal_fornecedor) {
		this.id_nota_fiscal_fornecedor = id_nota_fiscal_fornecedor;
	}

	@Override
	public String toString() {
		return "Pagamento [id=" + id + ", data_pagamento=" + data_pagamento + ", valor_pago=" + valor_pago
				+ ", situacaoP=" + situacaoP + ", TPG=" + TPG + ", id_tipo_pagamento=" + id_tipo_pagamento
				+ ", id_fatura=" + id_fatura + ", id_venda=" + id_venda + ", id_nota_fiscal_fornecedor="
				+ id_nota_fiscal_fornecedor + "]";
	}
	
	
	
}
