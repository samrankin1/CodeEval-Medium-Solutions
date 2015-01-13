import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		File inputFile = new File(args[0]); // the first argument will be the path to a file

		BufferedReader input = new BufferedReader(new FileReader(inputFile)); // create a BufferedReader to read the input from the given file

		String nextLine = null;
		while ((nextLine = input.readLine()) != null) { // run until there are no more lines of input
			ArrayList<String> inputList = new ArrayList<String>(); // create an ArrayList to store all the elements
			inputList.addAll(Arrays.asList(nextLine.split(" "))); // since the input is a list of characters separated by spaces, place the characters into an array, then convert it to a list, then add all the elements to the ArrayList

			int n = Integer.parseInt(inputList.remove(inputList.size() - 1)); // parse n, the integer that is the last element in inputList, removing it in the process

			if (n > inputList.size()) { // if n is greater than the number of elements in the list
				continue; // ignore this line of input and continue to the next one
			}

			String result = inputList.get(inputList.size() - n); // get the nth to last element in inputList

			System.out.println(result); // print the result
		}

		input.close(); // close the reader to free system resources
	}

}