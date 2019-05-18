package com.github.bogdanovmn.common.stream;

import java.util.Collection;
import java.util.function.Function;

public class IntegerMap<T> extends CollectionMap<Integer, T> {

	public IntegerMap(Collection<T> collection, Function<T, Integer> keyFunc) {
		super(collection, keyFunc);
	}

}
