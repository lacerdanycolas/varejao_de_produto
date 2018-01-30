package Excecoes;

public class FuncionarioNaoExiste extends Exception  {
	
	private String cpf;
	
  public FuncionarioNaoExiste (String cpf) {
		super("Não existe nenhum dependente com o cpf '" + cpf + "'.");
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

}
