package org.cloud.user.client.model;

import java.io.Serializable;

public class User implements Serializable{

	/**
	 * user
	 */
	private static final long serialVersionUID = 2397810970989757766L;

	private String id;
	private String name;
	private String password;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
