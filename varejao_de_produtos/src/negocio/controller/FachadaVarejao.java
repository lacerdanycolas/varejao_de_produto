package negocio.controller;

import java.util.Collection;

import dados.CaixaRepository;

import dados.FornecedorrefRepository;

import dados.FuncionarioRepository;

import negocio.entities.Caixa;

import negocio.entities.Fornecedorref;

import negocio.entities.Funcionario;


public class FachadaVarejao {

	private ControladorCaixa caixas;

	private ControladorFornecedorref fornecedores;


	private ControladorFuncionario funcionarios;


	private static FachadaVarejao instance;

	private FachadaVarejao(){
		this.caixas = new ControladorCaixa(CaixaRepository.getInstance());

		this.fornecedores = new ControladorFornecedorref(FornecedorrefRepository.getInstance());

		this.funcionarios = new ControladorFuncionario(FuncionarioRepository.getInstance());

	}

	public static FachadaVarejao getInstance(){
		if(instance == null){
			instance = new FachadaVarejao();
		}
		return instance;
	}

	//BUSCAR CAIXA
	public Caixa buscarCaixa(Integer id) throws Exception{
		return this.caixas.buscarCaixa(id);
	}

	public Fornecedorref buscarFornecedor(int id) throws Exception{
		return this.fornecedores.buscarFornecedor(id);
	}


	//LISTAR

	//LISTAR CAIXA

	public Collection<Caixa> listarCaixa() throws Exception{
		return this.caixas.listarCaixa();
	}

	public Collection<Fornecedorref> listarFornecedores() throws Exception{
		return this.fornecedores.listarFornecedor();
	}

	//SALVAR CAIXA
	public void salvarCaixa(Caixa caixa) throws Exception{
		this.caixas.salvarCaixa(caixa);
	}


	public void salvarFornecedor(Fornecedorref fornecedor) throws Exception{
		this.fornecedores.salvarFornecedor(fornecedor);
	}

	//DELETAR

	//DELETAR CAIXA

	public void deletarCaixa(Caixa caixa) throws Exception{
		this.caixas.deletarCaixa(caixa);
	}

	//BUSCAR FUNCIONARIO
	public Funcionario buscarFuncionario (Integer id) throws Exception{
		return this.funcionarios.buscarFuncionario(id);
	}

	//LISTAR FUNCIONARIO
	public Collection<Funcionario> listarFuncionario() throws Exception{
		return this.funcionarios.listarFuncionario();
	}

	//SALVAR FUNCIONARIO
	public void salvarFuncionario(Funcionario funcionario) throws Exception{
		this.funcionarios.salvarFuncionario(funcionario);
	}

	//DELETAR FUNCIONARIO
	public void deletarFuncionario(Funcionario funcionario) throws Exception{
		this.funcionarios.deletarFuncionario(funcionario);
	}

	//LOGIN FUNCIONARIO
	public boolean efetuarLoginFuncionario(String login, String senha) throws Exception{
		if(this.funcionarios.efetuarLogin(login, senha) == true){
			return true;
		}else{
			return false;
		}
	}


	public void deletarFornecedor(Fornecedorref fornecedor) throws Exception{
		this.fornecedores.deletarFornecedor(fornecedor);
	}


}
