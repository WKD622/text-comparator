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

	public Paragraph() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addElement(Sentence element) {
		sentences.add(element);		
	}
	
	@Override
	public List<Sentence> getAll() {
		return sentences;
	}
	
	@Override
	public int hashCode() {
		return sentences.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Paragraph)) return false;
		
		Paragraph paragraph = (Paragraph) obj;
		return sentences.equals(paragraph.getAll());
	}
	
}
