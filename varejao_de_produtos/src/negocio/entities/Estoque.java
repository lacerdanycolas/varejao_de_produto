package negocio.entities;

import dados.MeuId;

public class Estoque {
	@MeuId
	private Integer id;
	private String descricao;
	private Integer  id_matriz;
	private Integer seq_filial;
	
	public Estoque(){
		
	}
	
	public Estoque(String descricao, Integer id_matriz, Integer seq_filial) {
		
		this.descricao = descricao;
		this.id_matriz = id_matriz;
		this.seq_filial = seq_filial;
	}

	public int getId() {
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

	public int getId_matriz() {
		return id_matriz;
	}

	public void setId_matriz(Integer id_matriz) {
		this.id_matriz = id_matriz;
	}

	public int getSeq_filial() {
		return seq_filial;
	}

	public void setSeq_filial(Integer seq_filial) {
		this.seq_filial = seq_filial;
	}

	@Override
	public String toString() {
		return "Estoque [id=" + id + ", descricao=" + descricao + ", id_matriz=" + id_matriz + ", seq_filial="
				+ seq_filial + "]";
	}
	
	
	
}
