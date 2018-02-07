package dados;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.MySQLConnection;

import varejao_de_produtos.ConnectionMySQL;

public class FuncoesRepository {
	
	public static void AtualizaQtdEstoque(int idproduto, int quant) {
		
		String query = "{ call AtualizaQtdEstoque (?,?) }";
        ResultSet rs;
        
        try {
       CallableStatement stmt = (CallableStatement) ConnectionMySQL.getConnection().prepareCall(query);
 
            stmt.setInt(1, idproduto);
            stmt.setInt(2, quant);
 
            rs = stmt.executeQuery();
  
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
	}
	public static void TotalEstoqueAtualiza(int idproduto) {
		
		String query = "{ call TotalEstoqueAtualiza (?) }";
        ResultSet rs;
        
        try {
       CallableStatement stmt = (CallableStatement) ConnectionMySQL.getConnection().prepareCall(query);
 
            stmt.setInt(1, idproduto);
 
            rs = stmt.executeQuery();
  
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
	}
	
	public static int QtdEstoque(int idproduto, int quant) {
		String query = "select QtdEstoque (?,?)";
        ResultSet rs;
        int res = 0;
        
        try {
       PreparedStatement stmt = ConnectionMySQL.getConnection().prepareCall(query);
       		
       
            stmt.setInt(1, idproduto);
            stmt.setInt(2, quant);
 
            rs = stmt.executeQuery();
            
            while(rs.next()) {
            	 res=rs.getInt(1);
                 
            }
           
  
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return res;
	}
	 public static void main(String[] args) {
	       //AtualizaQtdEstoque(1, 10);
		 
		 int resultado= QtdEstoque(1, 20);
		 System.out.println(resultado);
	    }
	

}
