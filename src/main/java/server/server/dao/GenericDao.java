package server.server.dao;

import model.conexion.Conexion;
import server.server.dto.GeneroDto;
import server.server.dto.UsuarioDto;
import server.server.estructura.stack.IStackArray;
import server.server.interfaces.Crud;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;


public class GenericDao<T> {
	
	private Class<T> entityClass;
	private Method[] daoMethods;
	protected Conexion con;

	public GenericDao(Class<T> entityClass) 
	{
		this.entityClass = entityClass;
		this.daoMethods = entityClass.getMethods();
		this.con = Conexion.getInstance();
	}

	public boolean insert(Crud date)
	{
		return con.executeUpdate(date.insert());
	}

	public boolean update(Crud date)
	{
		return con.executeUpdate(date.update());
	}

	public boolean delete(Crud date)
	{
		return con.executeUpdate(date.delete());
	}

	public Crud findById(Crud date)
	{
		ResultSet rs = con.executeQuery(date.findById());
		return getQuerySingle(rs);
	}

	protected Crud getQuerySingle(ResultSet rs)
	{
		T newObjet = null;
		try 
		{
			ResultSetMetaData rsMD = rs.getMetaData();
			while (rs.next())
			{
				newObjet = entityClass.getDeclaredConstructor().newInstance();
				for(int i = 1; i <= rsMD.getColumnCount(); i++)
				{
					Method methodToInvoked = methodToInvoked(nameMethod(rsMD.getColumnName(i)));
					if(methodToInvoked == null) 
					{
						throw new Exception("Metodo no encontrado");
					}else {
						methodToInvoked.invoke(newObjet, rs.getObject(i));
					}
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return (Crud) newObjet;
	}
	
	public IStackArray<T> findAll(Crud dato)
	{
		ResultSet rs = con.executeQuery(dato.findAll());
		IStackArray<T> list = getQueryList(rs);
		return list;
	}

	protected IStackArray<T> getQueryList(ResultSet rs) 
	{
		T newObjet = null;

		IStackArray<T> dates =  new IStackArray<T>();
		try 
		{
			ResultSetMetaData rsMD = rs.getMetaData();
			while(rs.next())
			{
				newObjet = entityClass.getDeclaredConstructor().newInstance();
				for(int i = 1; i <= rsMD.getColumnCount(); i++)
				{
					Method methodToInvoked =  methodToInvoked(nameMethod(rsMD.getColumnName(i)));
					if(methodToInvoked == null) {
						throw new Exception("Metodo no encontrado");
					}else {
						methodToInvoked.invoke(newObjet, rs.getObject(i));
					}
				}
				dates.add(newObjet);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return dates;
	}

	//Retorna el método que se va a ejecutar
	private Method methodToInvoked(String nameMethod) 
	{
		for (int i = 0; i < daoMethods.length; i++) {
			if(daoMethods[i].getName().equals(nameMethod))
			{
				return daoMethods[i];
			}
		}
		return null;
	}

	//Construye el nombre del método
	private String nameMethod(String columnName) 
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("set");

		if(columnName.indexOf("_") >= 1) {
			String[] subStrings = columnName.split("_");
			
			for(int i = 0; i < subStrings.length; i++)
			{
				buffer.append(subStrings[i].substring(0, 1).toUpperCase()+subStrings[i].substring(1, subStrings[i].length()).toLowerCase());
			}
					
		}else {
			buffer.append(columnName.substring(0, 1).toUpperCase()+ columnName.substring(1).toLowerCase());
		}
		return buffer.toString();
	}

	public int count(Crud crud) {
			return findAll(crud).size();
	}

	public ArrayList<T> getAll(int sizePage, int numberPage, Crud dato) throws SQLException {
		ResultSet rs = con.executeQuery(dato.findAll());
		IStackArray<T> list = getQueryList(rs);
		ArrayList<T> miLista= new ArrayList<>();
		for (int i = numberPage*sizePage; i<(numberPage+1)*sizePage;i++)
		{
			miLista.add(list.get(i));
			if(list.get(i+1)==null)
			{
				break;
			}
		}
		return miLista;
	}
	public boolean getAutentication(UsuarioDto usuario)
	{
		ResultSet rs = con.executeQuery(usuario.authUser());
		if(getQuerySingle(rs)!=null)
		{
			return true;
		}
		return false;
	}
}
