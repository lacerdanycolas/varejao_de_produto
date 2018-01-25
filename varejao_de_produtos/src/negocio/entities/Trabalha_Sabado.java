package negocio.entities;

public enum Trabalha_Sabado {
	S(1), N(1);
	private int id;
	Trabalha_Sabado(int i){
		this.id=i;
	}
	public int getId(){
		return this.id;
	}
}
