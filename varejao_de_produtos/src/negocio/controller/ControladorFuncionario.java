package negocio.controller;

import java.util.Collection;

import dados.FuncionarioRepository;
import exceptions.FuncionarioNaoExiste;
import negocio.entities.Funcionario;
import varejao_de_produtos.ConnectionMySQL;

public class ControladorFuncionario {

	private static ControladorFuncionario instance;
	private FuncionarioRepository repositorio;
	public static ControladorFuncionario getInstance(){
		if(instance == null){
			instance = new ControladorFuncionario();
		}
		return instance;
	}
	
	
	private ControladorFuncionario () {
		this.repositorio = FuncionarioRepository.getInstance();
	}

	public Funcionario buscarFuncionario (int id) throws Exception,FuncionarioNaoExiste{

		Funcionario fun = null;

		if(id> 0) {
			fun= repositorio.getOne(id);
			ConnectionMySQL.getConnection().commit();
			if(fun==null){

				throw new FuncionarioNaoExiste(id);
			}
		}else {
			throw new IllegalArgumentException("Id Invalido");
		}

		return fun;
	}


	public Collection<Funcionario> listarFuncionarios() throws Exception{
		return repositorio.getAll();
	}

	public Funcionario cadastrarFuncionario(Funcionario Func) throws Exception {
		if(Func.equals(null)) {
			throw new IllegalArgumentException("Preencha os campos");
		}else {
			return repositorio.save(Func);
		}
	}

	public void deletarFuncionario (Funcionario Func) throws Exception {
		if(Func.equals(null)) {
			throw new IllegalArgumentException();
		}else if(repositorio.getOne(Func.getId()).equals(null))
			throw new Exception("Funcionario n�o existe");
		else
			repositorio.delete(Func);
	}
	
	public boolean efetuarLogin(String login, String senha) throws Exception{
		Funcionario retorno = null;
		for(Funcionario f: this.listarFuncionarios()){
			if(f.getLogin().equals(login) && f.getSenha().equals(senha)){
				retorno = f;
				break;
			}
		}
		if(retorno != null){
			ConnectionMySQL.setUser(retorno.getTipo().getId());
			return true;
		}else{
			return false;
		}
	}


}

