package dados;

import negocio.entities.Venda;

public class VendaRepository  extends Repository <Venda, Integer>  {
	
	public static VendaRepository instance;
	
	public static VendaRepository getInstance(){
		if(instance==null){
			instance = new VendaRepository();
		}
		return instance;
	}
	
	private VendaRepository(){
		
	}

}
