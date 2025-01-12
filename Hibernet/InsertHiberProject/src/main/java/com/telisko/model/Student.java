package com.telisko.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="studentTable")
public class Student {
	 @Id
	 @Column(name="SID")
    private int sid;
	 @Column(name="SNAME")
    private String sName;
	 @Column(name="SCITY")
    private String  scity;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getScity() {
		return scity;
	}
	public void setScity(String scity) {
		this.scity = scity;
	}
  public Student() {
	  super();
	  System.out.println("noon-parameterise constructor  ");
  }
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sName=" + sName + ", scity=" + scity + "]";
	}
}
