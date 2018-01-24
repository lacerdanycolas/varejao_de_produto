package dados;

import negocio.entities.Item_Pedido;

public class Item_PedidoRepository extends Repository<Item_Pedido, Integer>{
	public static Item_PedidoRepository instance;
	
	public static Item_PedidoRepository getInstance(){
		if(instance==null){
			instance=new Item_PedidoRepository();
		}
		return instance;
	}
	private Item_PedidoRepository(){
		
	}

}
