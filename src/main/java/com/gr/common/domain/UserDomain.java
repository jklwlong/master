package com.gr.common.domain;

public class UserDomain {
	private String id;// id����
	private String username;// �û���
	private String password;// ����
	private String age;// ����
	private String sex;// �Ա�
	private String email;// ����
	private String dsr;
	public String getDsr() {
		return dsr;
	}

	public void setDsr(String dsr) {
		this.dsr = dsr;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserDomain [id=" + id + ", username=" + username + ", password=" + password + ", age=" + age + ", sex="
				+ sex + ", email=" + email + "]";
	}
	
}
