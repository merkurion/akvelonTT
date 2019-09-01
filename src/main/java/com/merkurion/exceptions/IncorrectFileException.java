package com.merkurion.exceptions;

public class IncorrectFileException extends RuntimeException {
	public IncorrectFileException() {
		super("Incorrect file to load matrix from it.");
	}
}
