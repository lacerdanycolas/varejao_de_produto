package negocio.entities;

public enum Situacao_Caixa {
	ATIVO("ATIVO"),INATIVO("INATIVO");

	private String value;
	private Situacao_Caixa(String valor){
		this.value = valor;
	}

	public String toString() {
        return value;
    }
}
