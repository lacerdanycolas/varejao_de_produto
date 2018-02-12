package dados;

import negocio.entities.Marcaref;

public class MarcaRepository extends Repository<Marcaref, Integer> {

	public static MarcaRepository instance;

	public static MarcaRepository getInstance(){
		if(instance==null){
			instance = new MarcaRepository();
		}
		return instance;
	}
	private MarcaRepository(){

	}
}
