package server.server.dao;

import server.server.dto.UsuarioDto;

public class UsuarioDao<T> extends GenericDao<UsuarioDto> {

	public UsuarioDao() {
		super(UsuarioDto.class);
	}
	
}
