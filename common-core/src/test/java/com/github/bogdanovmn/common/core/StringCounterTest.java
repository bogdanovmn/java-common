package com.github.bogdanovmn.common.core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCounterTest {
	@Test
	public void stringCounter() {
		StringCounter counter = new StringCounter();

		counter.increment("x");
		counter.increment("y");
		counter.increment("y", 10);

		assertEquals(1,  counter.get("x"));
		assertEquals(11, counter.get("y"));
		assertEquals(0,  counter.get("z"));

		counter.remove("y");
		assertEquals(counter.get("y"), 0);
	}

}