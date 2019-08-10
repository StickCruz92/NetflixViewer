package com.stickcom.netflixviewer.model;

/**
 * <h1>Film</h1>
 * Film es una clase padre abstracta
 * <P>
 * Esta clase es la clase base de la Films, como es abstractor
 * no puede crease instancia. Contiene el metodo abstractor.
 * {@code view()} que es obligatorio implementarlo para todo aquel que pertenezca a la familia Films
 * 
 * @author stick.cruz
 * @version 1.1
 * @since 2018
 * 
 * */

public abstract class Film {

	private String title;
	private String genere;
	private String create;
	private int duration;
	private short year;
	private boolean viewed;

	
	public Film(String title, String genere, String create, int duration) {
		super();
		this.title = title;
		this.genere = genere;
		this.create = create;
		this.duration = duration;
	}
	
	public Film() {
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
	public String getCreate() {
		return create;
	}
	public void setCreate(String create) {
		this.create = create;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public short getYear() {
		return year;
	}
	public void setYear(short year) {
		this.year = year;
	}
	public String isViewed() {
		String visto = "";
		if (viewed == true) {
			visto = "Sí";
		} else {
			visto = "No";
		}
		return visto;
	}
	public void setViewed(boolean viewed) {
		this.viewed = viewed;
	}
	
	public boolean getIsViewed() {
		return viewed;
	}
	
	/**
	 * {@code view()} es un metdo abstracto obligatorio de implementar.
	 * */
	public abstract void view();
	
}
