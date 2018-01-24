package dados;

import negocio.entities.Funcionario;

public class FuncionarioRepository extends Repository <Funcionario, Integer> {
	public static FuncionarioRepository instance;
	
	public static FuncionarioRepository getInstance(){
		if(instance==null){
			instance = new FuncionarioRepository();
		}
		return instance;
	}
	
	private FuncionarioRepository(){
		
	}

}
