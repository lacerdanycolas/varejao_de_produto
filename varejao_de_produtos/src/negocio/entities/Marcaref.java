package negocio.entities;

import dados.MeuId;

public class Marcaref {
	@MeuId
	private int id;
	private String descricao;

	public Marcaref(){

	}

	public Marcaref(int id_pedido_fornecedor, String descricao, int id_categoriaref){
		this.descricao = descricao;

	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return getDescricao();
	}

}