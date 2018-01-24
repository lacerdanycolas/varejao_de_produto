package dados;

import negocio.entities.Dia;

public class DiaRepository extends Repository<Dia, Integer>{

	public static DiaRepository instance;
	
	public static DiaRepository getInstance(){
		if(instance == null){
			instance = new DiaRepository();
		}
		return instance;
	}
	
	private DiaRepository(){
		
	}
	
	
	
}
