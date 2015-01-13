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
			String[] splitInput = nextLine.split(","); // since the input is two string separated by a comma, split the line into an array of the two parts
			String string = splitInput[0]; // the first element in the array is the string we're checking
			String search = splitInput[1]; // the second element in the array string we're searching for

			if (search.length() > string.length()) { // if the search string is longer than the actual string
				System.out.println("0"); // the actual string can't end with the search string
				continue; // continue to the next input
			}

			String end = string.substring((string.length() - search.length()), string.length()); // the substring that contains the last X characters of the string, where X is the length of the search string

			if (end.equals(search)) { // if the end of the string is equal to the string we're checking for
				System.out.println("1"); // print true
			} else { // otherwise
				System.out.println("0"); // print false
			}
		}

		input.close(); // close the reader to free system resources
	}

}