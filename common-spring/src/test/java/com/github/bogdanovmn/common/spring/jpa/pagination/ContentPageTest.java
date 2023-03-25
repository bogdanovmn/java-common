package com.github.bogdanovmn.common.spring.jpa.pagination;

import org.junit.Test;
import org.springframework.data.domain.Page;

import static org.junit.Assert.assertEquals;

public class ContentPageTest {

	@Test
	public void paginationBar() {
		ContentPage<Object> contentPage = new ContentPage<>(
			Page.empty(),
			PageMeta.builder()
				.baseUrl("/base-url")
				.parameter("param1", 123)
				.parameter("param2", true)
				.number(2)
				.sortBy("name")
			.build()
		);

		PaginationBar paginationBar = contentPage.paginationBar();

		assertEquals(
            "/base-url?param1=123&param2=true&sortBy=name",
            paginationBar.getBaseUrl()
        );
	}
}