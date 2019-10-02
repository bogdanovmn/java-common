package com.github.bogdanovmn.common.text;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TruncatedTextTest {

	@Test
	public void shouldCutesLinesFirst() {
		TruncatedText truncatedText = new TruncatedText(
			"a\nb\nc\nd", 2, 100
		);

		assertThat(
			truncatedText.value(),
			is("a\nb")
		);
	}

	@Test
	public void shouldCutesCharsSecond() {
		TruncatedText truncatedText = new TruncatedText(
			"a\nb\nc\nd", 100, 3
		);

		assertThat(
			truncatedText.value(),
			is("a\nb")
		);
	}

	@Test
	public void shouldNotCutes() {
		TruncatedText truncatedText = new TruncatedText(
			"a\nb\nc\nd", 100, 100
		);

		assertThat(
			truncatedText.value(),
			is("a\nb\nc\nd")
		);
	}
}