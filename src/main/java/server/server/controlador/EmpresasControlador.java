package server.server.controlador;

import server.server.dao.EmpresasDao;
import server.server.dto.EmpresasDto;
import server.server.estructura.stack.IStackArray;

public class EmpresasControlador<T> {
	
	private EmpresasDao<T> dao;
	
	public EmpresasControlador() {
		dao = new EmpresasDao<T>();
	}

	public boolean insert(String name) {
		EmpresasDto date = new EmpresasDto();
		date.setName(name);
		return dao.insert(date);
	}
	
	public boolean update(int id, String name) {
		EmpresasDto date = new EmpresasDto( id, name);
		return dao.update(date);
	}
	
	public boolean delete(int id) {
		EmpresasDto date = new EmpresasDto();
		date.setId(id);
		return dao.delete(date);
	}
	
	public EmpresasDto findById(int id){
		EmpresasDto date = new EmpresasDto();
		date.setId(id);
		return (EmpresasDto) dao.findById(date);
	}
	
	public IStackArray<EmpresasDto>findAll()
	{
		EmpresasDto date = new EmpresasDto();
		return dao.findAll(date);
	}
}
