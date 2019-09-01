package com.merkurion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.merkurion.entity.BinaryMatrix;
import com.merkurion.exceptions.IncorrectFileException;
import com.merkurion.service.BinaryMatrixServiceImpl;

public class Main {

	public static void main(String[] args) throws IOException {
		BinaryMatrix binaryMatrix = new BinaryMatrix(createBinaryMatrixFromFile(args[0]));
		BinaryMatrixServiceImpl binaryMatrixService = new BinaryMatrixServiceImpl();
		System.out.println(binaryMatrixService.findLongestSequence(binaryMatrix));
	}

	private static byte[][] createBinaryMatrixFromFile(String fileName) throws IOException {
		int rows = 0;
		int columns = 0;

		ArrayList<String[]> fileStrings = new ArrayList<>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
			Scanner sc = new Scanner(bufferedReader);
			while (sc.hasNextLine()) {
				rows++;
				String[] line = sc.nextLine().trim().split(" ");
				fileStrings.add(line);
				if (columns == 0) {
					columns = line.length;
				} else if (columns != line.length) {
					throw new IncorrectFileException();
				}
			}
			sc.close();

			byte[][] matrixInput = new byte[rows][columns];
			for (int i = 0; i < fileStrings.size(); i++) {
				String[] line = fileStrings.get(i);
				for (int j = 0; j < line.length; j++) {
					matrixInput[i][j] = Byte.parseByte(line[j]);
				}
			}
			return matrixInput;
		}
	}
}
