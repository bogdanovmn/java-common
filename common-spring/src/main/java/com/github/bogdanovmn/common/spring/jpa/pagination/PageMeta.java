package com.github.bogdanovmn.common.spring.jpa.pagination;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;

import java.util.Map;

@Value
@Builder
public class PageMeta {
	private final int number;
	private final String sortBy;
	private final String baseUrl;
	@Singular
	private final Map<String, Object> parameters;

	public boolean hasParameters() {
		return parameters !=null && !parameters.isEmpty();
	}
}
