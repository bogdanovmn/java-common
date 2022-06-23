package com.github.bogdanovmn.common.spring.jpa;

import java.util.HashMap;
import java.util.Map;

public class EntityRepositoryMapFactory {
	private final Map<Class<? extends BaseEntityWithUniqueName>, BaseEntityWithUniqueNameRepository<?>> map;

	public EntityRepositoryMapFactory(Map<Class<? extends BaseEntityWithUniqueName>, BaseEntityWithUniqueNameRepository<?>> map) {
		this.map = map;
	}

	public BaseEntityWithUniqueNameRepository<?> getRepository(Class<? extends BaseEntityWithUniqueName> aClass) {
		return this.map.get(aClass);
	}

	public static class Builder {
		private final Map<Class<? extends BaseEntityWithUniqueName>, BaseEntityWithUniqueNameRepository<?>> map = new HashMap<>();

		public Builder map(Class<? extends BaseEntityWithUniqueName> key, BaseEntityWithUniqueNameRepository<?> value) {
			map.put(key, value);
			return this;
		}

		public EntityRepositoryMapFactory build() {
			return new EntityRepositoryMapFactory(map);
		}
	}
}
