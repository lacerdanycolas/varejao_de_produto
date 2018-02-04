package dados;

import negocio.entities.Representante;

public class RepresentanteRepository extends Repository<Representante, Integer> {

	public static RepresentanteRepository instance;

	public static RepresentanteRepository getInstance(){
		if(instance == null){
			instance = new RepresentanteRepository();
		}
		return instance;
	}

	public RepresentanteRepository(){

	}
}
