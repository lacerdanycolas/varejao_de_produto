package negocio.controller;

import java.util.Collection;
import dados.ProdutorefRepository;
import exceptions.FormatacaoInvalidaException;
import negocio.entities.Produtoref;

public class ControladorProduto {
		private static ControladorProduto instance;
		private ProdutorefRepository repositorio;
		
		public static ControladorProduto getInstance(){
			if(instance == null){
				instance = new ControladorProduto();
			}
			return instance;
		}
		
		public ControladorProduto() {
			this.repositorio = ProdutorefRepository.getInstance();
		}
		
		public Produtoref buscarProduto(int id) throws Exception{
			if(id > 0) {
				return repositorio.getOne(id);
			}
			return null;
		}
		
		public Collection<Produtoref> listarProduto() throws Exception {
			return repositorio.getAll();
		}
		
		public Produtoref salvarProduto(Produtoref produto) throws Exception {
			if (produto.equals(null)) {
				throw new IllegalArgumentException();
			} else {
				return repositorio.save(produto);
			}
		}
		
		public void deletarProduto(Produtoref produto) throws Exception {
			if(produto.equals(null)) {
				throw new IllegalArgumentException();
			} else if (repositorio.getOne(produto.getId()).equals(null)) {
				throw new Exception("Produto nao existe");
			} else {
				repositorio.delete(produto);
			}
		}
		
		public void alterarProduto(Produtoref novoProduto) throws Exception {
			if(novoProduto == null){
				throw new FormatacaoInvalidaException();
			}else{
				this.repositorio.update(novoProduto);
			}
		}
}
