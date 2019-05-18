package com.github.bogdanovmn.common.stream;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class StringMapTest {

	@Test(expected = IllegalStateException.class)
	public void shouldThrowDuplicateKeyException() {
		StringMap<ObjX> mappedList = new StringMap<>(
			Arrays.asList(
				new ObjX("x1", "y1"),
				new ObjX("x1", "y11"),
				new ObjX("x2", "y2")
			),
			ObjX::getX
		);

		assertEquals("y1", mappedList.get("x1").getY());
	}

	@Test
	public void shouldCreateFromUniqueKeys() {
		StringMap<ObjX> mappedList = new StringMap<>(
			Arrays.asList(
				new ObjX("x1", "y1"),
				new ObjX("x2", "y2")
			),
			ObjX::getX
		);

		assertEquals("y1", mappedList.get("x1").getY());
	}

	@Test
	public void shouldCreateFromNonUniqueKeys() {
		StringSafeMap<ObjX> mappedList = new StringSafeMap<>(
			Arrays.asList(
				new ObjX("x1", "y1"),
				new ObjX("x1", "y11"),
				new ObjX("x2", "y2")
			),
			ObjX::getX
		);

		assertEquals("y11", mappedList.get("x1").getY());
	}

	static class ObjX {
		private final String x;
		private final String y;

		private ObjX(String x, String y) {
			this.x = x;
			this.y = y;
		}

		String getX() {
			return x;
		}

		String getY() {
			return y;
		}
	}
}