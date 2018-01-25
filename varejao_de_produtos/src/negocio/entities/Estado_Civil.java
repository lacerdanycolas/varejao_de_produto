package negocio.entities;

public enum Estado_Civil {
	SOLTEIRO(1), CASADO(2), DIVORCIADO(3);
	private int id;
	
	Estado_Civil (int i){
		this.id=i;
	}
	
	public int getId(){
		return this.id;
	}
}
