package com.bruno.alura.stickes;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class AluraStickesApplication {
	
	
	

	public static void main(String[] args) throws Exception{
		SpringApplication.run(AluraStickesApplication.class, args);
		
		
		// fazer um http e buscar os tops 250 filmes
		
		
		
		String url ="https://api.mocki.io/v2/549a5d8b";
		
		URI endereco  = URI.create(url);
		
		HttpClient client = HttpClient.newHttpClient();
	
		HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
		
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		
		String body = response.body();
		
		System.out.println(body);
		
		
		
		//extrair sp ps dadps omteressa,(titulo,poster,classificação)
		
		/**
		JsonParser jsonParser = new JsonParser();
		
		List<Map<String,String>> listFilms = jsonParser.parse(body);
		**/
		
		String json =body.replace("{\"items\":",""); 
		json =json.replace(",\"errorMessage\":\"\"}","");
		final ObjectMapper objectMapper = new ObjectMapper();
		Film[] films = objectMapper.readValue(json, Film[].class);
		
		
		//exibir e manipular os dados 
		

		GeneratorFigurines figurines = new GeneratorFigurines();
		
		for (Film film : films) {
			
			String urlImage=film.getImage();
			
			String title = film.getTitle();
			
			String fileName = title +".jpg";
			
			InputStream inputStream = new URL(urlImage).openStream();
			
			figurines.createFigurines(inputStream,fileName);
			
			System.out.println("Title :"+film.getTitle());
			System.out.println("Image :"+film.getImage());
			System.out.println("imgDbRating :"+film.getImDbRating());
			System.out.println();
		}
		

	}

}
