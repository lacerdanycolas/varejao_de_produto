package dados;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
		Class<T> classe = (Class<T>) ((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments()[0];
		String minhaClasse = classe.getSimpleName();
		String query = "SELECT * FROM "+ minhaClasse.toLowerCase() + " WHERE ";
		String meu_id = "";
		int achouUm = 0;
		for(Field f : classe.getDeclaredFields()){
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
		System.out.println(query);
		PreparedStatement st = ConnectionMySQL.getConnection().prepareStatement(query);
		st.setObject(1, id_entity);
		System.out.println(id_entity);
        ResultSet rs = st.executeQuery();
        ResultSetMetaData rsmt = rs.getMetaData();
        int count = rsmt.getColumnCount();
        Constructor<?> constructor = classe.getConstructor(); // recupera o construtor default da classe passada para o repositorio
    	Object instance = constructor.newInstance(); // cria uma nova instancia da classe que está sendo passada como parametro
        while(rs.next()){
        	Field[] campos = classe.getDeclaredFields(); //lista os campos da classe passada como paramentro no repositorio
        	for(int i = 0; i <= campos.length-1; i++){ // intero sobre a lista de campos da entidade 
        		for(int k = 1; k <= count; k++){ // intero sobre as colunas do result set
        			String coluna = rsmt.getColumnName(k); // recupero o nome da coluna atual 
        			if(campos[i].getName().equals(coluna)){ // verifica se o nome da coluna é igual ao nome do atributo da classe
        				Object valor = rs.getObject(k); // recupera o valor da coluna caso o nome dela seja igual ao nome do parametro
        				Field fd = instance.getClass().getDeclaredField(campos[i].getName()); 
            			if(fd.getType().isEnum()){
            				fd.setAccessible(true);
                			fd.set(instance, Enum.valueOf((Class<Enum>) fd.getType(), valor.toString()));
            			}else{
            				fd.setAccessible(true);
                			fd.set(instance, valor);	
            			}
            			break;
            		}  
        		}
        	}
        }
		return (T) instance;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
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
        	Constructor<?> constructor = classe.getConstructor(); // recupera o construtor default da classe passada para o repositorio
        	Object instance = constructor.newInstance(); // cria uma nova instancia da classe que está sendo passada como parametro
        	Field[] campos = classe.getDeclaredFields(); //lista os campos da classe passada como paramentro no repositorio
        	for(int i = 0; i <= campos.length-1; i++){ // intero sobre a lista de campos da entidade 
        		for(int k = 1; k <= count; k++){ // intero sobre as colunas do result set
        			String coluna = rsmt.getColumnName(k); // recupero o nome da coluna atual 
        			if(campos[i].getName().equals(coluna)){ // verifica se o nome da coluna é igual ao nome do atributo da classe
        				Object valor = rs.getObject(k); // recupera o valor da coluna caso o nome dela seja igual ao nome do parametro
            			Field fd = instance.getClass().getDeclaredField(campos[i].getName()); 
            			if(fd.getType().isEnum()){
            				/*Constructor<?> enumeravel = fd.getType().getConstructor(Integer.class);*/
            				/*Object meu_enum = enumeravel.newInstance(Enum.valueOf(fd.getType().getClass(), valor));*/
            				fd.setAccessible(true);
                			fd.set(instance, Enum.valueOf((Class<Enum>) fd.getType(), valor.toString()));
            			}else{
            				fd.setAccessible(true);
                			fd.set(instance, valor);	
            			}
            			break;
            		}  
        		}
        	}
        	retorno.add((T)instance);
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
			if(field.getType().isEnum()){
				/*System.out.println(field.getName() + " -> Entrou no If");
				System.out.print(field.getClass().getSimpleName());	
				*/
				Method method = field.getType().getDeclaredMethod("getId");
			    Integer val = (Integer) method.invoke(field.get(entity));
			    st.setObject(k+1, val);
			}else{
				System.out.println(field.getName() + " -> Entrou no Else");
				Object value = field.get(entity);
				st.setObject(k+1, value);
			}
		}
		st.execute();
		return entity;
	}

	@Override
	public T update(T entity) throws Exception {
		String className = entity.getClass().getSimpleName().toLowerCase();
		String query = "UPDATE "+ className +" SET ";
		String meu_id = "";
		int i = 0;
		int achouUm = 0;
		for(Field f : entity.getClass().getDeclaredFields()){
			if(f.isAnnotationPresent(MeuId.class)){
				if(achouUm == 0){
					meu_id = f.getName();
					achouUm++;
				}else if(achouUm != 0){
					throw new Exception("Entidade com multiplos Ids");
				}
			}
		}
		i = 0;
		String[] campos = new String[entity.getClass().getDeclaredFields().length-1]; 
		for(Field f : entity.getClass().getDeclaredFields()){
			if(!f.isAnnotationPresent(MeuId.class)){
				System.out.println(i);
				campos[i] = f.getName();
				i++;
			}
		}
		query += "";
		System.out.println(entity.getClass().getDeclaredFields().length);
		for(int j = 0; j <= campos.length-1; j++){
			/*System.out.println(j);*/
			query += campos[j].toString()+"=? ";
		}
		query += "WHERE "+meu_id+"=?;";
		System.out.println(query);
		PreparedStatement st = ConnectionMySQL.getConnection().prepareStatement(query);
		for(int k = 0; k <= campos.length-1; k++){
			Field field = entity.getClass().getDeclaredField(campos[k]);
			field.setAccessible(true);
			if(field.getType().isEnum()){
				Method method = field.getType().getDeclaredMethod("getId");
			    Integer val = (Integer) method.invoke(field.get(entity));
			    st.setObject(k+1, val);
			}else{
				Object value = field.get(entity);
				st.setObject(k+1, value);
			}
		}
		Field field = entity.getClass().getDeclaredField(meu_id);
		field.setAccessible(true);
		Object value = field.get(entity);
	
		if(value == null) {
			throw new Exception("Id da entidade não pode ser nulo, nego burro");
			}
		System.out.println("ID "+value.toString());
		st.setObject(campos.length+1, value);
		System.out.println(st);
		st.execute();
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
