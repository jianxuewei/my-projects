package org.fxsw.vo;

public class Course {
	private String name;
	private String date;
	private String describe;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(String name, String date, String describe) {
		super();
		this.name = name;
		this.date = date;
		this.describe = describe;
	}
	
}
