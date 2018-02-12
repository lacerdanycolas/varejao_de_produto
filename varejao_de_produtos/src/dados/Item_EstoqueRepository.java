package dados;

import negocio.entities.Item_Estoque;

public class Item_EstoqueRepository extends Repository<Item_Estoque, Integer>{
	public static Item_EstoqueRepository instance;

	public static Item_EstoqueRepository getInstance(){
		if(instance==null){
			instance=new Item_EstoqueRepository();
		}
		return instance;
	}
	private Item_EstoqueRepository(){

	}

}
