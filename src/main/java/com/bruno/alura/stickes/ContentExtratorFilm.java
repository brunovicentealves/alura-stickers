package com.bruno.alura.stickes;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ContentExtratorFilm implements ExtratorContent {

	@Override
	public List<Content> extractContent(String json) {

		List<Content> listContent = new ArrayList<>();
		try {

			String requestJson = json.replace("{\"items\":", "");

			requestJson = requestJson.replace(",\"errorMessage\":\"\"}", "");
			final ObjectMapper objectMapper = new ObjectMapper();

			// List<Film> listFilms = objectMapper.readValue(requestJson, new
			// TypeReference<List<Film>>(){});

			Film[] listFilms = objectMapper.readValue(requestJson, Film[].class);

			for (Film films : listFilms) {

				listContent.add(new Content(films.getTitle(), films.getImage()));
			}

		} catch (Exception e) {

		}

		return listContent;
	}

}
