package com.github.bogdanovmn.common.core;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ObjCounter<KeyType> {
	private final Map<KeyType, Long> counter = new HashMap<>();

	public void increment(KeyType obj, long value) {
		counter.put(
			obj,
			counter.getOrDefault(obj, 0L) + value
		);
	}

	public void increment(KeyType obj) {
		increment(obj, 1);
	}

	public Set<KeyType> keys() {
		return Collections.unmodifiableSet(
			counter.keySet()
		);
	}

	public long get(KeyType obj) {
		return counter.getOrDefault(obj, 0L);
	}

	public void remove(KeyType obj) {
		counter.remove(obj);
	}
}
