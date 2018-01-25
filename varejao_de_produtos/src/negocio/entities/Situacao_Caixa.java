package negocio.entities;

public enum Situacao_Caixa {
	ATIVO(1), INATIVO(2);
	private int id;
	
	Situacao_Caixa(int i){
		this.id=i;
	}
	
	public int getId(){
		return this.id;
	}
	
}
