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
			String[] splitInput = nextLine.split(", "); // since the input is two strings separated by a comma and a space, place both strings in an array
			String string = splitInput[0]; // the first element in the array is the string
			String toRemove = splitInput[1]; // the second element is a string containing all the characters to remove from the string

			StringBuilder result = new StringBuilder(); // create a new StringBuilder to store the result as we build it
			for (char c : string.toCharArray()) { // for each character in the string
				if (!toRemove.contains(String.valueOf(c))) { // if c is not in the string containing the characters to remove
					result.append(c); // add it to the result string
				}
			}

			System.out.println(result.toString()); // print the string after removals
		}

		input.close(); // close the reader to free system resources
	}

}