package com.github.bogdanovmn.common.spring;

import java.util.Map;

public class EntityRepositoryMapFactory {
	private final Map<Class<? extends BaseEntityWithUniqueName>, BaseEntityWithUniqueNameRepository> map;

	public EntityRepositoryMapFactory(Map<Class<? extends BaseEntityWithUniqueName>, BaseEntityWithUniqueNameRepository> map) {
		this.map = map;
	}

	public BaseEntityWithUniqueNameRepository getRepository(Class<? extends BaseEntityWithUniqueName> aClass) {
		return this.map.get(aClass);
	}
}
