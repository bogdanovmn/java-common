package com.github.bogdanovmn.common.text;

public class TruncatedText {
	private final String originalText;
	private final int maxLines;
	private final int maxChars;

	public TruncatedText(String originalText, int maxLines, int maxChars) {
		this.originalText = originalText;
		this.maxLines = maxLines;
		this.maxChars = Integer.min(maxChars, originalText.length());
	}

	public String value() {
		return originalText.substring(0, cutePosition());
	}

	public boolean truncated() {
		return originalText.length() > cutePosition();
	}

	private int cutePosition() {
		int lines = 0;
		int currentPosition = -1;
		do {
			currentPosition = originalText.indexOf("\n", currentPosition + 1);
			if (currentPosition != -1) {
				lines++;
			}
			else {
				break;
			}
		} while (lines < maxLines);

		if (currentPosition == -1 || currentPosition > maxChars) {
			currentPosition = maxChars;
		}

		return currentPosition;
	}
}
