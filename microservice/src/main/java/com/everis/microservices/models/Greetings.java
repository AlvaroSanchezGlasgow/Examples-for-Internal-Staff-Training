package com.everis.microservices.models;

public class Greetings {
	
	private final long id;
	private final String content;
	
	/**
	 * 
	 * @param id
	 * @param content
	 */
	public Greetings(long id, String content) {
		this.id = id;
		this.content = content;
	}
	
	//Getters and Setters
	
	/**
	 * 
	 * @return
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getContent() {
		return content;
	}
	

}
