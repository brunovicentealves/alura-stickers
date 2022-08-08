package com.bruno.alura.stickes;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ContentExtratorNasa implements ExtratorContent {

	@Override
	public List<Content> extractContent(String json) {

		List<Content> listContent = new ArrayList<>();
		try {
			final ObjectMapper objectMapper = new ObjectMapper();

			Nasa[] listNasa = objectMapper.readValue(json, Nasa[].class);

			for (Nasa nasa : listNasa) {

				listContent.add(new Content(nasa.getTitle(), nasa.getUrl()));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return listContent;

	}

}
