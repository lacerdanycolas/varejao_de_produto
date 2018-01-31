package negocio.controller;

import java.util.Collection;

import dados.Item_Venda_Repository;
import negocio.beans.Item_Venda;

public class Controlador_Item_Venda {
	
	private Item_Venda_Repository repo;
	
	public Controlador_Item_Venda(Item_Venda_Repository rep) {
		this.repo=rep;
	}
	
	public Item_Venda Buscar_Itens_Venda(int id) throws Exception {
		Item_Venda item=null;
		if(id>0) {
			item=repo.getOne(id);
		}else {
			throw new IllegalArgumentException("Id inválido");
		}
		
		return item;
	}

	
	public Collection<Item_Venda> Listar_Itens_Venda() throws Exception{
		return repo.getAll();
	}
	
	public void CadastrarItem_Venda(Item_Venda item) throws Exception {
		if(item.equals(null)) {
			throw new IllegalArgumentException("dados invalidos");
		}else {
			repo.save(item);
		}
	}
	
	public void Deletar_Item_Venda (Item_Venda item) throws Exception {
		if(item.equals(null)) {
			throw new IllegalArgumentException();
		}else if(repo.getOne(item.getId()).equals(null)) {
			throw new IllegalArgumentException("item inexistente");
		}else {
			repo.delete(item);
		}
		
	}
}
