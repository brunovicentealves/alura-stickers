package com.bruno.alura.stickes;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AluraStickesApplication {
	
	
	

	public static void main(String[] args) throws Exception{
		SpringApplication.run(AluraStickesApplication.class, args);
		
		
		// fazer um http e buscar os tops 250 filmes
		
		
		ClientHttp reponseApi = new ClientHttp();
		
		String url ="https://imdb-api.com/en/API/Top250Movies/k_zo4qk3bj";
		
		ContentExtratorFilm content = new ContentExtratorFilm();
		
		//String url ="https://api.nasa.gov/planetary/apod?api_key=y25ASKB6DZC2V3dwgM5Uz0Gf7q2bBBfPYtDQ3rMp&start_date=2022-06-12&end_date=2022-06-14";
		
		//ContentExtratorNasa content = new ContentExtratorNasa();
			
		String body =reponseApi.getResponseBody(url);
	
	
		List<Content> listContent =content.extractContent(body);
		
		GeneratorFigurines figurines = new GeneratorFigurines();
		
		for (Content objectContent : listContent) {
			
			String urlImage=objectContent.getUrlImage();
			
			String title = objectContent.getTitle();
			
			String fileName = title +".jpg";
			
			InputStream inputStream = new URL(urlImage).openStream();
			
			figurines.createFigurines(inputStream,fileName);
			
			System.out.println("Title :"+objectContent.getTitle());
			System.out.println("Image :"+objectContent.getUrlImage());
			System.out.println();
		}
		

	}

}
