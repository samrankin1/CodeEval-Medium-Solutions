import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

	private static ArrayList<Integer> knownPrimes = new ArrayList<Integer>(); // this list will store the list of known primes so that we don't have to re-calculate

	public static void main(String[] args) throws IOException {
		knownPrimes.add(2); // 2 is the first known prime

		File inputFile = new File(args[0]); // the first argument will be the path to a file

		BufferedReader input = new BufferedReader(new FileReader(inputFile)); // create a BufferedReader to read the input from the given file

		String nextLine = null;
		while ((nextLine = input.readLine()) != null) { // run until there are no more lines of input
			int max = Integer.parseInt(nextLine);

			ArrayList<Integer> primes = new ArrayList<Integer>(); // store the list of primes as we build it

			if (max > 2) {
				primes.add(2); // 2 is a special case, the only even prime
			}

			for (int i = 3; i < max; i += 2) { // only test odd numbers, there are no even primes except for 2
				if (isPrime(i)) { // if i is prime
					primes.add(i); // add i to the list
				}
			}

			System.out.println(join(primes, ",")); // print the list of primes, separated by commas
		}

		input.close(); // close the reader to free system resources
	}

	private static boolean isPrime(int n) {

		if (n < knownPrimes.get(knownPrimes.size() - 1)) { // if n is less than the greatest known prime, we've already calculated for it
			return knownPrimes.contains(n); // if the number is in the list, it has been determined to be prime previously
		}

		if (n == 2) { // 2 is a special case
			return true;
		}

		if ((n % 2) == 0) { // if n is divisible by 2, it is not prime
			return false;
		}

		// if the number is divisible by 2, we only have to check odd numbers up to the square root of n
		for (int i = 3; (i * i) <= n; i += 2) {
			if ((n % i) == 0) {
				return false;
			}
		}

		return true; // if we don't find any factors, the number is prime
	}

	private static String join(List<?> list, String separator) {
		Iterator<?> iterator = list.iterator();

		if (!iterator.hasNext()) { // if the list is empty
			return ""; // return an empty string
		}

		StringBuilder result = new StringBuilder(); // store the result string as we build it

		result.append(iterator.next()); // add the first result

		while (iterator.hasNext()) { // while there are still elements to add
			result.append(separator); // add the separator
			result.append(iterator.next()); // then add the next element
		}

		return result.toString(); // return the resultant string
	}
}
