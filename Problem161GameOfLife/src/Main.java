import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	// Incomplete

	public static void main(String[] args) throws IOException {
		File inputFile = new File(args[0]); // the first argument will be the path to a file

		BufferedReader input = new BufferedReader(new FileReader(inputFile)); // create a BufferedReader to read the input from the given file

		CharacterGrid grid = new CharacterGrid(10, 10); // fixed size

		String nextLine = null;
		while ((nextLine = input.readLine()) != null) { // run until there are no more lines of input
			//
		}

		input.close(); // close the reader to free system resources
	}

	private static class CharacterGrid {

		private final int xSize;
		private final int ySize;
		private final Character[][] rawGrid;

		public CharacterGrid(int xSize, int ySize) {
			this.xSize = xSize;
			this.ySize = ySize;
			this.rawGrid = new Character[xSize][ySize];
		}

		public boolean setElement(int x, int y, Character value) {
			if ((x > (xSize - 1)) || (y > (ySize - 1))) { // if the point is out of the bounds of the grid
				return false; // return failure
			}

			rawGrid[x][y] = value; // set the element
			return true; // return success
		}

		public Character getElement(int x, int y) {
			if ((x > (xSize - 1)) || (y > (ySize - 1))) { // if the point is out of the bounds of the grid
				return null; // return null
			}

			return rawGrid[x][y]; // return the
		}
	}

}