package com.musicmanager.dto;

/**
 * Provides a base for other DTOs to build upon
 * 
 * @author Void Wind
 * @version 1.1
 * @param <T>
 * @since 2021-07-12
 */
public abstract class AbstractDTO<T> {

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
