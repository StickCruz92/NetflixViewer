package com.stickcom.netflixviewer.model;

import java.util.ArrayList;


public class Serie extends Film{

	private int id;
	private int sessionQuality;
	private ArrayList<Chapter> capitulos;

	public Serie(String title, String genere, String create, int duration, int sessionQuality) {
		super(title, genere, create, duration);
		// TODO Auto-generated constructor stub
		this.sessionQuality = sessionQuality;
		
	}
	


	public int getId() {
		return id;
	}

	public int getSessionQuality() {
		return sessionQuality;
	}

	public void setSessionQuality(int sessionQuality) {
		this.sessionQuality = sessionQuality;
	}

	public ArrayList<Chapter> getCapitulos() {
		return capitulos;
	}

	public void setCapitulos(ArrayList<Chapter> capitulos) {
		this.capitulos = capitulos;
	}

	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
				return  "\n :: SERIE ::" + 
						"\n Title: " + getTitle() +
						"\n Genero: " + getGenere() + 
						"\n Year: " + getYear() + 
						"\n Creator: " + getCreate() +
						"\n Duration: " + getDuration();
	} 
	
	public static ArrayList<Serie> hacerListaSeries() {
		ArrayList<Serie> series = new ArrayList();
		
		for (int i = 1; i <= 5; i++) {
			Serie serie = new Serie("Serie "+i, "genero "+i, "creador "+i, 1200, 5);
			serie.setCapitulos(Chapter.hacerListaCapitulos(serie));
			series.add(serie);
		}
		
		return series;
	}

	@Override
	public void view() {
		// TODO Auto-generated method stub
		setViewed(true);
	}

}
