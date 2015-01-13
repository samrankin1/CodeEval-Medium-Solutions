import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		File inputFile = new File(args[0]); // the first argument will be the path to a file

		BufferedReader input = new BufferedReader(new FileReader(inputFile)); // create a BufferedReader to read the input from the given file

		String nextLine = null;
		while ((nextLine = input.readLine()) != null) { // run until there are no more lines of input
			String[] inputIntegers = nextLine.split(" "); // since the input is a list of integers separated by spaces, split the line into an array of integers (as strings)

			StackImplementation<Integer> stack = new StackImplementation<Integer>(inputIntegers.length); // create a new instance of our stack implementation, which will need to store as many integers are in the inputIntegers array
			for (String integer : inputIntegers) {
				int thisInteger = Integer.parseInt(integer); // parse this integer
				stack.push(thisInteger); // push it to the stack
			}

			int runs = stack.size(); // store the number of times the loop needs to run, because stack.size() will change as we loop

			ArrayList<Integer> toPrint = new ArrayList<Integer>(); // list of integers to print
			boolean printNext = true; // stores whether we will print the next integer we pop from the stack
			for (int i = 0; i < runs; i++) { // run once for each object in the stack
				if (printNext) { // if we print this time
					toPrint.add(stack.pop()); // add the next integer on the top of the stack to the list to print
					printNext = false; // don't print the next one
				} else { // if we don't print this time
					stack.pop(); // remove the next integer off the top of the stack
					printNext = true; // print the next one
				}
			}

			System.out.println(join(toPrint, " ")); // print the list of integers to print, separated by spaces
		}

		input.close(); // close the reader to free system resources
	}

	// Stack implementation with only three functions: push, pop, and size
	private static class StackImplementation<E> {

		private final ArrayList<E> array; // the internal array that stores all the objects in the stack

		@SuppressWarnings("unused") // we're not going to use this constructor, but it still should be here for future use
		public StackImplementation() { // create an instance of this stack implementation with the default initial size
			this.array = new ArrayList<E>(); // create the internal ArrayList with no initial size specification
		}

		public StackImplementation(int initialSize) { // create an instance of this stack implementation with a specified initial size
			this.array = new ArrayList<E>(initialSize); // create the internal ArrayList with the specified initial size
		}

		public void push(E object) { // add an object to the "top" of the stack
			array.add(object); // add the object
		}

		public E pop() { // get the last object in the array, removing it in the process
			int lastIndex = (this.array.size() - 1); // the last index in the array is the size minus one
			return array.remove(lastIndex); // return the last item in the array, removing it in the process
		}

		public int size() {
			return array.size();
		}
	}

	private static String join(List<Integer> list, String separator) {
		Iterator<Integer> iterator = list.iterator();

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