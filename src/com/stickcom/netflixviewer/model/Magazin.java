package com.stickcom.netflixviewer.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Magazin extends Publication{

	private int id;

	public int getId() {
		return id;
	}

	public Magazin(String title, Date editionDate, String editorial) {
		super(title, editionDate, editorial);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Magazin [getTitle()=" + getTitle() + ", getEditionDate()=" + getEditionDate() + ", getEditorial()="
				+ getEditorial() + "]";
	}

	public static ArrayList<Magazin> hacerListaLibros() {
		ArrayList<Magazin> magazins = new ArrayList<>();
		
		for (int i = 0; i <= 5; i++) {
			magazins.add(new Magazin("magazins "+i, new Date(), "editorial" +i));
		}
		
		return magazins;
		
	}
	
}
