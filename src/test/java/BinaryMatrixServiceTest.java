import static org.junit.Assert.assertEquals;

import org.junit.Test;

import entity.BinaryMatrix;
import service.BinaryMatrixServiceImpl;

public class BinaryMatrixServiceTest {

	@Test
	public void testBinaryMatrixFromTask() {
		byte[][] binaryMatrixFromTask =
				{{0, 0, 0, 1, 0, 0},
				{1, 0, 1, 1, 0, 1},
				{0, 0, 0, 1, 0, 0}
		};

		BinaryMatrix binaryMatrix = new BinaryMatrix(binaryMatrixFromTask);
		BinaryMatrixServiceImpl binaryMatrixService = new BinaryMatrixServiceImpl();
		int result = binaryMatrixService.findLongestSequence(binaryMatrix);
		assertEquals(3, result);
	}

}
