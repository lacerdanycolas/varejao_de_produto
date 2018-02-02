package negocio.entities;

import dados.MeuId;

public class Jornada_Trabalho {
	@MeuId
	private int id;
	private Integer id_func;
	private Trabalha_Sabado trabalho_sabado;
	private String descricao;

	public Jornada_Trabalho(){

	}
	public Jornada_Trabalho(Integer id_func, Trabalha_Sabado trabaS, String descricao) {

		this.id_func = id_func;
		this.trabalho_sabado = trabaS;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_func() {
		return id_func;
	}

	public void setId_func(int id_func) {
		this.id_func = id_func;
	}

	public Trabalha_Sabado getTrabaS() {
		return trabalho_sabado;
	}

	public void setTrabaS(Trabalha_Sabado trabaS) {
		this.trabalho_sabado = trabaS;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Jornada_Trabalho [id=" + id + ", id_func=" + id_func + ", trabaS=" + trabalho_sabado + ", descricao=" + descricao
				+ "]";
	}



}
