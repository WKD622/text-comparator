package tinkerbell.input.container;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import tinkerbell.input.textelement.TextElement;

/**
 * Represents text sentence as a List of TextElementSentence
 * 
 * @author Paweł Zeller, Jakub Ziarko
 */
public class Sentence implements Container <TextElementSequence> {

	private final List<TextElementSequence> textElementSequences = new ArrayList<>();
	
	public Sentence() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void addElement(TextElementSequence element) {
		textElementSequences.add(element);
	}
	
	@Override
	public List<TextElementSequence> getAll() {
		return textElementSequences;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Sentence)) return false;
		
		Sentence sentence = (Sentence) obj;
		return textElementSequences.equals(sentence.getAll());
	}
	
	@Override
	public int hashCode() {
		return textElementSequences.hashCode();
	}

}
