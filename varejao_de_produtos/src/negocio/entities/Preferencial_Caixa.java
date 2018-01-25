package negocio.entities;

public enum Preferencial_Caixa {
	S(1),N(2);
	private int id;
	
	Preferencial_Caixa (int i){
		this.id=i;
	}
	public int getId(){
		return this.id;
	}
}
