package tinkerbell.input.container;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Represents text paragraph in a List of Sentence
 * 
 * @author Paweł Zeller, Jakub Ziarko
 */
public class Paragraph implements Container<Sentence> {
	
	private final List<Sentence> sentences = new ArrayList<>();

	public List<Sentence> getSentences() {
		return sentences;
	}

	@Override
	public void addElement(Sentence element) {
		sentences.add(element);		
	}
	
	@Override
	public List<Sentence> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int hashCode() {
		return sentences.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Paragraph)) return false;
		
		Paragraph paragraph = (Paragraph) obj;
		return sentences.equals(paragraph.sentences);
	}
	
}
