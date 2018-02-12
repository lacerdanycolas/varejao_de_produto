package dados;

import negocio.entities.Sub_categoriaref;

public class Sub_categoriaRepository extends Repository<Sub_categoriaref, Integer> {

	public static Sub_categoriaRepository instance;

	public static Sub_categoriaRepository getInstance(){
		if(instance==null){
			instance = new Sub_categoriaRepository();
		}
		return instance;
	}
	private Sub_categoriaRepository(){

	}
}
