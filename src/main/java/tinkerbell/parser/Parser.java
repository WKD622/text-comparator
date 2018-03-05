package tinkerbell.parser;

import tinkerbell.input.container.Text;

public interface Parser {
	void parse();
	
	Text getText();
}
