package negocio.controller;

import java.util.Collection;

import Excecoes.FuncionarioNaoExiste;
import dados.FuncionarioRepository;
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


