package com.gr.common.domain;

public class TestDomain {
	private String id;// id����
	private String username;// �û���
	private String password;// ����
	private String age;// ����
	private String sex;// �Ա�
	private String emaill;// ����
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmaill() {
		return emaill;
	}
	public void setEmaill(String emaill) {
		this.emaill = emaill;
	}
	@Override
	public String toString() {
		return "TestDomain [id=" + id + ", username=" + username
				+ ", password=" + password + ", age=" + age + ", sex=" + sex
				+ ", emaill=" + emaill + "]";
	}
}
