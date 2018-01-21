package varejao_de_produtos;

import java.sql.SQLException;

import dados.RepositorioCaixa;
import negocio.Caixa;
import negocio.preferencial_caixa;
import negocio.situacao_caixa;

public class Teste {

	public static void main(String[] args) {

		try {
			RepositorioCaixa rep = new RepositorioCaixa(ConnectionMySQL.getConnection());
			Caixa caixa = new Caixa();
			String str = null;
			caixa.setSituacao(situacao_caixa.ATIVO);
			caixa.setE_preferencial(preferencial_caixa.S);
			caixa.setId_matriz(1);
			caixa.setSeq_filial(18);
			caixa.setDescricao(str);
			caixa.setObservacao(str);

			rep.add(caixa);



		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
