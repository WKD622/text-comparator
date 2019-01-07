package tinkerbell.parser;

import java.io.FileNotFoundException;

public class Program {
	
	public static void main(String args[]) {
		Parser parser = new TxtParser();
		try {
			parser.loadFile("/home/jakub/swiatla.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		parser.parse();
	}
}
