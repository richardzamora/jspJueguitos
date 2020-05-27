package server.server.dto;

import server.server.interfaces.Crud;

import java.sql.Date;

public class UsuarioDto implements Crud {
	
	private String name;
	private String last_name;
	private String nickname;
	private String mail;
	private String password;
	private Date birthDate;
	
	public UsuarioDto() {
		
	}
	
	public UsuarioDto(String name, String last_name, String nickname, String mail, String password, Date birthDate) {
		super();
		this.name = name;
		this.last_name = last_name;
		this.nickname = nickname;
		this.mail = mail;
		this.password = password;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String insert() {
		return "INSERT INTO usuario(name, last_name, nickname, mail, password, birthdate) "
                + "VALUES ('"+ name + "', '" + last_name +"', '" + nickname + "', '" + mail + "', '" +  password 
                + "', '" + birthDate + "');";
	}

	@Override
	public String update() {
		return "UPDATE usuario set mail = '"+ mail + "', password = '" + password + "', last_name = '" + last_name
				+ "', nickname = '" + nickname + "', mail = '" + mail + "'"
                + ", birth_date = '" + birthDate  + "' where mail = '"+mail+"';";
	}

	@Override
	public String delete() {
		return "DELETE from usuario where mail = '" + mail + "';";
	}

	@Override
	public String findById() {
		return "SELECT name, last_name, nickname, mail, password, birth_date from usuario where mail = "
				+ "'" + mail +"';";
	}

	@Override
	public String findAll() {
		return "SELECT name, last_name, nickname, mail, birth_date from usuario;";
	}

	@Override
	public String toString() {
		return "Usuario [name=" + name + ", last_name=" + last_name + ", nickname=" + nickname + ", mail=" + mail
				+ ", password=" + password + ", birtDate=" + birthDate + "]";
	}

	public String authUser(){
		return "SELECT name, last_name, nickname, mail, password, birth_date from usuario where mail = "
				+ "'" + mail + "' and password = '" + password +"';";
	}
}
