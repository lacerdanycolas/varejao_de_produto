package negocio.beans;

public class Dia {
	
	private int Sequencial;
	private String Descrição;
	
	public Dia(int sequencial, String descr) {
		this.Sequencial=sequencial;
		this.Descrição=descr;
	}

	public int getSequencial() {
		return Sequencial;
	}

	public void setSequencial(int sequencial) {
		Sequencial = sequencial;
	}

	public String getDescrição() {
		return Descrição;
	}

	public void setDescrição(String descrição) {
		Descrição = descrição;
	}

	@Override
	public String toString() {
		return "Dia [Sequencial=" + Sequencial + ", Descrição=" + Descrição + "]";
	}

	
}
