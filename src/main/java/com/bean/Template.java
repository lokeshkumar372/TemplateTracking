package com.bean;

import java.util.Objects;

public class Template {
	int template_id;
	String template_name;

	public int getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(int template_id) {
		this.template_id = template_id;
	}

	public String getTemplate_name() {
		return template_name;
	}
	public void setTemplate_name(String template_name) {
		this.template_name = template_name;
	}
	@Override
	public String toString() {
		return "Template [template_id=" + template_id + ", template_name=" + template_name + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(template_id, template_name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Template other = (Template) obj;
		return template_id == other.template_id && Objects.equals(template_name, other.template_name);
	}

	
}
