import java.io.FileNotFoundException;

import entity.BinaryMatrix;
import exceptions.IncorrectFileException;
import service.BinaryMatrixServiceImpl;

public class Main {
	public static void main(String[] args) {
		BinaryMatrix binaryMatrix = null;
		try {
			binaryMatrix = new BinaryMatrix("ExampleMatrix.txt");
		} catch (FileNotFoundException | IncorrectFileException e) {
			e.printStackTrace();
		}
		if (binaryMatrix != null) {
			BinaryMatrixServiceImpl binaryMatrixService = new BinaryMatrixServiceImpl();
			System.out.println(binaryMatrixService.findLongestSequence(binaryMatrix));
		}
	}
}
