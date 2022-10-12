package com.bean;

import java.util.Objects;

public class StatusTable {
	int status_id;
	int template_id;
	int user_id;
	int topic_id;

	

	public int getStatus_id() {
		return status_id;
	}

	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}

	public int getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(int template_id) {
		this.template_id = template_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getTopic_id() {
		return topic_id;
	}

	public void setTopic_id(int topic_id) {
		this.topic_id = topic_id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StatusTable other = (StatusTable) obj;
		return status_id == other.status_id && template_id == other.template_id && topic_id == other.topic_id
				&& user_id == other.user_id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(status_id, template_id, topic_id, user_id);
	}

	@Override
	public String toString() {
		return "StatusTable [status_id=" + status_id + ", template_id=" + template_id + ", user_id=" + user_id
				+ ", topic_id=" + topic_id + "]";
	}
}
