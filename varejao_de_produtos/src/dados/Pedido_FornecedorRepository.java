package dados;

import negocio.entities.Pedido_Fornecedor;

public class Pedido_FornecedorRepository extends Repository<Pedido_Fornecedor, Integer> {

	public static Pedido_FornecedorRepository instance;

	public static Pedido_FornecedorRepository getInstance(){
		if(instance==null){
			instance = new Pedido_FornecedorRepository();
		}
		return instance;
	}
	private Pedido_FornecedorRepository(){

	}
}
