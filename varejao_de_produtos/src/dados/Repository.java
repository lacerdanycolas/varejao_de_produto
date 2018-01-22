package dados;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Collection;

import varejao_de_produtos.ConnectionMySQL;

public class Repository<T, TId> implements IRepository<T, TId>{
	
	@Override
	public T getOne(TId id_entity) throws Exception {

		return null;
	}

	@Override
	public Collection<T> getAll() throws Exception {
		Class<T> classe = (Class<T>) ((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments()[0];
		String minhaClasse = classe.getSimpleName();
		String query = "SELECT * FROM "+ minhaClasse;
		
		PreparedStatement st = ConnectionMySQL.getConnection().prepareStatement(query);
        ResultSet rs = st.executeQuery();
        ResultSetMetaData rsmt = rs.getMetaData();
        int count = rsmt.getColumnCount();
        Collection<T> retorno = new ArrayList<>(); 
        while(rs.next()){
        	T myInstance = classe.newInstance();
        	Field[] campos = classe.getDeclaredFields();
        	for(int i = 1; i <= count; i++){
        		String coluna = rsmt.getColumnName(i);
        		
        	}
        	retorno.add(myInstance);
        }
		return retorno;
	}

	@Override
	public T save(T entity) throws Exception {
		String className = entity.getClass().getSimpleName().toLowerCase();
		String query = "INSERT INTO "+ className +"(";
		int i = 0;
		String[] campos = new String[entity.getClass().getDeclaredFields().length]; 
		for(Field f : entity.getClass().getDeclaredFields()){
			if(i != (entity.getClass().getDeclaredFields().length-1)){
				query+= f.getName()+",";	
			}else{
				query+= f.getName();
			}
			System.out.println(campos.length);
			campos[i] = f.getName();
			i++;
		}
		query += ") values (";
		for(int j = 0; j <= entity.getClass().getDeclaredFields().length-1; j++){
			if(j != (entity.getClass().getDeclaredFields().length-1)){
				query+="?,";
			}else{
				query += "?";
			}
		}
		query += ");";
		PreparedStatement st = ConnectionMySQL.getConnection().prepareStatement(query);
		for(int k = 0; k <= entity.getClass().getDeclaredFields().length-1; k++){
			Field field = entity.getClass().getDeclaredField(campos[k]);
			field.setAccessible(true);

			Object value = field.get(entity);
			st.setObject(k+1, value);
		}
		st.execute();
		return entity;
	}

	@Override
	public T update(T entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(T entity) throws Exception {
		String className = entity.getClass().getSimpleName().toLowerCase();
		String query = "DELETE FROM "+ className +" WHERE ";
		String meu_id = "";
		int achouUm = 0;
		for(Field f : entity.getClass().getDeclaredFields()){
			//System.out.println(f.getName());
			if(f.isAnnotationPresent(MeuId.class)){
				//System.out.println("entrou" + f.toString());
				if(achouUm == 0){
					meu_id = f.getName();
					achouUm++;
				}else if(achouUm != 0){
					throw new Exception("Entidade com multiplos Ids");
				}
			}
		}
		query += meu_id+"=?;";
		PreparedStatement st = ConnectionMySQL.getConnection().prepareStatement(query);
		//System.out.println(query);
		Field field = entity.getClass().getDeclaredField(meu_id);
		field.setAccessible(true);

		Object value = field.get(entity);
		st.setObject(1, value);
		st.execute();
	}

}
