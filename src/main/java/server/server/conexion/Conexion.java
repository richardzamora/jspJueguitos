package server.server.conexion;

import java.io.InputStream;
import java.sql.Statement;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {

	private static Conexion conexion= null;
	private Connection con;


	private Conexion() {

		Properties dataConex = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream("data/conexion.properties");
			dataConex.load(input);

			String url = dataConex.getProperty("url");
			String user = dataConex.getProperty("user");
			String password = dataConex.getProperty("password");

			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, user ,password);

			System.out.println("Conexión Realizada");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error en la conexion con la base de datos");
		}

	}

	public static Conexion getInstance() {
		if (conexion == null) {
			conexion = new Conexion();
		}
		return conexion;
	}
	
	public ResultSet getQuery(String query) {
		ResultSet rs = null;
		try {

			Statement st = con.createStatement();
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public boolean executeQuery(String query) {
		boolean ex = false;
		
		try {
			System.out.println(query);
			Statement st = con.createStatement();
			
			ex = st.execute(query);
			ex = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ex;
	}

}
