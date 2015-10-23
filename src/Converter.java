import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Converter {

	public static String decoded = "";
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BigInteger bytes;
	private static final BigInteger divider = new BigInteger(/**getRandomNumber() **/ "7");
	private static final BigInteger multiplier = new BigInteger(/**getRandomNumber() **/ "3");
	protected static String input = "";
	
	// Encrypts a given input (String and numbers possible)
	protected static String encrypt(String input) throws IOException {

		String cacheBytes = "";

//		System.out.println("Geben sie den zu verschl\u00fcsselnden Text ein: ");

//		decoded = br.readLine(); // saves the input String 
//		decoded.replaceAll("ü", "\u00fc");
		decoded = input;
		// if input is not empty program starts
		if (!decoded.isEmpty()) {
			byte[] b = decoded.getBytes(StandardCharsets.UTF_8); // creates a byteArray with UTF-8 Encoding

			for (int i = 0; i < b.length; i++) {
				cacheBytes += Byte.toString(b[i]) + 23; // converts every single char into bytes and adds puts them together
			}
			
			try {
				bytes = new BigInteger(cacheBytes); // byteString gets converted into a number
			} catch(NumberFormatException e) {
				return "Eingabe ist ungültig!";
			}
			bytes = bytes.divide(divider); // bytes are getting divided
			bytes = bytes.multiply(multiplier); // bytes are getting multiplied

//			System.out.println("ENCODED: " + bytes); // System output: Tim64 encoded String
		} else {
			new Encryptor();
		}
		
		String result = bytes.toString();
		return result;
	}

	// decrypts a given Tim64 number
	protected static String decrypt(String input) throws IOException {
		String cacheString = "";
		String[] byteCode = {};
		ArrayList<Byte> singleBytes = new ArrayList<Byte>();
		byte[] singleBytes2;

//		System.out.println("Geben sie die zu entschl\u00fcsselnden Zahlen ein: ");
//		decoded = br.readLine(); // saves input
		
		decoded = input;
		
		// if String is not empty program starts
		if(!decoded.isEmpty()) {
			try {
				bytes = new BigInteger(decoded); // Tim64 bytes are getting converted into numbers
			} catch(NumberFormatException e) {
				return "Eingabe ist ungültig!";
			}
			bytes = bytes.divide(multiplier); // bytes are multiplied
			bytes = bytes.multiply(divider); // bytes are divided

			cacheString = bytes.toString(); // bytes are converted into String
	
			String leer = cacheString.replace("23", " "); // "23" is replaced with " "
			byteCode = leer.split(" "); // byteString is splitted on every " "
	
			for (String s : byteCode) {
				if(!s.equals(null) && !s.equals(" ") && !s.equals("")) {
					singleBytes.add((byte) Integer.parseInt(s)); // every string in StringArray is added to Byte Arraylist 
				}
			}
			singleBytes2 = new byte[singleBytes.size()]; // new byteArray is initialized
	
			for (int i = 0; i < singleBytes.size(); i++) {
				singleBytes2[i] = singleBytes.get(i); // every byte in Byte ArrayList is transfered into byteArray
			}
	
			String decoded = new String(singleBytes2, "UTF-8"); // the bytes in the byteArray are converted into a String
//			System.out.println("DECODED: " + decoded);
			return decoded;
		} else {
			return "Eingabe ist ungültig";
		}
	}
	
	protected static void readInput() throws IOException {
		System.out.println("e f\u00fcr encrypt / d f\u00fcr decrypt / exit zum beenden");
		checkinput(input = br.readLine());
	}
	
	private static void checkinput(String input) throws IOException {
		
		if (Converter.input.toLowerCase().equals("e")) {
			encrypt(input);
		} else if (Converter.input.toLowerCase().equals("d")) {
			decrypt(input);
		} else if (Converter.input.toLowerCase().equals("exit")) {
			System.out.println("Tim64 is shutting down...");
			delay(1000);
			System.out.println("Successful!");
			System.exit(0);
		} else {
			System.out.println("Eingabe war falsch bitte erneut eingeben!");
			return;
		}
		System.out.println("Wollen sie erneut eine Eingabe machen?");
	}
	
    public static void delay(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException exp) {
        }
    }
	
//	public static String getRandomNumber() {
//		Random rand = new Random();
//		String result = "4";
//		int min = 15;
//		int max = 15;
//		
//	    int randomNum = rand.nextInt((max - min) + 1) + min;
//	    result += randomNum;
//	    return result;
//	}
}
