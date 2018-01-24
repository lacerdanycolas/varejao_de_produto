package dados;

import negocio.entities.Jornada_Trabalho;

public class Jornada_TrabalhoRepository extends Repository <Jornada_Trabalho, Integer> {
	public static Jornada_TrabalhoRepository instance;
	
	public static Jornada_TrabalhoRepository getInstance(){
		if(instance==null){
			instance = new Jornada_TrabalhoRepository();
		}
		return instance;
	}
	
	private Jornada_TrabalhoRepository(){
		
	}
}
