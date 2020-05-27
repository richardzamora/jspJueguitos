package model.vehiclesbrands;

import model.interfaces.IDto;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class VehiclesBrand implements IDto{
	private Integer id;
	private String name;
	private Timestamp createdAt;
	private Timestamp updatedAt;

	public VehiclesBrand() {

	}

	public VehiclesBrand(Integer id) {
		this.id = id;
	}

	public VehiclesBrand(Integer id, String name, Timestamp createdAt, Timestamp updatedAt) {
		this.id = id;
		this.name = name;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name.trim();
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreatedAt() {
		return formatDate(createdAt);
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return formatDate(updatedAt);
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	private String formatDate(Timestamp timestamp){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return format.format(timestamp);
	}
	public String insert() {
		return "INSERT into public.vehicles_brands(name) values('"+getName()+"');";
	}

	public String update() {
		return "UPDATE public.vehicles_brands set name = '"+getName().trim()+
				"' where id = "+getId();
	}

	public String delete() {
		return "DELETE FROM public.vehicles_brands where id = "+getId();
	}

	public String findAll() {
		return "SELECT * FROM public.vehicles_brands order by id;";
	}

	public String findAll(int sizePage, int numberPage) {
		return "SELECT * FROM public.vehicles_brands order by id limit "+sizePage+ " offset "+numberPage;
	}

	public String findById() {
		return "SELECT * FROM public.vehicles_brands where id = "+getId();
	}

	public String count() {
		return "SELECT count(*) FROM public.vehicles_brands";
	}

	@Override
	public String toString() {
		return "VehiclesBrand{" +
				"id=" + id +
				", name='" + name + '\'' +
				", createdAt=" + createdAt +
				", updatedAt=" + updatedAt +
				'}';
	}
}
