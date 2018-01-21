package dados;

import java.sql.SQLException;
import java.util.ArrayList;

import negocio.Caixa;

public interface IRepositorioCaixa {

	public abstract void add(Caixa caixa) throws SQLException;

	public abstract  boolean edit(Caixa caixa) throws SQLException;

	public abstract  Caixa find(int id) throws SQLException;

	public abstract  ArrayList<Caixa> all() throws SQLException;

}