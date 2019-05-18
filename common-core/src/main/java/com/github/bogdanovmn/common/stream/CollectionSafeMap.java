package com.github.bogdanovmn.common.stream;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionSafeMap<K, V> extends HashMap<K, V> {

	public CollectionSafeMap(Map<K, V> map) {
		super(map);
	}

	public CollectionSafeMap(Collection<V> collection, Function<V, K> keyFunc) {
		super(
			collection.stream()
				.collect(Collectors.toMap(
					keyFunc,
					x -> x,
					(prev, curr) -> curr
				))
		);
	}
}
