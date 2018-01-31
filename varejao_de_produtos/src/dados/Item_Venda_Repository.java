package dados;

import negocio.entities.Item_Venda;


public class Item_Venda_Repository extends Repository <Item_Venda, Integer> {
	
	public static Item_Venda_Repository instance;
	
	public static Item_Venda_Repository getInstance(){
		if(instance==null){
			instance = new Item_Venda_Repository();
		}
		return instance;
	}
	
	private Item_Venda_Repository(){
		
	}
	
}


