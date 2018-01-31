package negocio.controller;

import java.util.Collection;

import dados.FuncionarioRepository;
import dados.FuncionarioRepository;
import exceptions.FormatacaoInvalidaException;
import negocio.entities.Funcionario;

public class ControladorFuncionario {
	
	private FuncionarioRepository repositorio;
	
	public ControladorFuncionario (FuncionarioRepository rep) {
		this.repositorio=rep;
	}
	
	public Funcionario BuscarFuncionario (int id) throws Exception, FuncionarioNaoExiste {
		Funcionario fun = null;
		
		if(id> 0) {
			fun= repositorio.getOne(id);
			if(fun==null) {
				
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
	
	public Funcionario CadastrarFuncionario(Funcionario Func) throws Exception {
		if(Func.equals(null)) {
			throw new IllegalArgumentException("Preencha os campos");
		}else {
			return repositorio.save(Func);
		}
	}
	
	public void DeletarFuncionario (Funcionario Func) throws Exception {
		if(Func.equals(null)) {
			throw new IllegalArgumentException();
		}else if(repositorio.getOne(Func.getId()).equals(null))
			throw new Exception("Funcionario não existe");
		else
			repositorio.delete(Func);
	}
}

	private FuncionarioRepository repositorioFuncionario;
	
	public ControladorFuncionario(FuncionarioRepository rep){
		if(rep!=null){
			this.repositorioFuncionario = rep;
		}else{
			IllegalArgumentException x = new IllegalArgumentException("Repositorio invalido.");
			throw x;
		}
	}
	
	public Funcionario buscarFuncionario(Integer id) throws Exception{
		if(id>0){
			return repositorioFuncionario.getOne(id);
		}else{
			IllegalArgumentException x = new IllegalArgumentException("Repositorio invalido.");
			throw x;
		}
	}
	
	public Collection<Funcionario> listarFuncionario() throws Exception {
		return repositorioFuncionario.getAll();
	}
	
	public Funcionario salvarFuncionario (Funcionario funcionario) throws Exception{
		if(funcionario == null){
			throw new FormatacaoInvalidaException();
		}else
			return repositorioFuncionario.save(funcionario);
	}
	
	public void deletarFuncionario(Funcionario funcionario) throws Exception{
		if(funcionario == null){
			throw new FormatacaoInvalidaException();
		}
		else if(repositorioFuncionario.getOne(funcionario.getId())==null){
			throw new Exception("Funcionario no existe");
		}else
			repositorioFuncionario.delete(funcionario);
	}
	
	public boolean efetuarLogin(String login, String senha) throws Exception {
		if(login != null && !login.equals("") && senha !=  null && !senha.equals("")){
			Collection<Funcionario> listaFuncionario =repositorioFuncionario.getAll();
			Funcionario funcionario = new Funcionario();
			for (Funcionario func : listaFuncionario) {
				if(func.getSenha().equals(senha)){
					funcionario = this.buscarFuncionario(func.getId());
				}
			}
			if(funcionario != null){
				if(funcionario.getSenha().equals(senha) && funcionario.getLogin().equals(login)){
					return true;
				}
			}
		}
		return false;
	}
	
}

