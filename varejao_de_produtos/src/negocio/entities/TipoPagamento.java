package negocio.entities;

public class TipoPagamento {
 
	private Integer id;
	private String descricao;
	
	public TipoPagamento() {

	}
	
	public TipoPagamento(String descricao) {
		this.descricao = descricao;
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

	@Override
	public String toString() {
		return "TipoPagamento [id=" + id + ", descricao=" + descricao + "]";
	}
	
	
	
}
