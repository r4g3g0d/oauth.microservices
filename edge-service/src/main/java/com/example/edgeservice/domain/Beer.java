package com.example.edgeservice.domain;

import lombok.Data;

@Data
public class Beer {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Beer() {
		super();
	}

	public Beer(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Beer [name=" + name + "]";
	}

	
}
