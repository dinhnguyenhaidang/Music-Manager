package com.musicmanager.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Defines song entity, its relationships and maps it to the corresponding table
 * in database
 * 
 * @author Void Wind
 * @version 1.2
 * @since 2021-07-12
 */
@Entity
@Table(name = "song")
public class SongEntity extends AbstractEntity {

	@Column(name = "title")
	private String title;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "album_id")
	private AlbumEntity album;

	@Column(name = "category")
	private String category;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "song_singer", joinColumns = @JoinColumn(name = "song_id"), inverseJoinColumns = @JoinColumn(name = "singer_id"))
	private List<SingerEntity> singers = new ArrayList<>();

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

	public List<SingerEntity> getSingers() {
		return singers;
	}

	public void setSingers(List<SingerEntity> singers) {
		this.singers = singers;
	}

}
