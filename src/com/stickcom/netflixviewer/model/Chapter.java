package com.stickcom.netflixviewer.model;

import java.util.ArrayList;

/**
 * Hereda de {@link Movie}
 * @see Film
 * */

public class Chapter extends Movie implements IVisualizable{
	
	private int id;
	private int sessionNumber;
	private Serie serie;

	public Chapter(String title, String genre, String creator, int duration, short year, int sessionNumber, Serie serie) {
		super(title, genre, creator, duration, year);
		// TODO Auto-generated constructor stub
		this.setSessionNumber(sessionNumber);
		this.setSerie(serie);
	}
	
	public Chapter(String title, String genere, String create, int duration, short year, int sessionNumber) {
		super(title, genere, create, duration, year);
		// TODO Auto-generated constructor stub
		this.sessionNumber = sessionNumber;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.getId();
	}
	
	public int getSessionNumber() {
		return sessionNumber;
	}

	public void setSessionNumber(int sessionNumber) {
		this.sessionNumber = sessionNumber;
	}
	
	
	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	@Override
	public String toString() {
		return  "\n :: CAPITULO ::" + 
				"\n Title: " + getTitle() +
				"\n Genero: " + getGenere() + 
				"\n Year: " + getYear() + 
				"\n Creator: " + getCreate() +
				"\n Duration: " + getDuration();
	} 
	

	public static ArrayList<Chapter> hacerListaCapitulos() {
		ArrayList<Chapter> chapters = new ArrayList();
		
		for (int i = 1; i <= 5; i++) {
			chapters.add(new Chapter("Capituo "+i, "genero "+i, "creator" +i, 45, (short)(2017+i), i));
		}
		
		return chapters;
	}
	
	public static ArrayList<Chapter> hacerListaCapitulos(Serie serie) {
		ArrayList<Chapter> chapters = new ArrayList();
		
		for (int i = 1; i <= 5; i++) {
			chapters.add(new Chapter("Capituo "+i, "genero "+i, "creator" +i, 45, (short)(2017+i), i, serie));
		}
		
		return chapters;
	}
	
	
	@Override
	public void view() {
		// TODO Auto-generated method stub
		super.view();
		ArrayList<Chapter> chapters = getSerie().getCapitulos();
		int chapterViewCounter = 0;
		for (Chapter chapter : chapters) {
			if (chapter.getIsViewed()) {
				chapterViewCounter ++;
			}
		}
		
		if (chapterViewCounter == chapters.size()) {
			setViewed(true);
		}
	}
	
}
