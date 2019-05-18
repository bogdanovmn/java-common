package com.github.bogdanovmn.common.stream;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class IntegerMapTest {

	@Test(expected = IllegalStateException.class)
	public void shouldThrowDuplicateKeyException() {
		IntegerMap<ObjX> mappedList = new IntegerMap<>(
			Arrays.asList(
				new ObjX(1, "y1"),
				new ObjX(1, "y11"),
				new ObjX(2, "y2")
			),
			ObjX::getX
		);

		assertEquals("y1", mappedList.get(1).getY());
	}

	@Test
	public void shouldCreateFromUniqueKeys() {
		IntegerMap<ObjX> mappedList = new IntegerMap<>(
			Arrays.asList(
				new ObjX(1, "y1"),
				new ObjX(2, "y2")
			),
			ObjX::getX
		);

		assertEquals("y1", mappedList.get(1).getY());
	}

	@Test
	public void shouldCreateFromNonUniqueKeys() {
		IntegerSafeMap<ObjX> mappedList = new IntegerSafeMap<>(
			Arrays.asList(
				new ObjX(1, "y1"),
				new ObjX(1, "y11"),
				new ObjX(2, "y2")
			),
			ObjX::getX
		);

		assertEquals("y11", mappedList.get(1).getY());
	}

	static class ObjX {
		private final Integer x;
		private final String y;

		private ObjX(Integer x, String y) {
			this.x = x;
			this.y = y;
		}

		Integer getX() {
			return x;
		}

		String getY() {
			return y;
		}
	}
}