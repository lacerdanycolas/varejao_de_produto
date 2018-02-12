package dados;

import negocio.entities.Categoriaref;

public class CategoriaRepository extends Repository<Categoriaref, Integer> {

	public static CategoriaRepository instance;

	public static CategoriaRepository getInstance(){
		if(instance==null){
			instance = new CategoriaRepository();
		}
		return instance;
	}
	private CategoriaRepository(){

	}
}
