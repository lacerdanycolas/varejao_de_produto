package negocio.beans;

public class Dia {
	
	private int Sequencial;
	private String Descri��o;
	
	public Dia(int sequencial, String descr) {
		this.Sequencial=sequencial;
		this.Descri��o=descr;
	}

	public int getSequencial() {
		return Sequencial;
	}

	public void setSequencial(int sequencial) {
		Sequencial = sequencial;
	}

	public String getDescri��o() {
		return Descri��o;
	}

	public void setDescri��o(String descri��o) {
		Descri��o = descri��o;
	}

	@Override
	public String toString() {
		return "Dia [Sequencial=" + Sequencial + ", Descri��o=" + Descri��o + "]";
	}

	
}
