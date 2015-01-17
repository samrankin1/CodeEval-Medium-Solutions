import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		File inputFile = new File(args[0]); // the first argument will be the path to a file

		BufferedReader input = new BufferedReader(new FileReader(inputFile)); // create a BufferedReader to read the input from the given file

		String nextLine = null;
		while ((nextLine = input.readLine()) != null) { // run until there are no more lines of input

			ArrayList<Character> nonRepeatedChars = new ArrayList<Character>(nextLine.length()); // create an ArrayList to store the non-repeated characters
			ArrayList<Character> repeatedChars = new ArrayList<Character>(nextLine.length()); // create an ArrayList to store the repeated characters

			for (char c : nextLine.toCharArray()) { // for each character in the input string
				if (repeatedChars.contains(c)) { // if this character has already been repeated
					continue; // ignore it
				}

				if (nonRepeatedChars.contains(c)) { // if this character has been seen once before
					nonRepeatedChars.remove((Character) c); // remove the character because it is now repeated
					repeatedChars.add(c); // add it to the list of repeated characters
					continue; // continue to the next character
				}

				nonRepeatedChars.add(c); // if this character is being seen for the first time, add it too the list on non-repeated characters

			}

			if (nonRepeatedChars.isEmpty()) { // if no non-repeated characters were found
				System.out.println(); // print a blank line
			} else { // otherwise
				System.out.println(nonRepeatedChars.get(0)); // print the first non-repeated character
			}
		}

		input.close(); // close the reader to free system resources
	}

}
