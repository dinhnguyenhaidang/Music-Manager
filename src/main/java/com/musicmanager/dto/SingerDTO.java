package com.musicmanager.dto;

import java.util.List;

/**
 * Creates singer data transfer objects that carry data between processes
 * 
 * @author Void Wind
 * @version 1.1
 * @since 2021-07-12
 */
public class SingerDTO extends AbstractDTO<SingerDTO> {

	private String name;
	private int age;
	private List<Long> songIds;

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

	public List<Long> getSongIds() {
		return songIds;
	}

	public void setSongIds(List<Long> songIds) {
		this.songIds = songIds;
	}

}
