package com.example.beercatalogservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;





@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Beer {
	
	public Beer(String name) {
	      this.name = name;
	    }

	@Id
    @GeneratedValue
    private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Beer [id=" + id + ", name=" + name + "]";
	}

	private String name;
	
	

	
 


}
