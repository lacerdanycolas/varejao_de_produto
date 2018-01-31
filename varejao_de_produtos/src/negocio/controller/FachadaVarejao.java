package negocio.controller;

import java.util.Collection;

import dados.CaixaRepository;
import dados.ProdutorefRepository;
import negocio.entities.Caixa;
import negocio.entities.Produtoref;

public class FachadaVarejao {

	private ControladorCaixa caixas;
	private ControladorProduto produtos;

	private static FachadaVarejao instance;

	private FachadaVarejao(){
		this.caixas = new ControladorCaixa(CaixaRepository.getInstance());
		this.produtos = new ControladorProduto(ProdutorefRepository.getInstance());
	}

	public static FachadaVarejao getInstance(){
		if(instance == null){
			instance = new FachadaVarejao();
		}
		return instance;
	}

	//BUSCAR
	public Caixa buscarCaixa(int id) throws Exception{
		return this.caixas.buscarCaixa(id);
	}

	//LISTAR
	public Collection<Caixa> listarCaixa() throws Exception{
		return this.caixas.listarCaixa();
	}

	//SALVAR
	public void salvarCaixa(Caixa caixa) throws Exception{
		this.caixas.salvarCaixa(caixa);
	}

	//DELETAR
	public void deletarCaixa(Caixa caixa) throws Exception{
		this.caixas.deletarCaixa(caixa);
	}

//PRODUTOS
	//BUSCAR
	public Produtoref buscarProduto(int id) throws Exception{
		return this.produtos.buscarProduto(id);
	}

	//LISTAR
	public Collection<Produtoref> listarProduto() throws Exception{
		return this.produtos.listarProduto();
	}

	//SALVAR
	public void salvarProduto(Produtoref produto) throws Exception{
		this.produtos.salvarProduto(produto);
	}

	//DELETAR
	public void deletarProduto(Produtoref produto) throws Exception{
		this.produtos.deletarProduto(produto);
	}


}
