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
		parseSentence();
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
	
	private void parseText() {
		parseSections();
	}
	
	private void parseSections() {
		parseParagraphs();
	}
	
	private void parseParagraphs() {
		parseSentence();
	}
	
	private void parseSentence() {
		while(!scanner.hasNext("\\w+\\.")) {
			sentenceBuilder.word(scanner.next());
		}
		sentenceBuilder.
		String s = scanner.next();
		System.out.println(s.substring(0, s.length()-1));
	}
	
	private class Regexes{
		private final String paragraphRegex = "\n\n";
		private final String sectionRegex = "\n\n\n";
		private final String endOfSentence = "[A-Za-z]++";
		
		public String getParagraphRegex() {
			return paragraphRegex;
		}
		public String getSectionRegex() {
			return sectionRegex;
		}
		public String getEndOfSentence(){
			return endOfSentence;
		}
	}
}
