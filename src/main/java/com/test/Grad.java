package com.test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Grad {

	@Id
	@GeneratedValue
	private int id;
	private String ime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	
	@Override
	public String toString() {
		return "Grad [id=" + id + ", ime=" + ime + "]";
	}
	
}
