package dados;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Collection;

import varejao_de_produtos.ConnectionMySQL;

public class Repository<T, TId> implements IRepository<T, TId>{
	
	@Override
	public T getOne(TId id_entity) throws Exception {
		
		return null;
	}

	@Override
	public Collection<T> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
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
		//System.out.println(entity.toString());
		return entity;
	}

	@Override
	public T update(T entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(TId id_entity) throws Exception {
		
		
	}

}
