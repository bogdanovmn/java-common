package com.github.bogdanovmn.common.stream;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionMap<K, V> extends HashMap<K, V> {

	public CollectionMap(Map<K, V> map) {
		super(map);
	}

	public CollectionMap(Collection<V> collection, Function<V, K> keyFunc) {
		super(
			collection.stream()
				.collect(Collectors.toMap(
					keyFunc, x -> x
				))
		);
	}
}
