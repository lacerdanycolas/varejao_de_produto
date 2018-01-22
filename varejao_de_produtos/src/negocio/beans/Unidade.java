package negocio.beans;

public class Unidade {

	private int id;
	private String descricao;
	private String Sigla;
	
	
	
	public Unidade(int id, String descricao, String sigla) {
	
		this.id = id;
		this.descricao = descricao;
		Sigla = sigla;
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



	public String getSigla() {
		return Sigla;
	}



	public void setSigla(String sigla) {
		Sigla = sigla;
	}



	@Override
	public String toString() {
		return "Unidade [id=" + id + ", descricao=" + descricao + ", Sigla=" + Sigla + "]";
	}
	
	
}
