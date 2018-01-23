package varejao_de_produtos;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.MySQLConnection;

import dados.IRepositorioCaixa;
import dados.RepositorioCaixa;
import negocio.preferencial_caixa;
import negocio.situacao_caixa;
import negocio.entities.Caixa;

public class Teste {

/*	public static void main(String[] args) throws SQLException {
		Connection con = null;
		try {
			con = ConnectionMySQL.getConnection();

			//setando o autocommit para falso, pois s� commitar se tiver tudo correto
			con.setAutoCommit(false);

			IRepositorioCaixa rep = new RepositorioCaixa(con);
			Caixa caixa = new Caixa();
			String str = null;
			caixa.setSituacao(situacao_caixa.INATIVO);
			caixa.setE_preferencial(preferencial_caixa.S);
			caixa.setId_matriz(1);
			caixa.setSeq_filial(15);
			caixa.setDescricao(str);
			caixa.setObservacao(str);
			rep.add(caixa);

			//Se tudo estiver certo, commita
			con.commit();



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}catch(Exception e){
			con.rollback();
			System.out.println("Erro ao gravar dados");
		}
		finally{
			con.setAutoCommit(true);
			ConnectionMySQL.getConnection().close();
		}

	}

*/
}
