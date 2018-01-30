package negocio.controller;

import java.util.Collection;

import dados.CaixaRepository;
import dados.FornecedorrefRepository;
import negocio.entities.Caixa;
import negocio.entities.Fornecedorref;

public class FachadaVarejao {

	private ControladorCaixa caixas;
	private ControladorFornecedorref fornecedores;

	private static FachadaVarejao instance;

	private FachadaVarejao(){
		this.caixas = new ControladorCaixa(CaixaRepository.getInstance());
		this.fornecedores = new ControladorFornecedorref(FornecedorrefRepository.getInstance());
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

	public Fornecedorref buscarFornecedor(int id) throws Exception{
		return this.fornecedores.buscarFornecedor(id);
	}


	//LISTAR
	public Collection<Caixa> listarCaixa() throws Exception{
		return this.caixas.listarCaixa();
	}

	public Collection<Fornecedorref> listarFornecedores() throws Exception{
		return this.fornecedores.listarFornecedor();
	}

	//SALVAR
	public void salvarCaixa(Caixa caixa) throws Exception{
		this.caixas.salvarCaixa(caixa);
	}

	public void salvarFornecedor(Fornecedorref fornecedor) throws Exception{
		this.fornecedores.salvarFornecedor(fornecedor);
	}

	//DELETAR
	public void deletarCaixa(Caixa caixa) throws Exception{
		this.caixas.deletarCaixa(caixa);
	}

	public void deletarFornecedor(Fornecedorref fornecedor) throws Exception{
		this.fornecedores.deletarFornecedor(fornecedor);
	}


}
