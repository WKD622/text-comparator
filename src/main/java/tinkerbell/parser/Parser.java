package tinkerbell.parser;

import tinkerbell.input.container.Text;

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
	
	void loadFile();
	
	void closeFile();
}
