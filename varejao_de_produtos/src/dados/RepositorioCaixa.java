package dados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import negocio.entities.Caixa;
import negocio.entities.Preferencial_Caixa;
import negocio.entities.Situacao_Caixa;


public class RepositorioCaixa {// implements IRepositorioCaixa {
	//setando tipo enum caixa.setSexo(Enum.valueOf(Sexo.class, query.getString("Sexo")))

	/*private static RepositorioC/*aixa instance;
	
	private final Connection connection;
    public RepositorioCaixa(Connection connection)
    {
       this.connection = connection;
    }
    
    public static RepositorioCaixa getInstance(){
    	if(instance==null){
    		instance = new RepositorioCaixa(); 
    	}
    }


     (non-Javadoc)
	 * @see dados.IRepositorioCaixa#add(negocio.Caixa)
	 
    @Override
	public void add(Caixa caixa) throws SQLException
    {
        String sql = "INSERT INTO caixa(descricao,situacao,e_preferencial,observacao,id_matriz,sequencial_filial) VALUES(?,?,?,?,?,?);";
        PreparedStatement st = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
       st.setString(1, caixa.getDescricao());
        st.setString(2, caixa.getSituacao().name());
        st.setString(3, caixa.getE_preferencial().name());
        st.setString(4,caixa.getObservacao());
       st.setInt(5, caixa.getId_matriz());
       st.setInt(6, caixa.getSeq_filial());
        st.executeUpdate();

        ResultSet key = st.getGeneratedKeys();

        if (key.next())
            caixa.setId(key.getInt(1));


    }
     (non-Javadoc)
	 * @see dados.IRepositorioCaixa#edit(negocio.Caixa)
	 
    @Override
	public boolean edit(Caixa caixa) throws SQLException
    {
        String sql = "UPDATE caixa SET descricao=?, situacao=?, e_preferencial=?, observacao=?, id_matriz=?, sequencial_filial=?  where id=?";
        PreparedStatement st = this.connection.prepareStatement(sql);
        st.setString(1, caixa.getDescricao());
        st.setString(2, caixa.getSituacao().name());
        st.setString(3, caixa.getE_preferencial().name());
        st.setString(4,caixa.getObservacao());
       st.setInt(5, caixa.getId_matriz());
       st.setInt(6, caixa.getSeq_filial());
        st.setInt(7, caixa.getId());
        return st.execute();
    }
     (non-Javadoc)
	 * @see dados.IRepositorioCaixa#find(int)
	 
    @Override
	public Caixa find(int id) throws SQLException
    {
        Caixa caixa = null;
        String sql = "SELECT * FROM caixa where id=?";
        PreparedStatement st = this.connection.prepareStatement(sql);
        st.setInt(1, id);
        ResultSet query = st.executeQuery();
        if (query.next())
        {
            caixa = new Caixa();
            caixa.setId(query.getInt("id"));
            caixa.setDescricao(query.getString("descricao"));
            caixa.setSituacao(Enum.valueOf(situacao_caixa.class, query.getString("situacao")));
            caixa.setE_preferencial(Enum.valueOf(preferencial_caixa.class, query.getString("e_preferencial")));
            caixa.setObservacao(query.getString("observacao"));
            caixa.setId_matriz(query.getInt("id_matriz"));
            caixa.setSeq_filial(query.getInt("sequencial_filial"));
        }
        return caixa;
    }
     (non-Javadoc)
	 * @see dados.IRepositorioCaixa#all()
	 
    @Override
	/*public ArrayList<Caixa> all() throws SQLException
    {
        ArrayList<Caixa> listacaixa = new ArrayList<Caixa>();
        String sql = "SELECT * FROM caixa ORDER BY id";
        PreparedStatement st = this.connection.prepareStatement(sql);
        ResultSet query = st.executeQuery();
       Caixa caixa = null;
        while (query.next())
      *//*  {
          caixa = new Caixa();
            caixa.setId(query.getInt("id"));
            caixa.setDescricao(query.getString("descricao"));
            caixa.setSituacao(Enum.valueOf(situacao_caixa.class, query.getString("situacao")));
            caixa.setE_preferencial(Enum.valueOf(preferencial_caixa.class, query.getString("e_preferencial")));
            caixa.setObservacao(query.getString("observacao"));
            caixa.setId_matriz(query.getInt("id_matriz"));
        //    caixa.setSeq_filial(query.getInt("sequencial_filial"));
        //    listacaixa.add(caixa);
        }*/
//        return listacaixa;
//    }

}
