package com.musicmanager.dto;

/**
 * Creates album data transfer objects that carry data between processes
 * 
 * @author Void Wind
 * @version 1.1
 * @since 2021-07-12
 */
public class AlbumDTO extends AbstractDTO<AlbumDTO> {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
