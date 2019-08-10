package com.stickcom.netflixviewer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.stickcom.hacerreporte.Reporte;
import com.stickcom.netflixviewer.model.Book;
import com.stickcom.netflixviewer.model.Chapter;
import com.stickcom.netflixviewer.model.Movie;
import com.stickcom.netflixviewer.model.Serie;
import com.stickcom.netflixviewer.util.AmazonUtil;


/**
 * <h1>NeflixViewer</h1>
 * Es un programa que nos permite 
 * visualizar peliculas, series con sus respectivos ccapitulos. Te permite generar reportes generales y con la fecha
 * <P>
 * Existe algunas reglas que todos los elementos pueden ser visualizados o leidos a excciones de Noticias.
 * 
 * @author stick.cruz
 * @version 1.1
 * @since 2018
 * 
 * */

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		showMenu();
	
	}

	public static void showMenu() {

		int exit = 0;
		do {

			System.out.println("Bienvenidos a netflix viewer");
			System.err.println("");
			System.out.println("Selecciona la opción deseada");
			System.out.println("");
			System.out.println("1. Peliculas");
			System.out.println("2. Series");
			System.out.println("3. Libros");
			System.out.println("4. Noticias");
			System.out.println("5. Reporte");
			System.out.println("6. Reporte del día");
			System.out.println("0. Salir");

			//Leer la respuesta del usuario
			int entrada = AmazonUtil.validateUserResponseMenu(0, 6);

			switch (entrada) {
			case 0:
				exit = 0;
				break;

			case 1:
				System.out.println("Vamos a ver peliculas");
				showPeliculas();
				break;

			case 2:
				System.out.println("Vamos a ver Series");
				showSeries();
				break;

			case 3:
				System.out.println("Vamos a ver Libros");
				showLibros();
				break;

			case 4:
				System.out.println("Vamos a ver Noticias");
				showNoticias();
				break;
				
			case 5:
				System.out.println("Vamos a ver Reporte");
				showHacerReporte();
				exit = 1;
				break;
				
			case 6:
				System.out.println("Vamos a ver Reporte del dia");
				showHacerReporte(new Date());
				exit = 1;
				break;

			default:
				System.out.println();
				System.out.println("....¡¡Selecciona una opción!!....");
				System.out.println();
				exit = 1;
				break;
			}

		} while (exit != 0);

	}

	static ArrayList<Movie> movies = null;
	public static void showPeliculas() {
		movies = Movie.hacerListaPeliculas();
		int exit = 1;
		
		do {
			System.out.println();
			System.out.println(":: Peliculas ::");
			System.out.println();
			
			/*for (int i = 0; i < movies.size(); i++) {
				System.out.println(i+1 +". "+ movies.get(i).getTitle() + " Visto: " + movies.get(i).isViewed());
			}*/
			
			AtomicInteger atomicInteger = new AtomicInteger(1);
			movies.forEach(m -> System.out.println(atomicInteger.getAndIncrement() + ". "+ m.getTitle() + " Visto: " + m.isViewed()));
			
			System.out.println("0. Para Regresar al menu");
			System.out.println();
			
			/*Leer usuario respuesta*/
			int respuesta = AmazonUtil.validateUserResponseMenu(0, movies.size());

			
			if (respuesta == 0) {
				exit = 0;
				showMenu();
				break;
			}
			if (respuesta > 0)  {
			Movie movieSeleccionado = movies.get(respuesta-1);
			movieSeleccionado.view();
			
			}
			
		} while (exit != 0);
	}

	static ArrayList<Serie> series = Serie.hacerListaSeries();
	public static void showSeries() {
		int exit = 1;

		do {
			System.out.println();
			System.out.println(":: Series ::");
			System.out.println();
			
			for (int i = 0; i < series.size(); i++) {
				System.out.println(i+1 +". "+ series.get(i).getTitle() + " Visto: " + series.get(i).isViewed());
			}
			
			System.out.println("0. Para Regresar al menu");
			System.out.println();
			
			/*Leer usuario respuesta*/
			int respuesta = AmazonUtil.validateUserResponseMenu(0, series.size());

			
			if (respuesta == 0) {
				exit = 0;
				showMenu();
			}
			
			if(respuesta > 0) {
			showCapitulos(series.get(respuesta-1).getCapitulos());
			}
			
		} while (exit != 0);
	}
	
	static ArrayList<Chapter> capitulos = new ArrayList<>();
	public static void showCapitulos(ArrayList<Chapter> caChaptersOfSerieSelected) {
		int exit = 1;
		
		do {
			System.out.println();
			System.out.println(":: Capitulos ::");
			System.out.println();
			
			for (int i = 0; i < caChaptersOfSerieSelected.size(); i++) {
				System.out.println(i+1 +". "+ caChaptersOfSerieSelected.get(i).getTitle() + " Visto: " + caChaptersOfSerieSelected.get(i).isViewed());
			}
			
			System.out.println("0. Regresar al menu");
			System.out.println();
			
			/*Leer usuario respuesta*/
			int respuesta = AmazonUtil.validateUserResponseMenu(0, caChaptersOfSerieSelected.size());

			
			if (respuesta == 0) {
				exit = 0;
			}
			
			if(respuesta > 0) {
				Chapter capituloSeleccionado =  caChaptersOfSerieSelected.get(respuesta-1);
				capituloSeleccionado.view();
			}
		} 
		while (exit != 0);
	}

	static ArrayList<Book> books = Book.hacerListaLibros();
	public static void showLibros() {
		int exit = 1;
		
		do {
			System.out.println();
			System.out.println(":: BOOKS ::");
			System.out.println();
			
			for (int i = 0; i < books.size(); i++) { //1. Book 1
				System.out.println(i+1 + ". " + books.get(i).getTitle() + " Leido: " + books.get(i).isReaded());
			}
			
			System.out.println("0. Regresar al Menu");
			System.out.println();

			/*Leer usuario respuesta*/
			Scanner sc = new Scanner(System.in);
			int respuesta = sc.nextInt();
			
			if(respuesta == 0) {
				exit = 0;
				showMenu();
			}
			
			if(respuesta > 0) {
				Book bookSelected = books.get(respuesta-1);
				bookSelected.view();
			}
				
			} while (exit != 0);
		
	}

	public static void showNoticias() {
		int exit = 1;
		
		do {
			System.out.println();
			System.out.println(":: Noticias ::");
			System.out.println();
		} while (exit != 0);
	}
	
	public static void showHacerReporte() {
		Reporte reporte = new Reporte();
		reporte.setNameFile("reporte peliculas");
		reporte.setTitle("\"\\n\"::VISTOS::");
		reporte.setExtension("txt");
		StringBuilder ContentReporte = new StringBuilder();
		
		movies = Movie.hacerListaPeliculas();

		movies.stream().filter(m -> m.getIsViewed()).forEach(m -> ContentReporte.append(m.toString() + "\n"));
		
		//Predicate<Serie> predicate = s -> s.getIsViewed();
		Consumer<Serie> seriesEach = s -> {
			ArrayList<Chapter> chapters = s.getCapitulos();
			chapters.stream().filter(c -> c.getIsViewed()).forEach(C -> ContentReporte.append(C.toString() + "\n"));
		};
		series.stream().forEach(seriesEach);
		
		/*for (Movie movie : movies) {
			if (movie.getIsViewed()) {
			ContentReporte +=  movie.toString() + "\n";	
			
			}
		}*/
		
		reporte.setContent(ContentReporte.toString());
		reporte.hacerReporte();
	}

	
	public static void showHacerReporte(Date fecha) {
		
		SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd");
		String daString = format.format(fecha);
		
		Reporte reporte = new Reporte();
		reporte.setNameFile("reporte peliculas" + daString);
		reporte.setTitle("::VISTOS::");
		reporte.setExtension("txt");
		
		
		String ContentReporte = "";
		for (Movie movie : movies) {
			if (movie.getIsViewed()) {
			ContentReporte += movie.toString();	
			}
		}
		reporte.setContent(ContentReporte);
		reporte.hacerReporte();
	}
}
