package negocio.entities;

import java.math.BigDecimal;
import java.util.ArrayList;

import dados.MeuId;

public class Item_Venda {
	@MeuId
	private Integer id;
	private Integer id_venda;
	private Integer id_produtoref;
	private Integer quantidade;
	private BigDecimal valor_unitario;
	private BigDecimal valor_desconto_item;
	
	
	public Item_Venda(Integer id_venda, Integer id_produtoref, Integer quantidade, BigDecimal valor_unitario2,
			BigDecimal valor_desconto_item2) {
		this.id_venda = id_venda;
		this.id_produtoref = id_produtoref;
		this.quantidade = quantidade;
		this.valor_unitario = valor_unitario2;
		this.valor_desconto_item = valor_desconto_item2;
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

	public BigDecimal getValor_unitario() {
		return valor_unitario;
	}

	public void setValor_unitario(BigDecimal valor_unitario) {
		this.valor_unitario = valor_unitario;
	}

	public BigDecimal getValor_desconto_item() {

		return valor_desconto_item;
	}


	public void setValor_desconto_item(BigDecimal valor_desconto_item) {

		this.valor_desconto_item = valor_desconto_item;
	}
	
	public BigDecimal Valor_total(ArrayList<Item_Venda> lista) {
		BigDecimal decimal = null;
		
		for(int i=0; i<lista.size();i++) {
			decimal=lista.get(i).getValor_unitario().add(decimal);
		}
		return decimal;
	}
	
	public BigDecimal Valor_Total_Desconto(ArrayList<Item_Venda> lista) {
		BigDecimal decimal = null;
		
		for(int i=0; i<lista.size();i++) {
			decimal=lista.get(i).getValor_desconto_item().add(decimal);
		}
		return decimal;
	}
	


	@Override
	public String toString() {
		return "Item_Venda [id=" + id + ", id_venda=" + id_venda + ", id_produtoref=" + id_produtoref + ", quantidade="
				+ quantidade + ", valor_unitario=" + valor_unitario + ", valor_desconto_item=" + valor_desconto_item
				+ "]";
	}
	
	
	
	
}
