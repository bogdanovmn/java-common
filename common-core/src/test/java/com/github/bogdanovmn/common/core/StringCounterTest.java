package com.github.bogdanovmn.common.core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCounterTest {
	@Test
	public void increment() {
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

	@Test
	public void merge() {
		StringCounter counterX = new StringCounter();
		StringCounter counterY = new StringCounter();

		counterX.increment("x", 3);
		counterX.increment("y", 5);
		counterX.increment("z", 10);

		counterY.increment("a", 3);
		counterY.increment("b", 5);
		counterY.increment("z", 10);

		counterX.merge(counterY);

		assertEquals(3, counterX.get("x"));
		assertEquals(5, counterX.get("y"));
		assertEquals(20, counterX.get("z"));
		assertEquals(3, counterX.get("a"));
		assertEquals(5, counterX.get("b"));
	}

}