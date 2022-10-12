package com.bean;

import java.util.Objects;

public class Topic {
	int topic_id;
	int template_id;
	String topic_name;

	public int getTopic_id() {
		return topic_id;
	}

	public void setTopic_id(int topic_id) {
		this.topic_id = topic_id;
	}

	
	public String getTopic_name() {
		return topic_name;
	}

	
	public void setTopic_name(String topic_name) {
		this.topic_name = topic_name;
	}

	@Override
	public String toString() {
		return "Topic [topic_id=" + topic_id + ", template_id=" + template_id + ", topic_name=" + topic_name + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(template_id, topic_id, topic_name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topic other = (Topic) obj;
		return template_id == other.template_id && topic_id == other.topic_id
				&& Objects.equals(topic_name, other.topic_name);
	}

}
