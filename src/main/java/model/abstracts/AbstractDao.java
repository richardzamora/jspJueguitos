package model.abstracts;

import java.sql.SQLException;
import java.util.Collection;

import model.conexion.Conexion;
import model.interfaces.IDto;

public abstract class AbstractDao<T extends IDto> {
	
	protected Conexion con;
	
	public AbstractDao() {
		con = Conexion.getInstance();
	}
	
	public boolean insert(IDto dto) {
		return con.executeUpdate(dto.insert());
	}

	public boolean update(IDto dto) {
		return con.executeUpdate(dto.update());
	}

	public boolean delete(IDto dto) {
		return con.executeUpdate(dto.delete());
	}

	public abstract T getById(IDto dto) throws SQLException;

	public abstract Collection<T> getAll() throws SQLException;
}
