package server.server.interfaces;

import java.util.List;

public interface CrudDao<T> {
	
	public boolean insert(Crud date);
	
	public boolean update(Crud date);
	
	public boolean delete(Crud date);
	
	public Crud findById(Crud date);
	
	public List<T> findAll();
}
