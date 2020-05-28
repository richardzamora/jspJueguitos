package server.server.controlador;

import server.server.dao.UsuarioDao;
import server.server.dto.UsuarioDto;
import server.server.estructura.stack.IStackArray;

import java.sql.Date;

public class UsuarioControlador<T> {
	
	private UsuarioDao<T> dao;
	
	public UsuarioControlador() {
		dao = new UsuarioDao<T>();
	}
	
	public boolean insert(String name, String last_name, String nickname, String mail, String password, Date birthDate) {
		UsuarioDto date = new UsuarioDto( mail, last_name, nickname, mail, password, birthDate );
		return dao.insert(date);
	}

	public boolean autentication(String mail, String password)
	{
		UsuarioDto date = new UsuarioDto();
		date.setMail(mail);
		date.setPassword(password);
		return dao.getAutentication(date);
	}
	public boolean update(String name, String last_name, String nickname, String mail, String password, Date birthDate) {
		UsuarioDto date = new UsuarioDto( mail, last_name, nickname, mail, password, birthDate);
		return dao.update(date);
	}
	
	public boolean delete(String mail) {
		UsuarioDto date = new UsuarioDto();
		date.setMail(mail);
		return dao.delete(date);
	}
	
	public UsuarioDto findById(String mail){
		UsuarioDto date = new UsuarioDto();
		date.setMail(mail);
		return (UsuarioDto) dao.findById(date);
	}
	
	public IStackArray<UsuarioDto>findAll(String name)
	{
		UsuarioDto date = new UsuarioDto();
		date.setName(name);
		return dao.findAll(date);
	}
}
