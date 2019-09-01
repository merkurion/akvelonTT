package com.merkurion.service;

import com.merkurion.entity.BinaryMatrix;

public class BinaryMatrixServiceImpl implements BinaryMatrixService {

	@Override
	public int findLongestSequence(BinaryMatrix binaryMatrix) {
		int rowLongestSequence = findRowColumnLongestSequence(
				binaryMatrix.getNumberOfRows(),
				binaryMatrix.getNumberOfColumns(),
				(firstCycle, secondCycle) -> binaryMatrix.getValue(firstCycle, secondCycle)
		);
		int columnLongestSequence = findRowColumnLongestSequence(
				binaryMatrix.getNumberOfColumns(),
				binaryMatrix.getNumberOfRows(),
				(firstCycle, secondCycle) -> binaryMatrix.getValue(secondCycle, firstCycle)
		);
		return Math.max(rowLongestSequence, columnLongestSequence);
	}

	private int findRowColumnLongestSequence(int firstCycle, int secondCycle, DefineOrderGetValue orderGetValue) {
		int longestSequence = 0;
		for (int i = 0; i < firstCycle; i++) {
			int temp = 0;
			for (int j = 0; j < secondCycle; j++) {
				byte currentValue = orderGetValue.getValue(i, j);
				if (currentValue == 1) {
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

	private interface DefineOrderGetValue {
		byte getValue(int firstCycle, int secondCycle);
	}
}
