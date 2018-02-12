package negocio.entities;

import dados.MeuId;

public class Sub_categoriaref {
	@MeuId
	private int id;
	private String descricao;
	private int id_categoriaref;

	public Sub_categoriaref(){

	}

	public Sub_categoriaref(int id_pedido_fornecedor, String descricao, int id_categoriaref){
		this.descricao = descricao;
		this.id_categoriaref = id_categoriaref;

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao_categoria() {
		return descricao;
	}
	public void setDescricao_categoria(String descricao) {
		this.descricao = descricao;
	}

	public int getId_categoriaref() {
		return id_categoriaref;
	}
	public void setId_categoria(int id_categoriaref) {
		this.id_categoriaref = id_categoriaref;
	}

	@Override
	public String toString() {
		return getDescricao_categoria();
	}

}