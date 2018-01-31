package negocio.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;

import dados.MeuId;

public class Venda {
	@MeuId
	private Integer id;
	private String cpf_comprador;
	private BigDecimal valor_total;
	private Date data_venda;
	private BigDecimal valor_total_desconto;
	private int id_caixa;
		
	
	public Venda(String cpf_comprador, BigDecimal valor_total, Date data_venda, BigDecimal valor_total_desconto,
			Integer id_caixa) {

		this.cpf_comprador = cpf_comprador;
		this.valor_total = valor_total;
		this.data_venda = data_venda;
		this.valor_total_desconto = valor_total_desconto;
		this.id_caixa = id_caixa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpf_comprador() {
		return cpf_comprador;
	}

	public void setCpf_comprador(String cpf_comprador) {
		this.cpf_comprador = cpf_comprador;
	}

	public BigDecimal getValor_total() {
		return valor_total;
	}

	public void setValor_total(BigDecimal valor_total) {
		this.valor_total = valor_total;
	}

	public Date getData_venda() {
		return data_venda;
	}

	public void setData_venda(Date data_venda) {
		this.data_venda = data_venda;
	}

	public BigDecimal getValor_total_desconto() {
		return valor_total_desconto;
	}

	public void setValor_total_desconto(BigDecimal valor_total_desconto) {
		this.valor_total_desconto = valor_total_desconto;
	}

	public Integer getId_caixa() {
		return id_caixa;
	}

	public void setId_caixa(Integer id_caixa) {
		this.id_caixa = id_caixa;
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", cpf_comprador=" + cpf_comprador + ", valor_total=" + valor_total + ", data_venda="
				+ data_venda + ", valor_total_desconto=" + valor_total_desconto + ", id_caixa=" + id_caixa + "]";
	}
	
	

}
