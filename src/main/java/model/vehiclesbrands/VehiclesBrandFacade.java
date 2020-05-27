package model.vehiclesbrands;

import java.sql.SQLException;

public class VehiclesBrandFacade {

		private VehiclesBrandDao dao;
		
		public VehiclesBrandFacade() {
			dao = new VehiclesBrandDao();
		}
		
		public Object[] getNameBrands() throws SQLException {
			return dao.getNameBrands();
		}
		
		public int getVehicleBrandKey(String name) throws SQLException {
			return dao.getVehicleBrandKey(name);
		}

}
