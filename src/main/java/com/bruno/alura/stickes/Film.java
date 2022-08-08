package com.bruno.alura.stickes;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Film {

	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("rank")
	private String rank;
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("fullTitle")
	private String fullTitle;
	
	@JsonProperty("year")
	private String year;
	
	@JsonProperty("image")
	private String image;
	
	@JsonProperty("crew")
	private String crew;
	
	@JsonProperty("imDbRating")
	private String imDbRating;
	
	@JsonProperty("imDbRatingCount")
	private String imDbRatingCount;
}
