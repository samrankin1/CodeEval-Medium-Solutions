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

			int currentNumber = Integer.parseInt(nextLine); // this stores the current number as we work with it, it's initial value is the input integer

			int iterations = 0; // keep count of times we've added the number to its reverse

			while (true) { // keep looping until broken
				if (isPalindrome(currentNumber)) { // if the current number is a palindrome
					System.out.println(iterations + " " + currentNumber); // print the number of iterations and the number
					break; // break the while loop
				}

				currentNumber += reverseInteger(currentNumber); // add the number to its reverse
				iterations++; // increment the iteration count
			}

		}

		input.close(); // close the reader to free system resources
	}

	private static int reverseInteger(int number) { // returns the reverse of the given integer
		String numberString = Integer.toString(number); // convert the number to a string
		String reversedNumberString = new StringBuilder(numberString).reverse().toString(); // reverse the string
		int reversedNumber = Integer.parseInt(reversedNumberString); // parse the reversed string
		return reversedNumber; // return the result
	}

	private static boolean isPalindrome(int number) { // returns whether a number is a palindrome
		String numberString = Integer.toString(number); // convert the number to a string
		String reversedNumberString = new StringBuilder(numberString).reverse().toString(); // reverse the string
		return (numberString.equals(reversedNumberString)); // the number is a palindrome if it is equal to its reverse
	}

}
