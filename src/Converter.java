import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;

public class Converter {

	public static String decoded = "";
	private static BigInteger bytes;
	
	// Encrypts a given input (String and numbers possible)
	protected static String encrypt(String input) throws IOException {		
		String cacheBytes = "";

		if (!input.equals("") && !input.equals(null)) {
			decoded = input;
			
			BigInteger divider = new BigInteger(getRandomNumber());
			BigInteger multiplier = new BigInteger(getRandomNumber());
			
			if(divider.equals("0")) {
				divider = new BigInteger(getRandomNumber());
			} else if(multiplier.equals("0")) {
				multiplier = new BigInteger(getRandomNumber());
			}
			EncryptGUI.divider.setText(divider.toString());
			EncryptGUI.multiplier.setText(multiplier.toString());
			
			byte[] b = decoded.getBytes(StandardCharsets.UTF_8); // creates a byteArray with UTF-8 Encoding

			for (int i = 0; i < b.length; i++) {
				cacheBytes += Byte.toString(b[i]) + 23; // converts every single char into bytes and adds puts them together
			}
			
			try {
				bytes = new BigInteger(cacheBytes); // byteString gets converted into a number
			} catch(NumberFormatException e) {
				return "Eingabe ist ungültig!";
			}
			try {
				bytes = bytes.divide(divider); // bytes are getting divided
				bytes = bytes.multiply(multiplier); // bytes are getting multiplied
			} catch(ArithmeticException e ) {
				encrypt(input);
			}
		} else {
			return "Bitte geben Sie etwas ein!";
		}
		
		String result = bytes.toString();
		return result;
	}

	// decrypts a given Tim64 number
	protected static String decrypt(String input, String multiplierString, String dividerString) throws IOException {
		String cacheString = "";
		String[] byteCode = {};
		ArrayList<Byte> singleBytes = new ArrayList<Byte>();
		byte[] singleBytes2;

		if (!input.equals("") && !input.equals(null)) {
			decoded = input;
			
			BigInteger multiplier = new BigInteger(multiplierString);
			BigInteger divider = new BigInteger(dividerString);
			
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
					try {
					singleBytes.add((byte) Integer.parseInt(s)); // every string in StringArray is added to Byte Arraylist 
					} catch(NumberFormatException e) {
						return "Eingabe ungültig!";
					}
				}
			}
			singleBytes2 = new byte[singleBytes.size()]; // new byteArray is initialized
	
			for (int i = 0; i < singleBytes.size(); i++) {
				singleBytes2[i] = singleBytes.get(i); // every byte in Byte ArrayList is transfered into byteArray
			}
	
			String decoded = new String(singleBytes2, "UTF-8"); // the bytes in the byteArray are converted into a String
			return decoded;
		} else {
			return "Bitte geben Sie etwas ein!";
		}
	}
			
//    public static void delay(int millis) {
//        try {
//            Thread.sleep(millis);
//        } catch (InterruptedException exp) {
//        }
//    }
	
	public static String getRandomNumber() {
		Random rand = new Random();
		String result = "";
		int min = -15;
		int max = 15;
		
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    
	    while(randomNum == 0) {
	    	randomNum = rand.nextInt((max - min) + 1) + min;
	    }
	    
	    result += randomNum;
	    return result;
	}
}
