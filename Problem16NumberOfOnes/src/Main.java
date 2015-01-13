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
			int number = Integer.parseInt(nextLine); // parse the input integer

			String binaryString = Integer.toBinaryString(number); // convert the integer to a binary string
			int count = 0; // this number stores the count of 1s in the binary string
			for (char c : binaryString.toCharArray()) { // for each character in the binary string
				if (c == '1') { // if the character is a 1
					count++; // count it
				}
			}

			System.out.println(count); // print the result
		}

		input.close(); // close the reader to free system resources
	}

}