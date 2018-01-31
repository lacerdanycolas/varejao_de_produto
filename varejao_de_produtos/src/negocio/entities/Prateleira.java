package negocio.entities;

public class Prateleira {

	private int id;
	private double altura;
	private double comprimento;
	private int  posicao_nivel;
	
	public Prateleira(int id, double altura, double comprimento, int posicao_nivel) {
		
		this.id = id;
		this.altura = altura;
		this.comprimento = comprimento;
		this.posicao_nivel = posicao_nivel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getComprimento() {
		return comprimento;
	}

	public void setComprimento(double comprimento) {
		this.comprimento = comprimento;
	}

	public int getPosicao_nivel() {
		return posicao_nivel;
	}

	public void setPosicao_nivel(int posicao_nivel) {
		this.posicao_nivel = posicao_nivel;
	}

	@Override
	public String toString() {
		return "Prateleira [id=" + id + ", altura=" + altura + ", comprimento=" + comprimento + ", posicao_nivel="
				+ posicao_nivel + "]";
	}
	
	
	
	
}
