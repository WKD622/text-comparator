package tinkerbell.parser;

import java.io.File;

import tinkerbell.input.container.Text;

public interface Parser {
	void parse();
	
	Text getText();
	
	void loadFile();
	
	void closeFile();
}
