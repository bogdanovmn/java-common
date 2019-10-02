package com.github.bogdanovmn.common.spring.jpa.pagination;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PaginationBar {
	private final int currentPage;
	private final int totalPages;
	private final String url;

	public boolean isMoreThanOnePage() {
		return totalPages > 1;
	}

	public boolean hasPreviousPage() {
		return currentPage > 1;
	}

	public int previousPage() {
		return currentPage - 1;
	}

	public boolean hasNextPage() {
		return currentPage < totalPages;
	}

	public int nextPage() {
		return currentPage + 1;
	}

	public boolean isFirstPageLinkVisible() {
		return currentPage > 2;
	}

	public boolean isLastPageLinkVisible() {
		return (totalPages - currentPage) > 2;
	}
}
