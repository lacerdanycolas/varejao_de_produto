package varejao_de_produtos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import dados.RepositorioCaixa;

public class ConnectionMySQL {
	public static void main(String[] args) {



	}
	
	/*private Connection conn;
	
	public ConnectionMySQL(){
		this.conn = null;
		try{
		   String driver = "com.mysql.jdbc.Driver";
		   String url = "jdbc:mysql://localhost:3306/varejao_de_fraldas";
		   String username = "root";
		   String password = "fish1997";
		   Class.forName(driver);

		  conn = DriverManager.getConnection(url,username,password);


		  } catch(Exception e){
			  System.out.println(e);
			}
	}
*/	public static Connection getConnection()throws SQLException{
		Connection conn = null;
		try{
		   String driver = "com.mysql.jdbc.Driver";
		   String url = "jdbc:mysql://localhost:3306/varejao_de_fraldas";
		   String username = "root";
		   String password = "fish1997";
		   Class.forName(driver);

		  conn = DriverManager.getConnection(url,username,password);


		  } catch(Exception e){System.out.println(e);}


		  return conn;
		 }


}
