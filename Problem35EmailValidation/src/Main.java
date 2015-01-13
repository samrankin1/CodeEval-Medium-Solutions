import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	private static final String EMAIL_REGEX = "^(\\.?[0-9a-z]*?\\.?)*@([0-9a-z]*?)(\\.?[0-9a-z]*?)*$"; // regex for a valid email address

	public static void main(String[] args) throws IOException {
		File inputFile = new File(args[0]); // the first argument will be the path to a file

		BufferedReader input = new BufferedReader(new FileReader(inputFile)); // create a BufferedReader to read the input from the given file

		String nextLine = null;
		while ((nextLine = input.readLine()) != null) { // run until there are no more lines of input
			System.out.println(nextLine.matches(EMAIL_REGEX)); // print if the input matches the email regex
		}

		input.close(); // close the reader to free system resources
	}

}