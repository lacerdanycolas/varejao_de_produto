package negocio.entities;

public enum Situacao_Fatura {
	 PAGO(1), ABERTO(2);
	
	private int id;
	
	private Situacao_Fatura(int i) {
		this.id=i;
	}
	
	public int getId(){
		return this.id;
	}
	
}
