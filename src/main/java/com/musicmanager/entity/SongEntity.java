package com.musicmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * This class defines song entity and map it to table in database
 * 
 * @author Void Wind
 * @version 1.1
 * @since 2021-07-02
 */
@Entity
@Table(name = "song")
public class SongEntity extends BaseEntity {
	
	@Column
	private String title;
	
	@ManyToOne()
	@JoinColumn(name = "albumid")
	private AlbumEntity album;
	
	@Column
	private String category;
	
	@Column
	private String singer;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public AlbumEntity getAlbum() {
		return album;
	}

	public void setAlbum(AlbumEntity album) {
		this.album = album;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}
	
}
