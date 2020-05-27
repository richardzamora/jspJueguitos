package server.server.dto;

import server.server.interfaces.Crud;

public class EmpresasDto implements Crud {

	private int id;
	private String name;
	
	public EmpresasDto() {
		
	}
	
	public EmpresasDto(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String insert() {
		return "INSERT INTO empresas(name) " + "VALUES ('" + name + "');";
	}

	@Override
	public String update() {
		return "UPDATE empresas set name = '"+ name + "' where id = '" + id + "';";
	}

	@Override
	public String delete() {
		return "DELETE from empresas where id = '" + id + "';";
	}

	@Override
	public String findById() {
		return "SELECT id, name from empresas where id = '" + id + "';";
	}

	@Override
	public String findAll() {
		return "SELECT id, name from empresas;";
	}

	@Override
	public String toString() {
		return "Empresas [id=" + id + ", name=" + name + "]";
	}

}
