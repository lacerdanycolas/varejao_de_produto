package negocio.entities;

import dados.MeuId;

public class Categoriaref {
	@MeuId
	private int id;
	private String descricao;

	public Categoriaref(){

	}

	public Categoriaref(int id_pedido_fornecedor, String descricao){
		this.descricao = descricao;

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

	@Override
	public String toString() {
		return getDescricao_categoria();
	}

}