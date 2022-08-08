package com.bruno.alura.stickes;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Nasa {
	
	private String copyright;
	
	private String date;
	
	private String explanation;
	
	private String hdurl;
	
	@JsonProperty("media_type")
	private String mediaType;
	
	@JsonProperty("service_version")
	private String serviceVersion;
	
	private String title;
	
	private String url;

}
