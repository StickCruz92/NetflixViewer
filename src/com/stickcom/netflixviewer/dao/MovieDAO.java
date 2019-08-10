package com.stickcom.netflixviewer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.stickcom.netflixviewer.db.IDBConnection;
import com.stickcom.netflixviewer.model.Movie;
import static com.stickcom.netflixviewer.db.DataBase.*;


public interface MovieDAO extends IDBConnection{

	/*default se puede llamar desde cual instancia*/
	default Movie setMovieViewd(Movie movie) {
		try (Connection connection = connectToDB()){
			
			Statement statement = connection.createStatement();
			String query = "INSERT INTO "+TVIEWER + 
					"(" + VIEWER_IDMATERIAL + ", " + VIEWER_IDELEMENT + ", " + VIEWER_IDUSUARIO + ")" +
					"VALUES("+ IDMATERIALS[0] +", "+movie.getId()+", "+ 1 + ")";
			
			if ((statement.executeUpdate(query)) > 0 ) {
				System.out.println("Se marcó en visto");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return movie;
	}
	
	default ArrayList<Movie> read() {
		ArrayList<Movie> movies = new ArrayList();
		try (Connection connection = connectToDB()){
			String query = "SELECT * FROM "+TMOVIE;
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				Movie movie = new Movie(
						  rs.getString(TMOVIE_TITLE), 
						  rs.getString(TMOVIE_GENRE), 
						  rs.getString(TMOVIE_CREATOR),
						  Integer.valueOf(rs.getString(TMOVIE_DURATION)),
						  Short.valueOf(rs.getString(TMOVIE_YEAR)));
				
				movie.setId(Integer.valueOf(rs.getString(TMOVIE_ID)));
				movie.setViewed(getMovieViewed(
						preparedStatement, 
						connection, 
						Integer.valueOf(rs.getString(TMOVIE_ID))));
				movies.add(movie);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return movies;
	}
	
	/*private solo puede ser llamado desde la misma clase*/
	default boolean getMovieViewed (PreparedStatement preparedStatement, Connection connection, int id_movie) {
		boolean viewed = false;
		String query = "SELECT * FROM "+TVIEWER +  " "+
				"WHERE " + VIEWER_IDMATERIAL + " =  ? " + 
				"AND " + VIEWER_IDELEMENT + " =  ? " +
				"AND " + VIEWER_IDUSUARIO + " =  ? ";
		
		ResultSet rs = null;
		
		try {
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, IDMATERIALS[0]);
			preparedStatement.setInt(2, id_movie);
			preparedStatement.setInt(3, 1);
			
			rs = preparedStatement.executeQuery();
			viewed = rs.next();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return viewed;
	}
	
}
