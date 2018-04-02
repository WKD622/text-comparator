package tinkerbell.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import tinkerbell.input.Sentence;
import tinkerbell.input.SentenceBuilder;
import tinkerbell.input.SentenceBuilderImpl;
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
	private SentenceBuilder sentenceBuilder = new SentenceBuilderImpl();
	private Regexes regexes = new Regexes();
	
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
		while(!scanner.hasNext(regexes.endOfSentence)) {
			sentenceBuilder.word(scanner.next());
		}
		String lastWordWithDot = scanner.next();
		sentenceBuilder.word(lastWordWithDot.substring(0, lastWordWithDot.length()-1));
		Sentence sentence = sentenceBuilder.punctuation(".").build();
		System.out.println(sentence.toString());
	}
	
	private class Regexes{
		private final String paragraphRegex = "\n\n";
		private final String sectionRegex = "\n\n\n";
		private final String endOfSentence = "\\w+\\.";
		
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
