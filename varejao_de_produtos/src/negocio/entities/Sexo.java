package negocio.entities;

public enum Sexo {
	M(1), F(1);
	private int id;
	
	Sexo (int i){
		this.id=i;
	}
	
	public int getId(){
		return this.id;
	}
}
