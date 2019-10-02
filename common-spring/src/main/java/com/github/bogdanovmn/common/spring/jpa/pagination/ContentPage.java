package com.github.bogdanovmn.common.spring.jpa.pagination;

import org.springframework.data.domain.Page;

import java.util.List;

public class ContentPage<ContentType> {
	private final Page<ContentType> currentPage;
	private final String url;

	public ContentPage(Page<ContentType> currentPage, String url) {
		this.currentPage = currentPage;
		this.url = url;
	}

	public List<ContentType> content() {
		return currentPage.getContent();
	}

	public PaginationBar paginationBar() {
		return PaginationBar.builder()
			.currentPage(currentPage.getNumber())
			.totalPages(currentPage.getTotalPages())
			.url(url)
		.build();
	}
}
