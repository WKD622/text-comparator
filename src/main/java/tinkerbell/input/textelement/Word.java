package tinkerbell.input.textelement;

/**
 * Representation of a single word
 * 
 * @author Paweł Zeller, Jakub Ziarko
 */
public class Word implements TextElement {
	private final String word;
	
	public Word(String word) {
		this.word = word;
	}

	public String getWord() {
		return word;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Word)) return false;
		
		Word word = (Word) obj;
		return this.word.equals(word.getWord());	
	}
	
	@Override
	public int hashCode() {
		return word.hashCode();
	}
	
	
	
}
