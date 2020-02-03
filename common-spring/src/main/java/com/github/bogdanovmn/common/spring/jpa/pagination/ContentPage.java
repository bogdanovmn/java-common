package com.github.bogdanovmn.common.spring.jpa.pagination;

import org.springframework.data.domain.Page;

import java.util.List;

public class ContentPage<ContentType> {
	private final Page<ContentType> currentPage;
	private final PageMeta meta;

	public ContentPage(Page<ContentType> currentPage, PageMeta meta) {
		this.currentPage = currentPage;
		this.meta = meta;
	}

	public List<ContentType> content() {
		return currentPage.getContent();
	}

	public PaginationBar paginationBar() {
		StringBuilder queryStringBuilder = new StringBuilder();
		if (meta.hasParameters()) {
			 meta.getParameters().forEach((k, v) -> {
			 	if (v != null) {
					queryStringBuilder.append("&");
					queryStringBuilder.append(k);
					queryStringBuilder.append("=");
					queryStringBuilder.append(v.toString());
				}
			 });
		}
		if (meta.getSortBy() != null) {
			queryStringBuilder.append("&sortBy=").append(meta.getSortBy());
		}
		String queryString = queryStringBuilder.toString();
		if (!queryString.isEmpty()) {
			queryString = queryString.replaceFirst("^&", "?");
		}

		return PaginationBar.builder()
			.currentPage(meta.getNumber())
			.totalPages(currentPage.getTotalPages())
			.baseUrl(meta.getBaseUrl() + queryString)
		.build();
	}
}
