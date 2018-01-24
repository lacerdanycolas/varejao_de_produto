package negocio.entities;

import dados.MeuId;

public class Jornada_Trabalho {
	@MeuId
	private int id;
	private int id_func;
	private Trabalha_Sabado trabaS;
	private String descricao;
	
	public Jornada_Trabalho(int id, int id_func, Trabalha_Sabado trabaS, String descricao) {
		
		this.id = id;
		this.id_func = id_func;
		this.trabaS = trabaS;
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
		return trabaS;
	}

	public void setTrabaS(Trabalha_Sabado trabaS) {
		this.trabaS = trabaS;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Jornada_Trabalho [id=" + id + ", id_func=" + id_func + ", trabaS=" + trabaS + ", descricao=" + descricao
				+ "]";
	}

	
	
}
