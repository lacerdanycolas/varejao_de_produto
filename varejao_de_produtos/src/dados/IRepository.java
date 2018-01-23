package dados;

import java.util.Collection;

public interface IRepository<T extends Object, TId extends Object> {

	T getOne(TId id_entity) throws Exception;
	Collection<T> getAll() throws Exception;
	T save(T entity) throws Exception;
	T update(T entity) throws Exception;
	void delete(TId id_entity) throws Exception;

}
