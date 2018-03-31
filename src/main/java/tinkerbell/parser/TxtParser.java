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
	private Scanner scanner;
	File f;
	TextBuilder textBuilder;
	SentenceBuilder sentenceBuilder;
	
	@Override
	public void parse() {
		
	}
	
	@Override
	public Text getText() {
		// TODO Auto-generated method stub
		return null;
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
	
	private void parseSentence() {
		
	}
}
