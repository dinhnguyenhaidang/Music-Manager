package com.musicmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Defines album entity, its relationships and maps it to the corresponding table in database
 * 
 * @author Void Wind
 * @version 1.1
 * @since 2021-07-12
 */
@Entity
@Table(name = "album")
public class AlbumEntity extends AbstractEntity {

	@Column(name = "name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
