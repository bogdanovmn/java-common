package com.github.bogdanovmn.common.spring.menu;

import lombok.Setter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Setter
public class MenuBuilder {
	private MenuConfiguration configuration;
	private MenuItem selectedItem;
	private UserAuthorization user;

	public MenuBuilder(MenuConfiguration configuration) {
		this.configuration = configuration;
	}

	public Menu build() {
		Assert.notNull(selectedItem, "Selected item");
		Assert.notNull(user, "Current user");
		return Menu.fromConfiguration(configuration, selectedItem, user);
	}
}
