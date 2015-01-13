import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		File inputFile = new File(args[0]); // the first argument will be the path to a file

		BufferedReader input = new BufferedReader(new FileReader(inputFile)); // create a BufferedReader to read the input from the given file

		String nextLine = null;
		while ((nextLine = input.readLine()) != null) { // run until there are no more lines of input
			int inputIngeger = Integer.parseInt(nextLine); // parse the input integer
			String binaryString = Integer.toBinaryString(inputIngeger); // convert the input integer to a binary string
			System.out.println(binaryString); // print the binary string
		}

		input.close(); // close the reader to free system resources
	}

}