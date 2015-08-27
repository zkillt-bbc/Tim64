import java.io.IOException;

public class Encryptor {

	public static void main(String[] args) throws IOException {

		while (Converter.input != "e" || Converter.input != "d" || Converter.input != "exit") {
			Converter.readInput();

			if (Converter.input.toLowerCase().equals("e")) {
				Converter.encrypt();
			} else if (Converter.input.toLowerCase().equals("d")) {
				Converter.decrypt();
			} else if (Converter.input.toLowerCase().equals("exit")) {
				System.exit(0);
			}
			
			System.out.println("Eingabe war falsch! Bitte eine richtige Eingabe machen.");
		}
	}
}
