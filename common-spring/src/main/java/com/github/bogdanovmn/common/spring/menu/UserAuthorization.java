package com.github.bogdanovmn.common.spring.menu;

public interface UserAuthorization {
	String userName();
	boolean withRole(String role);
}
