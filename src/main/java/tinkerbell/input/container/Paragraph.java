package tinkerbell.input.container;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import tinkerbell.input.textelement.TextElement;

/**
 * Represents text paragraph in a List of Sentence
 * 
 * @author Paweł Zeller, Jakub Ziarko
 */
public class Paragraph{
	
	private final List<Sentence> sentences;

	public Paragraph(List <Sentence> element) {
		sentences = element;
	}
	
	public List<Sentence> getSentences() {
		return sentences;
	}
	
	public Stream<Sentence> stream(){
		return getSentences().stream();
	}

	@Override
	public int hashCode() {
		return sentences.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Paragraph)) return false;
		
		Paragraph paragraph = (Paragraph) obj;
		return sentences.equals(paragraph.getSentences());
	}
	
}
