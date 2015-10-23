import java.io.IOException;

public class Encryptor {

	public static void main(String[] args) throws IOException {

		while (Converter.input != "e" || Converter.input != "d" || Converter.input != "exit") {
			Converter.readInput();
		}
	}
}
