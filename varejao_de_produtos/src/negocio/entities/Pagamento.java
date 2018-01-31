package negocio.entities;

import java.sql.Date;

import dados.MeuId;

public class Pagamento {
	@MeuId
	private Integer id;
	private Date data_pagamento;
	private Double valor_pago;
	private Situacao_Fatura situacaoP;
	private Tipo_Pagamento TPG;
	private Integer id_tipo_pagamento;
	private Integer  id_fatura;
	private Integer id_venda;
	private Integer id_nota_fiscal_fornecedor;
	
	public Pagamento(){
		
	}
	
	public Pagamento( Date data_pagamento, Double valor_pago, Situacao_Fatura situacaoP, Tipo_Pagamento tPG,
			Integer id_tipo_pagamento, Integer id_fatura, Integer id_venda, Integer id_nota_fiscal_fornecedor) {
		;
		this.data_pagamento = data_pagamento;
		this.valor_pago = valor_pago;
		this.situacaoP = situacaoP;
		TPG = tPG;
		this.id_tipo_pagamento = id_tipo_pagamento;
		this.id_fatura = id_fatura;
		this.id_venda = id_venda;
		this.id_nota_fiscal_fornecedor = id_nota_fiscal_fornecedor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData_pagamento() {
		return data_pagamento;
	}

	public void setData_pagamento(Date data_pagamento) {
		this.data_pagamento = data_pagamento;
	}

	public Double getValor_pago() {
		return valor_pago;
	}

	public void setValor_pago(Double valor_pago) {
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

	public Integer getId_tipo_pagamento() {
		return id_tipo_pagamento;
	}

	public void setId_tipo_pagamento(Integer id_tipo_pagamento) {
		this.id_tipo_pagamento = id_tipo_pagamento;
	}

	public Integer getId_fatura() {
		return id_fatura;
	}

	public void setId_fatura(Integer id_fatura) {
		this.id_fatura = id_fatura;
	}

	public Integer getId_venda() {
		return id_venda;
	}

	public void setId_venda(Integer id_venda) {
		this.id_venda = id_venda;
	}

	public Integer getId_nota_fiscal_fornecedor() {
		return id_nota_fiscal_fornecedor;
	}

	public void setId_nota_fiscal_fornecedor(Integer id_nota_fiscal_fornecedor) {
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
