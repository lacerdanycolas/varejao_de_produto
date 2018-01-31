package negocio.beans;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Item_Venda {

	private int id;
	private int id_venda;
	private int id_produtoref;
	private int quantidade;
	private BigDecimal valor_unitario;
	private  BigDecimal valor_desconto_item;
	
	
	public Item_Venda( int id_venda, int id_produtoref, int quantidade,  BigDecimal valor_unitario,
			 BigDecimal valor_desconto_item) {
		
		this.id_venda = id_venda;
		this.id_produtoref = id_produtoref;
		this.quantidade = quantidade;
		this.valor_unitario = valor_unitario;
		this.valor_desconto_item = valor_desconto_item;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getId_venda() {
		return id_venda;
	}


	public void setId_venda(int id_venda) {
		this.id_venda = id_venda;
	}


	public int getId_produtoref() {
		return id_produtoref;
	}


	public void setId_produtoref(int id_produtoref) {
		this.id_produtoref = id_produtoref;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public  BigDecimal getValor_unitario() {
		return valor_unitario;
	}


	public void setValor_unitario( BigDecimal valor_unitario) {
		this.valor_unitario = valor_unitario;
	}


	public  BigDecimal getValor_desconto_item() {
		return valor_desconto_item;
	}


	public void setValor_desconto_item( BigDecimal valor_desconto_item) {
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
