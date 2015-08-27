import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Converter {

	static String decoded = "";
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BigInteger bytes;
	static BigInteger divider = new BigInteger("9");
	static BigInteger multiplier = new BigInteger("-2");
	static String input = "";

	
	// Encrypts a given input (String and numbers possible)
	public static void encrypt() throws IOException {

		String cacheBytes = "";

		System.out.println("Geben sie den zu verschlüsselnden Text ein: ");
		decoded = br.readLine(); // saves the input String 

		// if input is not empty programm starts
		if (!decoded.isEmpty()) {
			byte[] b = decoded.getBytes(StandardCharsets.UTF_8); // creates a byteArray with UTF-8 Encoding

			for (int i = 0; i < b.length; i++) {
				cacheBytes += Byte.toString(b[i]) + 14; // converts every single char into bytes and adds puts them together
			}

			bytes = new BigInteger(cacheBytes); // byteString gets convertet into a number
			bytes = bytes.divide(divider); // bytes are getting divided
			bytes = bytes.multiply(multiplier); // bytes are getting multiplied

			System.out.println("ENCODED: " + bytes); // System output: Tim64 encoded String
		} else {
			new Encryptor();
		}
	}

	// decrypts a given Tim64 number
	public static void decrypt() throws IOException {
		String cacheString = "";
		String[] byteCode = {};
		ArrayList<Byte> singleBytes = new ArrayList<Byte>();
		byte[] singleBytes2;

		System.out.println("Geben sie die zu entschlüsselnden Zahlen ein: ");
		decoded = br.readLine(); // saves input

		// if String is not empty program starts
		if(!decoded.isEmpty()) {

		bytes = new BigInteger(decoded); // Tim64 bytes are getting converted into numbers
		bytes = bytes.divide(multiplier); // bytes are multiplied
		bytes = bytes.multiply(divider); // bytes are divided

		cacheString = bytes.toString(); // bytes are converted into String

		String leer = cacheString.replace("14", " "); // "14" is replaced with " "
		byteCode = leer.split(" "); // byteString is splitted on every " "

		for (String s : byteCode) {
			singleBytes.add((byte) Integer.parseInt(s)); // every string in StringArray is added to Byte Arraylist 
		}
		singleBytes2 = new byte[singleBytes.size()]; // new byteArray is initialized

		for (int i = 0; i < singleBytes.size(); i++) {
			singleBytes2[i] = singleBytes.get(i); // every byte in Byte ArrayList is transfered into byteArray
		}

		String decoded = new String(singleBytes2, "UTF-8"); // the bytes in the byteArray are converted into a String
		System.out.println("DECODED: " + decoded);
		} else {
			new Encryptor();
		}
	}
	
	public static void readInput() throws IOException {
		System.out.println("e für encrypt / d für decrypt / exit zum beenden");
		input = br.readLine();

	}
	
}
