import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		File inputFile = new File(args[0]); // the first argument will be the path to a file

		BufferedReader input = new BufferedReader(new FileReader(inputFile)); // create a BufferedReader to read the input from the given file

		String nextLine = null;
		while ((nextLine = input.readLine()) != null) { // run until there are no more lines of input
			String[] splitInput = nextLine.split(";"); // the input consists of two parts separated by a semicolon, so split the line at the semicolon
			List<String> list = Arrays.asList(splitInput[1].split(",")); // the second element in the array is the list, separated by commas, so split the list into an array containing its elements

			for (String e : list) { // for each element in the list
				List<String> clonedList = new ArrayList<String>(list.size()); // make an empty array with the same size as the original list
				clonedList.addAll(list); // copy the elements of the original list into the new list, cloning the list
				clonedList.remove(e); // remove the element we're looking at

				if (clonedList.contains(e)) { // if the clonedList contains the element we just removed, we found the duplicate entry
					System.out.println(e); // print the duplicate entry
					break; // stop looking
				}
			}
		}

		input.close(); // close the reader to free system resources
	}

}