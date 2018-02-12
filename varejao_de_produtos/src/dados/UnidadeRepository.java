package dados;

import negocio.entities.Unidaderef;

public class UnidadeRepository extends Repository<Unidaderef, Integer> {

	public static UnidadeRepository instance;

	public static UnidadeRepository getInstance(){
		if(instance==null){
			instance = new UnidadeRepository();
		}
		return instance;
	}
	private UnidadeRepository(){

	}
}
