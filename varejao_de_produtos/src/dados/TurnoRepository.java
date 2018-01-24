package dados;

import negocio.entities.Turno;

public class TurnoRepository extends Repository<Turno, Integer>{
	public static TurnoRepository instance;
	
	public static TurnoRepository getInstance(){
		if(instance==null){
			instance = new TurnoRepository(); 
		}
		return instance;
	}
	
	private TurnoRepository(){
		
	}
}
