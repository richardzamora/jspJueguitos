package server.server.controlador;

import server.server.dao.JuegosDao;
import server.server.dto.JuegosDto;
import server.server.estructura.stack.IStackArray;

import javax.swing.*;
import java.sql.Date;

public class JuegosControlador<T> {
	
	private JuegosDao<T> dao;
	
	public JuegosControlador() {
		dao = new JuegosDao<T>();
	}
	
	public boolean insert(int id, String name, String description, Date release_date, ImageIcon image, double calification, int empresa, int genero) {
		JuegosDto date = new JuegosDto(id, name, description, release_date, image, calification, empresa, genero);
		return dao.insert(date);
	}
	
	public boolean update(int id, String name, String description, Date release_date, ImageIcon image, double calification, int empresa, int genero) {
		JuegosDto date = new JuegosDto(id, name, description, release_date, image, calification, empresa, genero);
		return dao.update(date);
	}
	
	public boolean delete(int id) {
		JuegosDto date = new JuegosDto();
		date.setId(id);
		return dao.delete(date);
	}
	
	public JuegosDto findById(int id){
		JuegosDto date = new JuegosDto();
		date.setId(id);
		return (JuegosDto) dao.findById(date);
	}
	
	public IStackArray<JuegosDto>findAll()
	{
		JuegosDto date = new JuegosDto();
		return dao.findAll(date);
	}

}
