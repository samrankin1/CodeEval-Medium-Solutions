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
			String lowercaseInput = nextLine.toLowerCase(); // since case doesn't matter, we will work in all lowercase

			ArrayList<Character> missingLetters = new ArrayList<Character>();

			for (char c = 'a'; c <= 'z'; c++) { // for each character a through z, we can do this because chars are also numbers
				if (!lowercaseInput.contains(String.valueOf(c))) { // if the string doesn't contain this letter
					missingLetters.add(c); // add it to the list of missing letters
				}
			}

			if (missingLetters.isEmpty()) { // if there are no missing letters
				System.out.println("NULL"); // print NULL
			} else { // otherwise
				StringBuilder result = new StringBuilder(); // create a StringBuilder to store the result string while we build it
				for (Character letter : missingLetters) { // for each letter in the list of missing letters
					result.append(letter); // add this letter to the result string
				}

				System.out.println(result.toString()); // print out the result string
			}
		}

		input.close(); // close the reader to free system resources
	}

}