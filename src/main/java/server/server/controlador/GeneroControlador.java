package server.server.controlador;

import server.server.dao.GeneroDao;
import server.server.dto.GeneroDto;
import server.server.estructura.stack.IStackArray;

public class GeneroControlador<T> {
	
	private GeneroDao<T> dao;
	
	public GeneroControlador() {
		dao = new GeneroDao<T>();
	}
	
	public boolean insert(int id, String name) {
		GeneroDto date = new GeneroDto( id, name);
		return dao.insert(date);
	}
	
	public boolean update(int id, String name) {
		GeneroDto date = new GeneroDto( id, name);
		return dao.update(date);
	}
	
	public boolean delete(int id) {
		GeneroDto date = new GeneroDto();
		date.setId(id);
		return dao.delete(date);
	}
	
	public GeneroDto findById(int id){
		GeneroDto date = new GeneroDto();
		date.setId(id);
		return (GeneroDto) dao.findById(date);
	}
	
	public IStackArray<GeneroDto>findAll()
	{
		GeneroDto date = new GeneroDto();
		return dao.findAll(date);
	}

}
