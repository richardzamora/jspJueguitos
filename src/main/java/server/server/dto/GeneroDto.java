package server.server.dto;

import server.server.interfaces.Crud;

public class GeneroDto implements Crud {

	private int id;
	private String name;
	
	public GeneroDto() {
		
	}
	
	public GeneroDto(int id, String name) {
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
		return "INSERT INTO generos(name) " + "VALUES ('" + name +"');";
	}

	@Override
	public String update() {
		return "UPDATE generos set name = '"+ name + "' where id = '" + id + "';";
	}

	@Override
	public String delete() {
		return "DELETE from generos where id = '" + id + "';";
	}

	@Override
	public String findById() {
		return "SELECT id, name FROM generos where id = '" + id +"';";
	}

	@Override
	public String findAll() {
		return "SELECT id, name FROM public.generos;";
	}

	@Override
	public String toString() {
		return "Generos [id=" + id + ", name=" + name + "]";
	}

	public String count() {
		return "SELECT count(*) FROM public.generos;";
	}
}
