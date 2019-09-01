package com.merkurion.entity;

public class BinaryMatrix {

	private final byte[][] matrix;

	public BinaryMatrix(byte[][] matrixInput) {
		this.matrix = matrixInput;
	}

	public int getNumberOfRows() {
		return this.matrix.length;
	}

	public int getNumberOfColumns() {
		if (getNumberOfRows() > 0) {
			return this.matrix[0].length;
		}
		return 0;
	}

	public byte getValue(int row, int column) {
		return this.matrix[row][column];
	}
}
