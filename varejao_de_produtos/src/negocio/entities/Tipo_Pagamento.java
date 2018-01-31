package negocio.entities;

public enum Tipo_Pagamento {
	DEBITO(1), CREDITO(2), DINHEIRO(3), CREDITO_PARCELADO(4);
	private int id;
	
	private Tipo_Pagamento(int i) {
		this.id=i;
	}
	public int getId(){
		return this.id;
	}
}
