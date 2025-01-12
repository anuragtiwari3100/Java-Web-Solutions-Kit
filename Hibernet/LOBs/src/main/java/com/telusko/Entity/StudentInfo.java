package com.telusko.Entity;

import javax.annotation.processing.Generated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="CollageTable")
public class StudentInfo{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int sid;

	private String sname;

	private String scity;
	
	
	
	@Lob
  private byte image[];
	@Lob
  private  char textFil[];
	
public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public char[] getTextFil() {
		return textFil;
	}
	public void setTextFil(char[] textFil) {
		this.textFil = textFil;
	}

	public StudentInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return sid;
	}
	public void setId(int id) {
		this.sid = id;
	}
	public String getName() {
		return sname;
	}

	public void setName(String name) {
		this.sname = name;
	}
	public String getCity() {
		return scity;
	}
	public void setCity(String city) {
		this.scity = city;
	}
	@Override
	public String toString() {
		return "Student [id=" + sid + ", name=" + sname + ", city=" + scity + "]";
	}

}
