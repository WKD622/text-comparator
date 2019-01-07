package tinkerbell.input;

import java.util.stream.Stream;

/**
 * Representation a punctuation mark as a TextElement implementation
 * 
 * @author Paweł Zeller
 * @author Jakub Ziarko
 */
public class Punctuation implements TextElement {
	private final String punctuation;
	
	public Punctuation(String punctuation) {
		this.punctuation = punctuation;
	}
	
	public String getPunctuation() {
		return punctuation;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Punctuation)) return false;
		
		Punctuation punctuation = (Punctuation) obj;
		return this.punctuation.equals(punctuation.punctuation);
	}
	
	@Override
	public int hashCode() {
		return punctuation.hashCode();
	}
	
	@Override
	public Stream<Word> words() {
		return Stream.empty();
	}
}
