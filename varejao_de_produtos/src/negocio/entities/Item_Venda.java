package negocio.entities;

import dados.MeuId;

public class Item_Venda {
	@MeuId
	private Integer id;
	private Integer id_venda;
	private Integer id_produtoref;
	private Integer quantidade;
	private Double valor_unitario;
	private Double valor_desconto_item;
	
	
	public Item_Venda(Integer id_venda, Integer id_produtoref, Integer quantidade, Double valor_unitario,
			Double valor_desconto_item) {
		this.id_venda = id_venda;
		this.id_produtoref = id_produtoref;
		this.quantidade = quantidade;
		this.valor_unitario = valor_unitario;
		this.valor_desconto_item = valor_desconto_item;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getId_venda() {
		return id_venda;
	}


	public void setId_venda(Integer id_venda) {
		this.id_venda = id_venda;
	}


	public Integer getId_produtoref() {
		return id_produtoref;
	}


	public void setId_produtoref(Integer id_produtoref) {
		this.id_produtoref = id_produtoref;
	}


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}


	public Double getValor_unitario() {
		return valor_unitario;
	}


	public void setValor_unitario(Double valor_unitario) {
		this.valor_unitario = valor_unitario;
	}


	public Double getValor_desconto_item() {
		return valor_desconto_item;
	}


	public void setValor_desconto_item(Double valor_desconto_item) {
		this.valor_desconto_item = valor_desconto_item;
	}


	@Override
	public String toString() {
		return "Item_Venda [id=" + id + ", id_venda=" + id_venda + ", id_produtoref=" + id_produtoref + ", quantidade="
				+ quantidade + ", valor_unitario=" + valor_unitario + ", valor_desconto_item=" + valor_desconto_item
				+ "]";
	}
	
	
	
	
}
