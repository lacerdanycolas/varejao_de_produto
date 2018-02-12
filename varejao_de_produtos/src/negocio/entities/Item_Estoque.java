package negocio.entities;

import java.math.BigDecimal;
import java.sql.Date;

import dados.MeuId;

public class Item_Estoque {
	@MeuId
	private Integer id;
	private BigDecimal valor_compra;
	private Integer quantidade;
	private Date data_validade;
	private Date data_entrada;
	private Integer id_avaria;
	private Integer id_pratileira;
	private Integer id_produtoref;
	private Integer id_lote;
	private Integer id_estoque;

	public Item_Estoque(){

	}

	public Item_Estoque(BigDecimal valor_compra, Integer quantidade, Date data_validade, Date data_entrada,
			Integer id_avaria, Integer id_pratileira, Integer id_produtoref, Integer id_lote, Integer id_estoque) {

		this.valor_compra = valor_compra;
		this.quantidade = quantidade;
		this.data_validade = data_validade;
		this.data_entrada = data_entrada;
		this.id_avaria = id_avaria;
		this.id_pratileira = id_pratileira;
		this.id_produtoref = id_produtoref;
		this.id_lote = id_lote;
		this.id_estoque = id_estoque;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public BigDecimal getValor_compra() {
		return valor_compra;
	}
	public void setValor_compra(BigDecimal valor_compra) {
		this.valor_compra = valor_compra;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Date getData_validade() {
		return data_validade;
	}
	public void setData_validade(Date data_validade) {
		this.data_validade = data_validade;
	}
	public Date getData_entrada() {
		return data_entrada;
	}
	public void setData_entrada(Date data_entrada) {
		this.data_entrada = data_entrada;
	}
	public Integer getId_avaria() {
		return id_avaria;
	}
	public void setId_avaria(Integer id_avaria) {
		this.id_avaria = id_avaria;
	}
	public Integer getId_pratileira() {
		return id_pratileira;
	}
	public void setId_pratileira(Integer id_pratileira) {
		this.id_pratileira = id_pratileira;
	}
	public Integer getId_produtoref() {
		return id_produtoref;
	}
	public void setId_produtoref(Integer id_produtoref) {
		this.id_produtoref = id_produtoref;
	}
	public Integer getId_lote() {
		return id_lote;
	}
	public void setId_lote(Integer id_lote) {
		this.id_lote = id_lote;
	}
	public Integer getId_estoque() {
		return id_estoque;
	}
	public void setId_estoque(Integer id_estoque) {
		this.id_estoque = id_estoque;
	}

	@Override
	public String toString() {
		return "Item_Estoque [id=" + id + ", valor_compra=" + valor_compra + ", quantidade=" + quantidade
				+ ", data_validade=" + data_validade + ", data_entrada=" + data_entrada + ", id_avaria=" + id_avaria
				+ ", id_pratileira=" + id_pratileira + ", id_produtoref=" + id_produtoref + ", id_lote=" + id_lote
				+ ", id_estoque=" + id_estoque + "]";
	}



}
