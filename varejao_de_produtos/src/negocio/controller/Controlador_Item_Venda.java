package negocio.controller;

import java.util.Collection;

import dados.Item_Venda_Repository;
import negocio.entities.Item_Venda;

public class Controlador_Item_Venda {
	
	private static Controlador_Item_Venda instance;
	private Item_Venda_Repository repositorio;
	public static Controlador_Item_Venda getInstance(){
		if(instance==null){
			instance = new Controlador_Item_Venda();
		}
		return instance;
	}
	
	public Controlador_Item_Venda() {
		this.repositorio= Item_Venda_Repository.getInstance();
	}
	
	public Item_Venda Buscar_Itens_Venda(int id) throws Exception {
		Item_Venda item=null;
		if(id>0) {
			item=repositorio.getOne(id);
		}else {
			throw new IllegalArgumentException("Id inv�lido");
		}
		
		return item;
	}

	
	public Collection<Item_Venda> Listar_Itens_Venda() throws Exception{
		return repositorio.getAll();
	}
	
	public void CadastrarItem_Venda(Item_Venda item) throws Exception {
		if(item.equals(null)) {
			throw new IllegalArgumentException("dados invalidos");
		}else {
			repositorio.save(item);
		}
	}
	
	public void Deletar_Item_Venda (Item_Venda item) throws Exception {
		if(item.equals(null)) {
			throw new IllegalArgumentException();
		}else if(repositorio.getOne(item.getId()).equals(null)) {
			throw new IllegalArgumentException("item inexistente");
		}else {
			repositorio.delete(item);
		}
		
	}
}
