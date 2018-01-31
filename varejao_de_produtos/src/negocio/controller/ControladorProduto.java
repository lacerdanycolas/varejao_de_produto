package negocio.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import dados.ProdutorefRepository;
import negocio.entities.Produtoref;
import varejao_de_produtos.ConnectionMySQL;

public class ControladorProduto {
	private ProdutorefRepository rep;
		public ControladorProduto(ProdutorefRepository rep) {
			this.rep = rep;
		}
		
		public Produtoref buscarProduto(int id) throws Exception{
			if(id > 0) {
				return rep.getOne(id);
			}
			return null;
		}
		
		public Collection<Produtoref> listarProduto() throws Exception {
			return rep.getAll();
		}
		
		public Produtoref salvarProduto(Produtoref produto) throws Exception {
			if (produto.equals(null)) {
				throw new IllegalArgumentException();
			} else {
				return rep.save(produto);
			}
		}
		
		public void deletarProduto(Produtoref produto) throws Exception {
			if(produto.equals(null)) {
				throw new IllegalArgumentException();
			} else if (rep.getOne(produto.getId()).equals(null)) {
				throw new Exception("Produto nao existe");
			} else {
				rep.delete(produto);
			}
		}
}
