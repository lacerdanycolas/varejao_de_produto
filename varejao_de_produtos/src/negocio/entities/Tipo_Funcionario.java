package negocio.entities;

public enum Tipo_Funcionario {
	OPERADOR_DE_CAIXA(1), SUPERVISOR_DE_CAIXA(2), COORDENADOR(3), CARREGADOR(4), SUPERVISOR_DE_ESTOQUE(5);
	private int id;
	
	Tipo_Funcionario (int i){
		this.id = i;
	}
	
	public int getId(){
		return this.id;
	}

}
