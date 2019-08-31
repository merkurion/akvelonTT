package service;

import entity.BinaryMatrix;

public class BinaryMatrixServiceImpl implements BinaryMatrixService {

	public int findLongestSequence(BinaryMatrix binaryMatrix) {
		return Math.max(findRowLongestSequence(binaryMatrix), findColumnLongestSequence(binaryMatrix));
	}

	public int findRowLongestSequence(BinaryMatrix binaryMatrix) {
		int longestSequence = 0;
		int rows = binaryMatrix.getNumberOfRows();
		int columns = binaryMatrix.getNumberOfColumns();
		for (int i = 0; i < rows; i++) {
			int temp = 0;
			for (int j = 0; j < columns; j++) {
				if (binaryMatrix.getValue(i, j) == 1) {
					temp++;
				} else {
					longestSequence = Math.max(longestSequence, temp);
					temp = 0;
				}
			}
			longestSequence = Math.max(longestSequence, temp);
		}

		return longestSequence;
	}

	public int findColumnLongestSequence(BinaryMatrix binaryMatrix) {
		int longestSequence = 0;
		int rows = binaryMatrix.getNumberOfRows();
		int columns = binaryMatrix.getNumberOfColumns();
		for (int j = 0; j < columns; j++) {
			int temp = 0;
			for (int i = 0; i < rows; i++) {
				if (binaryMatrix.getValue(i, j) == 1) {
					temp++;
				} else {
					longestSequence = Math.max(longestSequence, temp);
					temp = 0;
				}
			}
			longestSequence = Math.max(longestSequence, temp);
		}

		return longestSequence;
	}

}
