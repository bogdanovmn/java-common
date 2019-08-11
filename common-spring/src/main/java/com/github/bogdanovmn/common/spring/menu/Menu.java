package com.github.bogdanovmn.common.spring.menu;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;


public class Menu {
	@Getter
	private List<Item> items;

	private Menu(List<Item> items) {
		this.items = items;
	}

	static Menu fromConfiguration(MenuConfiguration configuration, MenuItem selectedItem, UserAuthorization user) {
		List<Item> items = prepareItems(configuration.getItems(), selectedItem, user);
		return new Menu(items);
	}

	private static List<Item> prepareItems(List<MenuConfiguration.Item> configItems,
										   MenuItem selectedItem,
										   UserAuthorization user
	) {
		if (configItems == null || configItems.isEmpty()) {
			return null;
		}
		List<Item> items = new ArrayList<>();
		configItems.stream()
			.filter(item -> !item.hasRole() || user.withRole(item.getRole()))
			.forEach(item
				-> items.add(
					Item.builder()
						.id(item.getId())
						.title(item.getTitle())
						.note(item.getNote())
						.url(item.getUrl())
						.selected(item.getId().equals(selectedItem.name()))
						.subMenu(item.getItems() != null)
						.items(
							prepareItems(item.getItems(), selectedItem, user)
						)
					.build()
				)
			);
		return items;
	}
	@Value
	@Builder
	public static class Item {
		private final String id;
		private final String title;
		private final String note;
		private final String url;
		private final boolean selected;
		private final boolean subMenu;
		private final List<Item> items;
	}
}
