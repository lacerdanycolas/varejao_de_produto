package exceptions;

public class FuncionarioNaoExiste extends Exception  {

private int Id;

  public FuncionarioNaoExiste (int id) {
		super("Nao existe nenhum funcionario com o id '" + id + "'.");
		this.Id = id;
	}

	public int getId() {
		return Id;
	}

}
