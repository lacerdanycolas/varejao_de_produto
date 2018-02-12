package negocio.controller;

import java.util.Collection;

import dados.Item_EstoqueRepository;
import exceptions.FormatacaoInvalidaException;
import negocio.entities.Item_Estoque;
import negocio.entities.Item_Pedido;

public class ControladorItemEstoque {
		private static ControladorItemEstoque instance;
		private Item_EstoqueRepository repositorio;

		public static ControladorItemEstoque getInstance(){
			if(instance == null){
				instance = new ControladorItemEstoque();
			}
			return instance;
		}

		public ControladorItemEstoque() {
			this.repositorio = Item_EstoqueRepository.getInstance();
		}

		public Item_Estoque buscarItemEstoque(int id) throws Exception{
			if(id > 0) {
				return repositorio.getOne(id);
			}
			return null;
		}

		public Collection<Item_Estoque> listarItemEstoque() throws Exception {
			return repositorio.getAll();
		}

		public Item_Estoque salvarItemEstoque(Item_Estoque itemEstoque) throws Exception {
			if (itemEstoque.equals(null)) {
				throw new IllegalArgumentException();
			} else {
				return repositorio.save(itemEstoque);
			}
		}

		public void deletarItemEstoque(Item_Estoque itemEstoque) throws Exception {
			if(itemEstoque.equals(null)) {
				throw new IllegalArgumentException();
			} else if (repositorio.getOne(itemEstoque.getId()).equals(null)) {
				throw new Exception("ItemEstoque nao existe");
			} else {
				repositorio.delete(itemEstoque);
			}
		}

		public void alterarItemEstoque(Item_Estoque novoItemEstoque) throws Exception {
			if(novoItemEstoque == null){
				throw new FormatacaoInvalidaException();
			}else{
				this.repositorio.update(novoItemEstoque);
			}
		}
}
