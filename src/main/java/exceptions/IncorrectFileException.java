package exceptions;

import java.io.IOException;

public class IncorrectFileException extends IOException {
	public IncorrectFileException() {
		super("Incorrect file to load matrix from it.");
	}
}
