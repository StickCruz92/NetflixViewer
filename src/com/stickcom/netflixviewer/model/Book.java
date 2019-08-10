package com.stickcom.netflixviewer.model;

import java.util.ArrayList;
import java.util.Date;

import com.stickcom.netflixviewer.util.AmazonUtil;

public class Book extends Publication implements IVisualizable {

	private int id;
	private String isbn;
	private boolean readed;
	private int timeReaded;
	private ArrayList<Page> pages;

	public Book(String title, Date editionDate, String editorial, String[] authors, ArrayList<Page> pages) {
		super(title, editionDate, editorial);
		// TODO Auto-generated constructor stub
		setAuthors(authors);
		this.pages = pages;
	}

	public int getId() {
		return id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String isReaded() {
		// return readed;
		String libro = "";
		if (readed) {
			libro = "Lectura Finalizada";
		} else {
			libro = "Lectura Pendiente";
		}
		return libro;
	}

	public void setReaded(boolean readed) {
		this.readed = readed;
	}

	public int getTimeReaded() {
		return timeReaded;
	}

	public void setTimeReaded(int timeReaded) {
		this.timeReaded = timeReaded;
	}
	
	

	public ArrayList<Page> getPages() {
		return pages;
	}

	public void setPages(ArrayList<Page> pages) {
		this.pages = pages;
	}

	@Override
	public String toString() {

					String detailBook = "\n :: BOOK ::" + 
							"\n Title: " + getTitle() +
							"\n Editorial: " + getEditorial() + 
							"\n Edition Date: " + getEditionDate() +
							"\n Authors: ";
			for (int i = 0; i < getAuthors().length; i++) {
			detailBook += "\t" + getAuthors()[i] + " ";
			}
			return  detailBook;
	}

	@Override
	public Date iniciarVideo(Date dateoI) {
		// TODO Auto-generated method stub
		return dateoI;
	}

	@Override
	public void pausarVideo(Date dateI, Date dateF) {
		// TODO Auto-generated method stub
		if (dateI.getSeconds() > dateF.getSeconds()) {
			setTimeReaded(dateI.getSeconds() - dateF.getSeconds());
		} else {
			setTimeReaded(0);
		}
	}

	public void view() {
		setReaded(true);
		Date dateI = iniciarVideo(new Date());
		
		int i = 0;
		
		do {
			System.out.println("............");
			System.out.println("Pagina " + getPages().get(i).getNumero());
			System.out.println(getPages().get(i).getContent());
			System.out.println("............");
			
			if (i != 0) {
				System.out.println("1. Regresar página");
			}
			
			System.out.println("2. Siguiente página");
			System.out.println("0. Cerrar Libro");
			System.out.println();

			int respuesta = AmazonUtil.validateUserResponseMenu(0, 2);
			
			if (respuesta == 2) {
				i++;
			}else if (respuesta == 1) {
				i--;
			} else if (respuesta == 0) {
				break;
			}

			
		} while (i < getPages().size());
		
		
		// Termine de verla
		pausarVideo(dateI, new Date());
		System.out.println();
		System.out.println("Leiste: " + toString());
		System.out.println("Por: " + getTimeReaded() + " milisegundos");

	}

	public static ArrayList<Book> hacerListaLibros() {
		ArrayList<Book> books = new ArrayList<>();

		String[] authors = new String[3];
		
		for (int i = 0; i < 3; i++) {
			authors[i] = "author "+i;
		}
		
		ArrayList<Page> pages = new ArrayList();
		int pagina = 0;
		
		for (int i = 0; i < 3; i++) {
			pagina = i+1;
			pages.add(new Book.Page(pagina, "Contenido de la pagina "+i));
		}
		
		for (int i = 0; i <= 5; i++) {
			books.add(new Book("Book " + i, new Date(), "editorial " + i, authors, pages));
		}

		return books;

	}

	public static class Page {

		private int id;
		private int numero;
		private String content;

		public Page(int numero, String content) {
			super();
			this.numero = numero;
			this.content = content;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getNumero() {
			return numero;
		}

		public void setNumero(int numero) {
			this.numero = numero;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

	}

}
