package negocio.entities;

import dados.MeuId;

public class Unidaderef {
	@MeuId
	private Integer id;
	private String descricao;
	private String sigla;

	public Unidaderef(){

	}

	public Unidaderef(int id, String descricao, String sigla) {

		this.id = id;
		this.descricao = descricao;
		this.sigla = sigla;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public String getSigla() {
		return sigla;
	}



	public void setSigla(String sigla) {
		sigla = sigla;
	}



	@Override
	public String toString() {
		return getSigla();
	}


}
