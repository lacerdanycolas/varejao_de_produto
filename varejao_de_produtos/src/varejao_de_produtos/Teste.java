package varejao_de_produtos;

import java.sql.SQLException;

import dados.RepositorioCaixa;
import negocio.Caixa;

public class Teste {
	public static void main(String[] args) {

		try {
			RepositorioCaixa rep = new RepositorioCaixa(ConnectionMySQL.getConnection());
			Caixa caixa = rep.find(8);
			System.out.println(caixa.toString());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
