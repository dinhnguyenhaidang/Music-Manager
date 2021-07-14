package com.musicmanager.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Defines singer entity, its relationships and maps it to the corresponding
 * table in database
 * 
 * @author Void Wind
 * @version 1.1
 * @since 2021-07-12
 */
@Entity
@Table(name = "singer")
public class SingerEntity extends AbstractEntity {

	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private int age;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "song_singer", joinColumns = @JoinColumn(name = "singer_id"), inverseJoinColumns = @JoinColumn(name = "song_id"))
	private List<SongEntity> songs;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<SongEntity> getSongs() {
		return songs;
	}

	public void setSongs(List<SongEntity> songs) {
		this.songs = songs;
	}

}
