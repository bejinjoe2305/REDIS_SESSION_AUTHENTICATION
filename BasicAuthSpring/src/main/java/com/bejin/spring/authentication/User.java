package com.bejin.spring.authentication;

import java.io.Serializable;


public class User implements Serializable {

   
    private Long id;
    private String name;

    public User() {
    }

    public User(String name, long id) {
        this.name = name;
        this.id = id;
    }

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

    //standard getters and setters

    
}