package tinkerbell.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import tinkerbell.input.Paragraph;
import tinkerbell.input.Section;
import tinkerbell.input.Sentence;
import tinkerbell.input.SentenceBuilder;
import tinkerbell.input.SentenceBuilderImpl;
import tinkerbell.input.Text;
import tinkerbell.input.TextBuilder;
import tinkerbell.input.TextBuilder.ParagraphBuilder;

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
	private TextBuilder textBuilder = Text.builder();
	private ParagraphBuilder paragraphBuilder;
	private SentenceBuilder sentenceBuilder;
	private Regexes regexes = new Regexes();
	
	@Override
	public void parse() {
		parseText();
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
	
	/**
	 * Parses the whole *.txt file to {@lik Text} object, does anything without
	 * parseSections() method.
	 */
	private void parseText() {
		parseSections();
		textBuilder.build();
	}
	
	/**
	 * Parses choosen section in *.txt file to {@link Section}, does anything
	 * without parseParagraph() method inside. Uses scanner class, starts parsing
	 * where scanner is at this moment.
	 */
	private void parseSections() {
		parseParagraph();
	}
	
	/**
	 * Parses choosen paragraph in *.txt file to {@link Paragraph}, does anything
	 * without parseSentence() method inside. Uses scanner class, starts parsing
	 * where scanner is at this moment. Ends at the beginning of another paragraph,
	 * section or end of file.
	 */
	private void parseParagraph() {
		paragraphBuilder = textBuilder.paragraph();
		while (!scanner.hasNext(regexes.paragraphRegex) &&
				!scanner.hasNext(regexes.sectionRegex)
				&& scanner.hasNext()) {
			System.out.println(parseSentence());
			//paragraphBuilder.sentence(parseSentence());
		}
		paragraphBuilder.finish();
	}
	
	/**
	 * Parses *.txt file from starting point (scanner position in file) to dot
	 * creating {@link Sentence} object.
	 */
	private Sentence parseSentence() {
		sentenceBuilder = Sentence.builder();
		/*
		 * till the end of sentence (dot)
		 */
		while (!scanner.hasNext(regexes.endOfSentence)) {
			/*
			 * if normal word like "cat", "dog"
			 */
			if (scanner.hasNext(regexes.getWordRegex())) {
				sentenceBuilder.word(scanner.next());
			}
			/*
			 * if word with punctuation like " cat, ", " dog; "
			 */
			else if (scanner.hasNext(regexes.getWordRegex() + regexes.punctuationRegex())) {
				String wordWithPunctuation = scanner.next();
				/*
				 * adds word to builder without punctuation
				 */
				sentenceBuilder
						.word(wordWithPunctuation.substring(0, wordWithPunctuation.length() - 1));
				/*
				 * adds punctuation to builder without word
				 */
				sentenceBuilder.punctuation(wordWithPunctuation
						.substring(wordWithPunctuation.length() - 1, wordWithPunctuation.length()));
			} 
			/*
			 * if word with punctutation like " -cat ", " "dog "
			 */
			else if (scanner.hasNext(regexes.punctuationRegex + regexes.wordRegex)) {
				String wordWithPunctuation = scanner.next();
				sentenceBuilder.punctuation(wordWithPunctuation.substring(0, 1));
				sentenceBuilder
						.word(wordWithPunctuation.substring(1, wordWithPunctuation.length()));
			} 
			/*
			 * if word with punctutation like " 'cat' ", " (dog) "
			 */
			else {
				String wordWithDoublePunctuation = scanner.next();
				sentenceBuilder.punctuation(wordWithDoublePunctuation.substring(0, 1));
				sentenceBuilder.word(wordWithDoublePunctuation.substring(1,
						wordWithDoublePunctuation.length() - 1));
				/*sentenceBuilder.punctuation(
						wordWithDoublePunctuation.substring(wordWithDoublePunctuation.length() - 1,
								wordWithDoublePunctuation.length()));
								*/
				
			}
		}
		/*
		 * Last word of sentence is with dot, so it doesn't parse in while, again 
		 * it divieds this token to two parts - word and punctutation - 
		 * and adds to builder in order above.
		 */
		String lastWordWithDot = scanner.next();
		sentenceBuilder.word(lastWordWithDot.substring(0, lastWordWithDot.length() - 1));
		return sentenceBuilder.punctuation(".").build();
	}
	
	/**
	 * Class witch stores regexes, function of this class is to give them nice
	 * description (variable name) and take them apart from parser class for more
	 * clean look.
	 * 
	 * @author Jakub Ziarko
	 */
	private class Regexes {
		private final String paragraphRegex = "\t";
		private final String sectionRegex = "\n\n\t";
		/*
		 * Normal word with dot at the end - without white space.
		 */
		private final String endOfSentence = "[\\p{IsAlphabetic} ]+\\.";
		/*
		 * "\\w" - for all words build only with letters ,
		 * "-" - if the word is build from two words like "czerwono-czarny - but without 
		 * white characters inside".
		 */
		private final String wordRegex = "[\\p{IsAlphabetic}-]+";
		private final String punctuationRegex = "[,.;:\"?!-–'{}()—–\\/]";
		
		public String punctuationRegex() {
			return punctuationRegex;
		}
		
		public String paragraphRegex() {
			return paragraphRegex;
		}
		
		public String sectionRegex() {
			return sectionRegex;
		}
		
		public String endOfSentence() {
			return endOfSentence;
		}
		
		public String getWordRegex() {
			return wordRegex;
		}
		
	}
}
