import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		File inputFile = new File(args[0]); // the first argument will be the path to a file

		BufferedReader input = new BufferedReader(new FileReader(inputFile)); // create a BufferedReader to read the input from the given file

		String nextLine = null;
		while ((nextLine = input.readLine()) != null) { // run until there are no more lines of input
			String[] splitInput = nextLine.split(" "); // since the input is a series of words separated by spaces, split the line into an array of its words

			int min = 0; // the starting lower limit is always zero
			int max = Integer.parseInt(splitInput[0]); // the first element in the array is the upper limit of the range

			List<String> words = Arrays.asList(splitInput).subList(1, splitInput.length); // all but the first element in the input array are words we need to process
			for (String word : words) {
				int guess = getMidpoint(min, max); // the next guess is the midpoint of the current minimum and maximum
				
				if (word.equals("Lower")) { // if the guess needs to be lower
					max = (guess - 1); // the new maximum is one less than the guess we just tried
				}
				
				if (word.equals("Higher")) { // if the guess needs to be higer
					min = (guess + 1); // the new minimum is one more than the guess we just tried
				}
				
				if (word.equals("Yay!")) { // if this guess is correct
					System.out.println(guess); // print out the correct number
					break; // stop looping
				}
			}
		}

		input.close(); // close the reader to free system resources
	}

	// Get the integer midpoint in a range, rounding up if the range is an odd number
	private static int getMidpoint(int lower, int upper) {
		int range = upper - lower;
		int toAdd = (int) Math.ceil((double) range / 2.0);
		return (lower + toAdd);
	}

}