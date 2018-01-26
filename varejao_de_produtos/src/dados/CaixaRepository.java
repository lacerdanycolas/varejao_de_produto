package dados;

import negocio.entities.Caixa;

public class CaixaRepository extends Repository <Caixa,Integer>{
	public static CaixaRepository instance;
	
	public static CaixaRepository getInstance(){
		if(instance == null){
			instance = new CaixaRepository();
		}
		return instance;
	}
	
	private CaixaRepository(){
		
	}
}
