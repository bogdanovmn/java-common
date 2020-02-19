package com.github.bogdanovmn.common.spring.mvc;

import org.springframework.web.servlet.ModelAndView;

public class Redirect {
	private final String url;

	public Redirect(String url) {
		this.url = url;
	}

	public ModelAndView modelAndView() {
		return new ModelAndView("redirect:" + url);
	}
}
