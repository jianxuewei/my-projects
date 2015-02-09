package org.fxsw.vo;

public class User {
	private String loginname;
	private String password;
	private String sex;
	private int age;
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String loginname, String password, String sex, int age) {
		super();
		this.loginname = loginname;
		this.password = password;
		this.sex = sex;
		this.age = age;
	}
	

}
