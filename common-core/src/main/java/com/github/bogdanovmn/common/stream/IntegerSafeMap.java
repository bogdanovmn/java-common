package com.github.bogdanovmn.common.stream;

import java.util.Collection;
import java.util.function.Function;

public class IntegerSafeMap<T> extends CollectionSafeMap<Integer, T> {

	public IntegerSafeMap(Collection<T> collection, Function<T, Integer> keyFunc) {
		super(collection, keyFunc);
	}

}
