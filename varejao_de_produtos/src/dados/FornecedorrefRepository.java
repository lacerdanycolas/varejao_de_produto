package dados;

import negocio.entities.Fornecedorref;

public class FornecedorrefRepository extends Repository<Fornecedorref, Integer> {
	
	public static FornecedorrefRepository instance;
	
	public static FornecedorrefRepository getInstance(){
		if(instance == null){
			instance = new FornecedorrefRepository();
		}
		return instance;
	}
	
	private FornecedorrefRepository(){
		
	}
}
