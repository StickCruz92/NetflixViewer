package com.stickcom.netflixviewer.db;

import java.sql.Connection;
import java.sql.DriverManager;
import static com.stickcom.netflixviewer.db.DataBase.*;

public interface IDBConnection {

	default Connection connectToDB() {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL+DB, USER, PASS);
			if (connection != null) {
				System.out.println("Conexion extablecidad :D ");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			return connection;
		}
	}
	
}
