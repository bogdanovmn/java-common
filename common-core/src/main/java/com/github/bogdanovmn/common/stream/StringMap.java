package com.github.bogdanovmn.common.stream;

import java.util.Collection;
import java.util.function.Function;

public class StringMap<T> extends CollectionMap<String, T> {
//	public StringMap(Map<String, T> map) {
//		super(map);
//	}
//
	public StringMap(Collection<T> collection, Function<T, String> keyFunc) {
		super(collection, keyFunc);
	}

//	public static <V> StringMap<V> fromNonUniqueKeys(Collection<V> collection, Function<V, String> keyFunc) {
//		return new StringMap<>(
//			collection.stream()
//				.collect(Collectors.toMap(
//					keyFunc,
//					x -> x,
//					(prev, curr) -> curr
//				))
//		);
//	}
//
//	public StringMap(Collection<T> collection, Function<T, String> keyFunc) {
//		super(
//			collection.stream()
//				.collect(Collectors.toMap(
//					keyFunc, x -> x
//				))
//		);
//	}
//
//	public static <T> StringMap<T> fromNonUniqueKeys(Collection<T> collection, Function<T, String> keyFunc) {
//		return new StringMap<>(
//			collection.stream()
//				.collect(Collectors.toMap(
//					keyFunc,
//					x -> x,
//					(prev, curr) -> curr
//				))
//		);
//	}

}
