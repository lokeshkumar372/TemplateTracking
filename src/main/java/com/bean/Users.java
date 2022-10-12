package com.bean;

import java.util.Objects;

public class Users {
	int user_id;
	String user_name;
	String user_email;
	String password;
	String role;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getuser_email() {
		return user_email;
	}

	public void setuser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", user_name=" + user_name + ", user_email=" + user_email + ", password="
				+ password + ", role=" + role + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(user_email, password, role, user_id, user_name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(user_email, other.user_email) && Objects.equals(password, other.password)
				&& Objects.equals(role, other.role) && user_id == other.user_id
				&& Objects.equals(user_name, other.user_name);
	}

}
