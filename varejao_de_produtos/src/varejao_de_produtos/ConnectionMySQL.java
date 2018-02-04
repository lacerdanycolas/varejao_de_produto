package varejao_de_produtos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import negocio.entities.Tipo_Funcionario;

public class ConnectionMySQL {

	private static int currentUser = Tipo_Funcionario.COORDENADOR.getId();
	private static Connection conexao;
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/varejao_de_fraldas";

	private static String OPERADOR_CAIXA = "operador_caixa";
	private static String SENHA_OPERADOR_CAIXA = "op_caixa";

	private static String SUPERVISOR_CAIXA = "supervisor_caixa";
	private static String SENHA_SUPERVISOR_CAIXA = "caixa";

	private static String SUPERVISOR_ESTOQUE = "supervisor_estoque";
	private static String SENHA_SUPERVISOR_ESTOQUE = "estoque";

	private static String COORDENADOR = "root";
	private static String SENHA_COORDENADOR = "";

	public static void setUser(int i){
		try {
			Class.forName(driver);
			if(i == currentUser){
				if(conexao == null){
					conexao = DriverManager.getConnection(url,COORDENADOR,SENHA_COORDENADOR);
				}
			}else{
				switch (i){
				case 1:
					conexao = DriverManager.getConnection(url,OPERADOR_CAIXA,SENHA_OPERADOR_CAIXA);
					break;
				case 2:
					conexao = DriverManager.getConnection(url,SUPERVISOR_CAIXA,SENHA_SUPERVISOR_CAIXA);
					break;
				case 3:
					conexao = DriverManager.getConnection(url,COORDENADOR,SENHA_COORDENADOR);
					break;
				case 5:
					conexao = DriverManager.getConnection(url,SUPERVISOR_ESTOQUE,SENHA_SUPERVISOR_ESTOQUE);
					break;
				default:
					System.out.println("Usuario Selecionado está inválido");
				}
			}
		} catch (SQLException e1){
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}


	public static Connection getConnection()throws SQLException{
		setUser(currentUser);
/*		conexao.setAutoCommit(false);
*/		return conexao;
 	}


}
