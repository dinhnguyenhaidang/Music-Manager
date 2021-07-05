package com.musicmanager.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * AbstractEntity provides a base for other entities to build upon
 * 
 * @author Void Wind
 * @version 1.1
 * @since 2021-07-05
 */
@MappedSuperclass
public abstract class AbstractEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}
	
}
