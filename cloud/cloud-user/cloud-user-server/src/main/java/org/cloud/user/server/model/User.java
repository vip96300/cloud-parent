package org.cloud.user.server.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class User extends BaseModel implements Serializable{

	/**
	 * user
	 */
	private static final long serialVersionUID = 2397810970989757766L;
	
	@Id
	@GeneratedValue
	private String id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
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
