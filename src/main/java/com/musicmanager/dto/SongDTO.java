package com.musicmanager.dto;

/**
 * This class create song objects carrying data between processes
 * 
 * @author Void Wind
 * @version 1.0
 * @since 2021-06-30
 */
public class SongDTO {
	
	private String title;
	private String singer;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

}
