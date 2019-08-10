package com.stickcom.netflixviewer.model;

import java.util.ArrayList;
import java.util.Date;

import com.stickcom.netflixviewer.dao.MovieDAO;

/**
 * Hereda de {@link Film}
 * Implementa de {@link IVisualizable}
 * */

public class Movie extends Film implements IVisualizable, MovieDAO{

	private int id;
	private int timeViewed;


	public Movie(String title, String genere, String create, int duration, short year) {
		super(title, genere, create, duration);
		super.setYear(year);
	}

	public Movie() {
	}
	
	public void verInformacion () {
		/*System.out.println("Titulo:" + this.title);
		System.out.println("Genero:" + this.genere);
		System.out.println("Año:" + this.year);*/
		
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public int getTimeViewed() {
		return timeViewed;
	}

	public void setTimeViewed(int timeViewed) {
		this.timeViewed = timeViewed;
	}

	@Override
	public String toString() {
		return  "\n :: MOVIE ::" + 
				"\n Title: " + getTitle() +
				"\n Genero: " + getGenere() + 
				"\n Year: " + getYear() + 
				"\n Creator: " + getCreate() +
				"\n Duration: " + getDuration();
	}

	/**
	 * {@inheritDoc}
	 * */
	@Override
	public Date iniciarVideo(Date dateoI) {
		// TODO Auto-generated method stub
		return dateoI;
	}

	/**
	 * {@inheritDoc}
	 * */
	@Override
	public void pausarVideo(Date dateI, Date dateF) {
		// TODO Auto-generated method stub
		if (dateF.getTime() > dateI.getTime()) {
		      setTimeViewed((int)(dateF.getTime() - dateI.getTime()));
		      
		} else {
			setTimeViewed(0);
		}
	} 
	
	public static ArrayList<Movie> hacerListaPeliculas() {
		//ArrayList<Movie> movies = new ArrayList<>();
		Movie movie = new Movie();
		return movie.read();
		/*for (int i = 0; i <= 5; i++) {
			movies.add(new Movie("Movie "+i, "Genero "+i, "Creador "+i, (110+(i*5)), (short) (2015+i)));
		}*/
		
		//return movies;
		
	}

	/**
	 * {@inheritDoc}
	 * */
	
	@Override
	public void view() {
		// TODO Auto-generated method stub
		setViewed(true);
		Movie movie = new Movie();
		movie.setMovieViewd(this);
		Date dateI = iniciarVideo(new Date());
		
		for (int i = 0; i < 100000; i++) {
			System.out.println("....................");
		}
		
		/*Terminar video*/
		pausarVideo(dateI, new Date());
		System.out.println();
		System.out.println("Viste la peliculas : "+ toString());
		System.out.println("Por :" + getTimeViewed() + " milisegundos");
	}
	
}
