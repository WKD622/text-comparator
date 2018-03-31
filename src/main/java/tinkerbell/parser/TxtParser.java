package tinkerbell.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import tinkerbell.input.SentenceBuilder;
import tinkerbell.input.Text;
import tinkerbell.input.TextBuilder;

/**
 * Implementation of Parser for *.txt files.
 * 
 * @author Jakub Ziarko
 *
 */
public class TxtParser implements Parser {
	private Text text;
	private Scanner scanner;
	private File f;
	private TextBuilder textBuilder;
	private SentenceBuilder sentenceBuilder;
	private Regexes regexes;
	
	@Override
	public void parse() {
		
	}
	
	@Override
	public Text getText() {
		return text;
	}
	
	@Override
	public void loadFile(String path) throws FileNotFoundException {
		this.f = new File(path);
		this.scanner = new Scanner(f);
	}
	
	private void parseSections() {
		
	}
	
	private void parseParagraphs() {
		
	}
	
	private void parseSentences() {
		
	}
	
	private class Regexes{
		private final String newParagraphRegex = "\n\n";
		private final String newSectionRegex = "\n\n\n";
		
		public String getNewParagraphRegex() {
			return newParagraphRegex;
		}
		public String getNewSectionRegex() {
			return newSectionRegex;
		}
		
	}
}
