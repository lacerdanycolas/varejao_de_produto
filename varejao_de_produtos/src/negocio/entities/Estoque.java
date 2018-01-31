package negocio.entities;

public class Estoque {
	private int id;
	private String descricao;
	private int  id_matriz;
	private int  seq_filial;
	
	public Estoque(int id, String descricao, int id_matriz, int seq_filial) {
		
		this.id = id;
		this.descricao = descricao;
		this.id_matriz = id_matriz;
		this.seq_filial = seq_filial;
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

	public int getId_matriz() {
		return id_matriz;
	}

	public void setId_matriz(int id_matriz) {
		this.id_matriz = id_matriz;
	}

	public int getSeq_filial() {
		return seq_filial;
	}

	public void setSeq_filial(int seq_filial) {
		this.seq_filial = seq_filial;
	}

	@Override
	public String toString() {
		return "Estoque [id=" + id + ", descricao=" + descricao + ", id_matriz=" + id_matriz + ", seq_filial="
				+ seq_filial + "]";
	}
	
	
	
}
