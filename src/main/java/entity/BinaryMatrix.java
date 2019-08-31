package entity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import exceptions.IncorrectFileException;

public class BinaryMatrix {

	private final byte[][] matrix;

	public BinaryMatrix(byte[][] matrixInput) {
		this.matrix = matrixInput;
	}

	public BinaryMatrix(String fileName) throws FileNotFoundException, IncorrectFileException {
		int rows = 0;
		int columns = 0;

		Scanner scCalcLength = new Scanner(new BufferedReader(new FileReader(fileName)));
		while (scCalcLength.hasNextLine()) {
			rows++;
			String[] line = scCalcLength.nextLine().trim().split(" ");
			if (columns == 0) {
				columns = line.length;
			} else if (columns != line.length) {
				throw new IncorrectFileException();
			}
		}
		scCalcLength.close();

		byte[][] matrixInput = new byte[rows][columns];
		Scanner sc = new Scanner(new BufferedReader(new FileReader(fileName)));
		while (sc.hasNextLine()) {
			for (int i = 0; i < matrixInput.length; i++) {
				String[] line = sc.nextLine().trim().split(" ");
				for (int j = 0; j < line.length; j++) {
					matrixInput[i][j] = Byte.parseByte(line[j]);
				}
			}
		}
		sc.close();

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
