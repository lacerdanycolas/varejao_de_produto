package negocio.entities;

public enum Situacao {
	ATIVO(1), INATIVO(2);
	private int id;
	
	Situacao (int i){
		this.id=i;
	}
	
	public int getId(){
		return this.id;
	}
}
