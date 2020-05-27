package server.server.dao;

import server.server.dto.JuegosDto;

public class JuegosDao<T> extends GenericDao<JuegosDto> {

	public JuegosDao() {
		super(JuegosDto.class);
	}
	
}
