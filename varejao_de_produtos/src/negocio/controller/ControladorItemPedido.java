package negocio.controller;

import java.util.Collection;

import dados.Item_PedidoRepository;
import exceptions.FormatacaoInvalidaException;
import negocio.entities.Item_Pedido;

public class ControladorItemPedido {
		private static ControladorItemPedido instance;
		private Item_PedidoRepository repositorio;

		public static ControladorItemPedido getInstance(){
			if(instance == null){
				instance = new ControladorItemPedido();
			}
			return instance;
		}

		public ControladorItemPedido() {
			this.repositorio = Item_PedidoRepository.getInstance();
		}

		public Item_Pedido buscarItemPedido(int id) throws Exception{
			if(id > 0) {
				return repositorio.getOne(id);
			}
			return null;
		}

		public Collection<Item_Pedido> listarItemPedido() throws Exception {
			return repositorio.getAll();
		}

		public Item_Pedido salvarItemPedido(Item_Pedido itemPedido) throws Exception {
			if (itemPedido.equals(null)) {
				throw new IllegalArgumentException();
			} else {
				return repositorio.save(itemPedido);
			}
		}

		public void deletarItemPedido(Item_Pedido itemPedido) throws Exception {
			if(itemPedido.equals(null)) {
				throw new IllegalArgumentException();
			} else if (repositorio.getOne(itemPedido.getId()).equals(null)) {
				throw new Exception("ItemPedido nao existe");
			} else {
				repositorio.delete(itemPedido);
			}
		}

		public void alterarItemPedido(Item_Pedido novoItemPedido) throws Exception {
			if(novoItemPedido == null){
				throw new FormatacaoInvalidaException();
			}else{
				this.repositorio.update(novoItemPedido);
			}
		}
}
