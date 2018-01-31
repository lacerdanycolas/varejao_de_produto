package negocio.entities;

import dados.MeuId;

public class Prateleira {
	@MeuId
	private Integer id;
	private Double altura;
	private Double comprimento;
	private Integer posicao_nivel;
	
	public Prateleira(){
		
	}
	
	public Prateleira(Double altura, Double comprimento, Integer posicao_nivel) {
		
		this.altura = altura;
		this.comprimento = comprimento;
		this.posicao_nivel = posicao_nivel;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getComprimento() {
		return comprimento;
	}

	public void setComprimento(Double comprimento) {
		this.comprimento = comprimento;
	}

	public Integer getPosicao_nivel() {
		return posicao_nivel;
	}

	public void setPosicao_nivel(Integer posicao_nivel) {
		this.posicao_nivel = posicao_nivel;
	}

	@Override
	public String toString() {
		return "Prateleira [id=" + id + ", altura=" + altura + ", comprimento=" + comprimento + ", posicao_nivel="
				+ posicao_nivel + "]";
	}
	
	
	
	
}
