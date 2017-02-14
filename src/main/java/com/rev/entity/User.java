package com.rev.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
//@NamedQuery(name = "User.findByPreferredname", query = "SELECT u FROM user u WHERE u.preferredname = ?1")
@Table(name="user")
public class User {

	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getPreferredname() {
		return preferredname;
	}
	public void setPreferredname(String preferredname) {
		this.preferredname = preferredname;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid;
    private int status;
    private String preferredname;
    


}
