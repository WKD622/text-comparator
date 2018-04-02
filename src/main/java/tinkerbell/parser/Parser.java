package tinkerbell.parser;

import java.io.FileNotFoundException;
import tinkerbell.input.Text;

/**
 * Instance of this class is used to parse files. It changes them to object
 * structure - {@link Text}, form which is easy to do the analysis on.
 * 
 * <p>
 * Example:
 * <pre>
 * Parser exampleParser = new Parser();
 * exampleParser.parse("example/path/to/file.f");
 * Text exampleText = exampleParser.getText();
 * </pre>
 * 
 * <p>
 * For additional information about usage of a specific method, see the
 * documentation thereof.
 *
 * @author Jakub Ziarko
 *
 */
public interface Parser {
	
	/**
	 * Parses input text to object form {@link Text}.
	 */
	void parse();
	
	/**
	 * Returns parsed text in {@link Text} object.
	 * 
	 * @return Text
	 * 
	 */
	Text getText();
	
	/**
	 * Loads file which is going to be parsed. The only one argument is localization
	 * of file. If given path is wrong throws FileNotFoundException.
	 * 
	 * @param path
	 * @throws FileNotFoundException
	 */
	void loadFile(String path) throws FileNotFoundException;
}
