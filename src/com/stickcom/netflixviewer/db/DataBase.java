package com.stickcom.netflixviewer.db;

public class DataBase {

	public static final String URL = "jdbc:mysql://localhost:3306/";
	public static final String DB = "amazonviewer";
	public static final String USER = "root";
	public static final String PASS = "";
	
	public static final String TMOVIE 			= "movie";
	public static final String TMOVIE_ID 		= "id";
	public static final String TMOVIE_TITLE 	= "title";
	public static final String TMOVIE_GENRE 	= "genre";
	public static final String TMOVIE_CREATOR 	= "creator";
	public static final String TMOVIE_DURATION 	= "duration";
	public static final String TMOVIE_YEAR 		= "year";
	
	public static final String TVIEWER 				= "viewed";
	public static final String VIEWER_IDELEMENT 	= "id_element";
	public static final String VIEWER_IDMATERIAL 	= "id_material";
	public static final String VIEWER_IDUSUARIO 	= "id_user";

	public static final int[]  IDMATERIALS = {1,2,3,4,5};



}
