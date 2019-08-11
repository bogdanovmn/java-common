package com.github.bogdanovmn.common.spring.menu;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "menu")
@Data
public class MenuConfiguration {
	private List<Item> items;

	@Data
	public static class Item {
		private String id;
		private String title;
		private String note;
		private String url;
		private String role;
		private List<Item> items;

		public boolean hasRole() {
			return role != null;
		}

	}
}
