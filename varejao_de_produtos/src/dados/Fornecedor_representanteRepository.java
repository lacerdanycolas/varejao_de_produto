package dados;

import negocio.entities.Fornecedor_representante;

public class Fornecedor_representanteRepository extends Repository<Fornecedor_representante,Integer> {

	public static Fornecedor_representanteRepository instance;

	public static Fornecedor_representanteRepository getInstance(){
		if(instance == null){
			instance = new Fornecedor_representanteRepository();
		}
		return instance;
	}

	private Fornecedor_representanteRepository(){

	}
}
