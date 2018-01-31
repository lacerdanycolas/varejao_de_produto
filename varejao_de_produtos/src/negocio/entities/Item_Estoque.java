package negocio.entities;

import java.sql.Date;

public class Item_Estoque {

	private int id;
	private double valor_compra;
	private int  quantidade;
	private Date data_validade;
	private Date data_entrada;
	private int  id_avaria;
	private int id_pratileira;
	private int id_produtoref;
	private int id_lote;
	private int id_estoque;
	public Item_Estoque(int id, double valor_compra, int quantidade, Date data_validade, Date data_entrada,
			int id_avaria, int id_pratileira, int id_produtoref, int id_lote, int id_estoque) {
		
		this.id = id;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getValor_compra() {
		return valor_compra;
	}
	public void setValor_compra(double valor_compra) {
		this.valor_compra = valor_compra;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
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
	public int getId_avaria() {
		return id_avaria;
	}
	public void setId_avaria(int id_avaria) {
		this.id_avaria = id_avaria;
	}
	public int getId_pratileira() {
		return id_pratileira;
	}
	public void setId_pratileira(int id_pratileira) {
		this.id_pratileira = id_pratileira;
	}
	public int getId_produtoref() {
		return id_produtoref;
	}
	public void setId_produtoref(int id_produtoref) {
		this.id_produtoref = id_produtoref;
	}
	public int getId_lote() {
		return id_lote;
	}
	public void setId_lote(int id_lote) {
		this.id_lote = id_lote;
	}
	public int getId_estoque() {
		return id_estoque;
	}
	public void setId_estoque(int id_estoque) {
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
