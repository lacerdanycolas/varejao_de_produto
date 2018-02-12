package negocio.entities;

import java.math.BigDecimal;

import dados.MeuId;

public class Item_Pedido {
	@MeuId
	private int id;
	private int id_pedido_fornecedor;
	private int id_produto_ref;
	private int quantidade;
	private BigDecimal preco_unitario;

	public Item_Pedido(){

	}

	public Item_Pedido(int id_pedido_fornecedor, int id_produto_ref, int quantidade, BigDecimal preco_unitario){
		this.id_pedido_fornecedor = id_pedido_fornecedor;
		this.id_produto_ref = id_produto_ref;
		this.quantidade = quantidade;
		this.preco_unitario = preco_unitario;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_pedido_fornecedor() {
		return id_pedido_fornecedor;
	}
	public void setId_pedido_fornecedor(int id_pedido_fornecedor) {
		this.id_pedido_fornecedor = id_pedido_fornecedor;
	}
	public int getId_produto_ref() {
		return id_produto_ref;
	}
	public void setId_produto_ref(int id_produto_ref) {
		this.id_produto_ref = id_produto_ref;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getPreco_unitario() {
		return preco_unitario;
	}
	public void setPreco_unitario(BigDecimal preco_unitario) {
		this.preco_unitario = preco_unitario;
	}

	@Override
	public String toString() {
		return "Item_Pedido [id=" + id + ", id_pedido_fornecedor=" + id_pedido_fornecedor + ", id_produto_ref="
				+ id_produto_ref + ", quantidade=" + quantidade + ", preco_unitario=" + preco_unitario + "]";
	}



}
