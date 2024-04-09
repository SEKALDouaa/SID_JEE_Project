package com.jee.DAO;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSetMetaData;


public class DataBase {
	
	private DataSource ds;
	private Connection cnx;
	
	public DataBase() {
		
	}
	
	public DataBase(DataSource ds) {
		this.ds=ds;
		cnx=ds.getConnection();
	}
	
	public void setDataSource(DataSource ds) {
		this.ds=ds;
		cnx=ds.getConnection();
	}
	
	public DataSource getDs() {
		return this.ds;
	}
	
	public Connection getCnx() {
		return this.cnx;
	}
	
	public int insertElement(Object o) {
		try {
			StringBuffer req=new StringBuffer("insert into "+o.getClass().getSimpleName()+" values ('");
			Field[] f=o.getClass().getDeclaredFields();
			f[0].setAccessible(true);
			req.append(f[0].get(o)+"'");
			
			for(int i=1; i<f.length; i++) {
				f[i].setAccessible(true);
				if(f[i].getType().isPrimitive() || f[i].getType()==String.class) {
					req.append(",'"+f[i].get(o)+"'");
					f[i].setAccessible(false);
				}
				else {
					Field[] field=f[i].getType().getDeclaredFields();
					field[0].setAccessible(true);
					req.append(",'"+field[0].get(f[i].get(o))+"'");
					field[0].setAccessible(false);
					f[i].setAccessible(false);
				}
			}
			req.append(");");
			Statement stm=cnx.createStatement();
			return stm.executeUpdate(req.toString());
			
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public Object selectElement(int id, Class<?> clazz) {
		try {
			Field[] f=clazz.getDeclaredFields();
			String req="select * from "+clazz.getSimpleName()+" where "+f[0].getName()+
				"="+id+";";
			Statement stm=cnx.createStatement();
			ResultSet rs=stm.executeQuery(req);
			ResultSetMetaData rsm=rs.getMetaData();
			Object o=clazz.newInstance();
			while(rs.next()) {
				for(int i=0; i<f.length; i++) {
					f[i].setAccessible(true);
					if(f[i].getType().isPrimitive() || f[i].getType()==String.class) {
						f[i].set(o, rs.getObject(i+1));
				}
					else {
						f[i].set(o, selectElement(rs.getInt(i+1),f[i].getType()));
					}
					f[i].setAccessible(false);
				}
			}
			return o;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Object selectElement(String email,String pwd, Class<?> clazz) {
		try {
			Field[] f=clazz.getDeclaredFields();
			String req="select * from "+clazz.getSimpleName()+" where email='"
				+email+"' and pwd='"+pwd+"';";
			Statement stm=cnx.createStatement();
			ResultSet rs=stm.executeQuery(req);
			ResultSetMetaData rsm=rs.getMetaData();
			Object o=clazz.newInstance();
			while(rs.next()) {
				for(int i=0; i<f.length; i++) {
					f[i].setAccessible(true);
					if(f[i].getType().isPrimitive() || f[i].getType()==String.class) {
						f[i].set(o, rs.getObject(i+1));
				}
					else {
						f[i].set(o, selectElement(rs.getInt(i+1),f[i].getType()));
					}
					f[i].setAccessible(false);
				}
			}
			return o;
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int updateElement(int neew, int old, Class<?> clazz) {
		try {
			Field[] f=clazz.getDeclaredFields();
			String req="update "+clazz.getSimpleName()+" set "+f[0].getName()+"="+neew+" where "
					+f[0].getName()+"="+old+";";
			Statement stm=cnx.createStatement();
			
			return stm.executeUpdate(req);
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public List<Object> selectAll(Class<?> clazz){
		try {
			String req="select * from "+clazz.getSimpleName()+";";
			Statement stm=cnx.createStatement();
			ResultSet rs=stm.executeQuery(req);
			List<Object> l=new ArrayList<>();
			Field[] f=clazz.getDeclaredFields();
			while(rs.next()) {
				f[0].setAccessible(true);
				Object o=clazz.newInstance();
				o=selectElement(f[0].getInt(o),clazz);
				l.add(o);
			}
			return l;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int deleteElement(int id, Class<?> clazz) {
		try {
			Field[] f=clazz.getDeclaredFields();
			f[0].setAccessible(true);
			String req="delete from "+clazz.getSimpleName()+" where "+f[0].getName()+"="+id+";";
			Statement stm=cnx.createStatement();
			return stm.executeUpdate(req);
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
}


