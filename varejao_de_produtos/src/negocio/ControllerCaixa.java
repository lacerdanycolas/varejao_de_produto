package negocio;

import java.sql.SQLException;
import java.util.ArrayList;

import dados.IRepositorioCaixa;
import negocio.entities.Caixa;

public class ControllerCaixa {
 private IRepositorioCaixa rep;

public ControllerCaixa(IRepositorioCaixa rep) {
	this.rep = rep;
}

/*public void add(Caixa caixa) throws SQLException{
	if(caixa.equals(null))
		throw new IllegalArgumentException("Paramentro inv�lido");
	else
		this.rep.add(caixa);
}

public Caixa find(int id) throws SQLException{
	if(id < 0)
		throw new IllegalArgumentException("Paramentro inv�lido");
	else
		return this.rep.find(id);
}

public boolean edit (Caixa caixa) throws SQLException{
	if(caixa.equals(null))
		throw new IllegalArgumentException("Paramentro inv�lido");
	else
		return this.rep.edit(caixa);
}

public ArrayList<Caixa> all() throws SQLException{

	if(this.rep.all().isEmpty()){
		throw new IllegalArgumentException("Caixas nulos");
	}
	else
		return this.rep.all();

}

*/
}
