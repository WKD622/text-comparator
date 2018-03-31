package tinkerbell.parser;

import java.io.File;

import tinkerbell.input.Text;

public interface Parser {
	/**
	 * Parses input text to object form {@link Text}.
	 */
	void parse();
	
	/**
	 * Returns parsed text in {@link Text} object.
	 * @return
	 */
	Text getText();
	
	void loadFile(String path);
	
	void closeFile();
}
