package server.server.dto;

import server.server.interfaces.Crud;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Date;

public class JuegosDto implements Crud {

	private int id;
	private String name;
	private String description;
	private Date releaseDate;
	private byte[] image;
	private ImageIcon imageRendered;
	private double calification;
	private int empresa;
	private int genero;
	
	public JuegosDto() {
		
	}
	
	public JuegosDto(int id, String name, String description, Date release_date, ImageIcon image, double calification, int empresa, int genero) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.releaseDate = release_date;
		this.imageRendered = image;
		this.calification = calification;
		this.empresa = empresa;
		this.genero = genero;
		
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date release_date) {
		this.releaseDate = release_date;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public double getCalification() {
		return calification;
	}

	public void setCalification(double calification) {
		this.calification = calification;
	}

	public int getEmpresa() {
		return empresa;
	}

	public void setEmpresa(int empresa) {
		this.empresa = empresa;
	}

	public int getGenero() {
		return genero;
	}

	public void setGenero(int genero) {
		this.genero = genero;
	}

	public byte[] toBinary(String path) {
	    
		int len = path.split("\\.").length;
	    String ext = path.split("\\.")[len - 1];
        BufferedImage img;
		try {
			img = ImageIO.read(new File(path));
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
	        ImageIO.write(img, ext, baos);
	        return baos.toByteArray();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public String insert() {
		
		return "INSERT INTO juegos(name, description, release_date, image, calification, empresa, genero)"+
                " VALUES ('"+ name + "', '" + description +
                "' , '" + releaseDate + "', '" + image + "' , '" + calification + "' , '"+ empresa + "' , '"+ genero + "');";
	}

	@Override
	public String update() {
		return "UPDATE juegos SET name = '"+ name + "', description ='" + description +
				"', release_date ='" + releaseDate +
				"', image ='" + image + "', calification ='" + calification + "', empresa = '" + empresa + "', genero = '" + 
				genero +"' WHERE id='" + id + "';";
	}

	@Override
	public String delete() {
		return "DELETE FROM juegos WHERE id='" + id + "';";
	}

	@Override
	public String findById() {
		return "SELECT id, name, description, release_date, image, calification, empresa, genero FROM juegos "
				+ "WHERE id='" + id + "';";
	}

	@Override
	public String findAll() {
		return  "SELECT id, name, description, release_date, image, calification, empresa, genero FROM public.juegos;";
	}

	@Override
	public String toString() {
		return "Juegos [id=" + id + ", name=" + name + ", description=" + description + ", release_date="
				+ releaseDate + ", image=" + image + ", calification=" + calification +", empresa = " + empresa + ", genero = " + 
						genero + "]";
	}
}
