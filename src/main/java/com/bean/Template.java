package com.bean;

import java.util.Objects;

public class Template implements Comparable{
	int template_id;
	String template_name;
public static Template getTemplate(int id,String name) {
	Template t=new Template();
	t.setTemplate_id(id);
	t.setTemplate_name(name);
	return t;
}
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

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Template t=(Template)o;
		return this.template_name.compareTo(t.template_name);
	}

	
}
