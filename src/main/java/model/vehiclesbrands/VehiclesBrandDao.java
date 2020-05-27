package model.vehiclesbrands;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import model.abstracts.AbstractDao;
import model.interfaces.IDto;

public class VehiclesBrandDao extends AbstractDao<VehiclesBrand> {

	@Override
	public VehiclesBrand getById(IDto dto) throws SQLException {
		ResultSet rs = con.executeQuery(dto.findById());
		VehiclesBrand vehicleBrand = null;
		while (rs.next()) {
			vehicleBrand = new VehiclesBrand(rs.getInt("id"), rs.getString(2), rs.getTimestamp(3), rs.getTimestamp(4));
		}
		return vehicleBrand;
	}

	@Override
	public Collection<VehiclesBrand> getAll() throws SQLException {
		ResultSet rs = con.executeQuery((new VehiclesBrand()).findAll());
		List<VehiclesBrand> vehiclesBrands = new LinkedList<VehiclesBrand>();
		while (rs.next()) {
			vehiclesBrands.add(new VehiclesBrand(rs.getInt("id"), rs.getString(2), rs.getTimestamp(3), rs.getTimestamp(4)));
		}
		return new ArrayList<VehiclesBrand>(vehiclesBrands);
	}

	public String[] getNameBrands() throws SQLException {
		ResultSet rs = con.executeQuery("Select name from public.vehicles_brands order by name;");
		List<String> vehiclesBrands = new LinkedList<String>();
		while (rs.next()) {
			vehiclesBrands.add(rs.getString(1).trim());
		}
		return vehiclesBrands.toArray(new String[0]);
	}

	public int getVehicleBrandKey(String name) throws SQLException {
		ResultSet rs = con.executeQuery("Select id from public.vehicles_brands where name = '" + name.trim() + "';");
		int id = 0;
		while (rs.next()) {
			id = rs.getInt(1);
		}
		return id;
	}

	public Collection<VehiclesBrand> getAll(int sizePage, int numberPage) throws SQLException {
		String sql = (new VehiclesBrand()).findAll(sizePage, numberPage);
		System.out.println(sql);
		ResultSet rs = con.executeQuery(sql);
		List<VehiclesBrand> vehiclesBrands = new LinkedList<VehiclesBrand>();
		while (rs.next()) {
			vehiclesBrands.add(new VehiclesBrand(rs.getInt("id"), rs.getString(2), rs.getTimestamp(3), rs.getTimestamp(4)));
		}
		return new ArrayList<VehiclesBrand>(vehiclesBrands);
	}

	public int count() {
		ResultSet rs = con.executeQuery((new VehiclesBrand()).count());
		try {
			while (rs.next()) {
				return rs.getInt(1);
			}
		}catch (SQLException e){
		}
		return 0;
	}
}
