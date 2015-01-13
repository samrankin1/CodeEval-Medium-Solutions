import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		File inputFile = new File(args[0]); // the first argument will be the path to a file

		BufferedReader input = new BufferedReader(new FileReader(inputFile)); // create a BufferedReader to read the input from the given file

		String firstLine = input.readLine(); // the first line contains topXLines

		int topXLines = Integer.parseInt(firstLine); // the number to longest lines we need to print

		ArrayList<String> lines = new ArrayList<String>(); // create a list to store the lines as we read them

		String nextLine = null;
		while ((nextLine = input.readLine()) != null) { // run until there are no more lines of input
			lines.add(nextLine); // each line is added to the list of lines
		}

		Collections.sort(lines, new LengthComparator()); // sort the lines by length in descending order

		List<String> result = lines.subList(0, topXLines); // create a list that contains the first X lines from the sorted list

		for (String s : result) { // for each line in the result list
			System.out.println(s); // print the line
		}

		input.close(); // close the reader to free system resources
	}

	// Comparator that sorts strings by length in descending order
	private static class LengthComparator implements Comparator<String> {

		@Override
		public int compare(String obj0, String obj1) {
			if (obj0.length() > obj1.length()) { // if the first argument is longer
				return -1; // the first argument is greater
			}

			if (obj0.length() < obj1.length()) { // if the second argument is longer
				return 1; // the second argument is greater
			}

			return 0; // otherwise they are equal
		}

	}

}