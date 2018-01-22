package negocio.entities;

public class Dia {
	private int sequencial;
	private String descricao;
	
	public Dia(int sequencial, String descricao) {
		super();
		this.sequencial = sequencial;
		this.descricao = descricao;
	}
	public int getSequencial() {
		return sequencial;
	}
	public void setSequencial(int sequencial) {
		this.sequencial = sequencial;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	

}
