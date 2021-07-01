package com.musicmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * This class defines song entity and map it to table in database
 * 
 * @author Void Wind
 * @version 1.0
 * @since 2021-07-01
 */
@Entity
@Table(name = "song")
public class SongEntity extends BaseEntity {
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "albumid")
	private Long albumId;
	
	@Column(name = "singer")
	private String singer;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Long albumId) {
		this.albumId = albumId;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

}
