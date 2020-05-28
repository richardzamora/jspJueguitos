package server.server.dao;

import server.server.dto.GeneroDto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GeneroDao<T> extends GenericDao<GeneroDto> {

	public GeneroDao() {
		super(GeneroDto.class);
	}


}
