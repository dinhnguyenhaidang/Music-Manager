package com.musicmanager.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * AbstractDTO provides a base for other DTOs to build upon
 * 
 * @author Void Wind
 * @version 1.0
 * @param <T>
 * @since 2021-07-05
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
