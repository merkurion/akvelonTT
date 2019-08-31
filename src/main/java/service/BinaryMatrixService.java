package service;

import entity.BinaryMatrix;

public interface BinaryMatrixService {

	int findLongestSequence(BinaryMatrix binaryMatrix);

	int findColumnLongestSequence(BinaryMatrix binaryMatrix);

	int findRowLongestSequence(BinaryMatrix binaryMatrix);
}
