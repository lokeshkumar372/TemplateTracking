package com;



public class Error{
	
	public static String returnLoginError() {
		return "<div style='color: red'>Sorry Enter the corect details ...!</div>";
	}
	
	public static String returnEmailAlreadyExists() {
		return "<div style='color:red'> Sorry Email already exists ...! </div>";
	}
	
	public static String returnAlreadyDeleted() {
		return "<div style='color: red'>Sorry its already deleted ...!</div>";
	}
	
}
