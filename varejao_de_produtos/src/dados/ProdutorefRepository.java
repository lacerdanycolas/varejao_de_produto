package dados;

import negocio.entities.Produtoref;

public class ProdutorefRepository extends Repository <Produtoref, Integer> {
	
	public static ProdutorefRepository instance;
	
	public static ProdutorefRepository getInstance(){
		if(instance==null){
			instance = new ProdutorefRepository();
		}
		return instance;
	}
	
	private ProdutorefRepository(){
		
	}
}
