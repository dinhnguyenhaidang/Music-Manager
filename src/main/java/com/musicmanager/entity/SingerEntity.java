package com.musicmanager.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * SingerEntity defines album entity, its relationships and maps it to table in database
 * 
 * @author Void Wind
 * @version 1.0
 * @since 2021-07-01
 */
@Entity
@Table(name = "singer")
public class SingerEntity extends AbstractEntity {

	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private int age;
	
	@ManyToMany(mappedBy = "singers")
    private List<SongEntity> songs = new ArrayList<>();

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
