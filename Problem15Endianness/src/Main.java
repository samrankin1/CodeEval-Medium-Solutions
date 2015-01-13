import java.nio.ByteOrder;

public class Main {
	
	public static void main(String[] args) {
		ByteOrder nativeOrder = ByteOrder.nativeOrder(); // get the native endianness of the system
		
		if (nativeOrder == ByteOrder.LITTLE_ENDIAN) { // if the system is little endian
			System.out.println("LittleEndian"); // print the result
		}
		
		if (nativeOrder == ByteOrder.BIG_ENDIAN) { // if the system is big endian
			System.out.println("BigEndian"); // print the result
		}
	}

}
