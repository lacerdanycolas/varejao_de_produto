package negocio.controller;

import java.util.Collection;
import dados.Pedido_FornecedorRepository;
import exceptions.FormatacaoInvalidaException;
import negocio.entities.Pedido_Fornecedor;

public class ControladorPedidoFornecedor {

		private static ControladorPedidoFornecedor instance;
		private Pedido_FornecedorRepository repositorio;

		public static ControladorPedidoFornecedor getInstance(){
			if(instance == null){
				instance = new ControladorPedidoFornecedor();
			}
			return instance;
		}

		public ControladorPedidoFornecedor() {
			this.repositorio = Pedido_FornecedorRepository.getInstance();
		}

		public Pedido_Fornecedor buscarPedidoFornecedor(int id) throws Exception{
			if(id > 0) {
				return repositorio.getOne(id);
			}
			return null;
		}

		public Collection<Pedido_Fornecedor> listarPedidoFornecedor() throws Exception {
			return repositorio.getAll();
		}

		public Pedido_Fornecedor salvarPedidoFornecedor(Pedido_Fornecedor pedido) throws Exception {
			if (pedido.equals(null)) {
				throw new IllegalArgumentException();
			} else {
				return repositorio.save(pedido);
			}
		}

		public void deletarPedidoFornecedor(Pedido_Fornecedor pedido) throws Exception {
			if(pedido.equals(null)) {
				throw new IllegalArgumentException();
			} else if (repositorio.getOne(pedido.getId()).equals(null)) {
				throw new Exception("pedido nao existe");
			} else {
				repositorio.delete(pedido);
			}
		}

		public void alterarPedidoFornecedor(Pedido_Fornecedor novoPedido) throws Exception {
			if(novoPedido == null){
				throw new FormatacaoInvalidaException();
			}else{
				this.repositorio.update(novoPedido);
			}
		}
}
