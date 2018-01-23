package dados;

import negocio.entities.Dia;

public class DiaSemanaRepository extends Repository<Dia, Integer>{

	public static DiaSemanaRepository instance;
	
	public static DiaSemanaRepository getInstance(){
		if(instance == null){
			instance = new DiaSemanaRepository();
		}
		return instance;
	}
	
	private DiaSemanaRepository(){
		
	}
	
	
	
}
