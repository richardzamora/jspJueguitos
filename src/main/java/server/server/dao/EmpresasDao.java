package server.server.dao;

import server.server.dto.EmpresasDto;

public class EmpresasDao<T> extends GenericDao<EmpresasDto> {

	public EmpresasDao() {
		super(EmpresasDto.class);
	}
	
}
