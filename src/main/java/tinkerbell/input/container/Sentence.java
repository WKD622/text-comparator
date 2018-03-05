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
public class Sentence{

	private final List<TextElementSequence> textElementSequences;
	
	public Sentence(List <TextElementSequence> element) {
		textElementSequences = element;
	}
	
	public List<TextElementSequence> getTextElementSequences() {
		return textElementSequences;
	}

	public Stream<TextElementSequence> stream(){
		return getTextElementSequences().stream();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Sentence)) return false;
		
		Sentence sentence = (Sentence) obj;
		return textElementSequences.equals(sentence.getTextElementSequences());
	}
	
	@Override
	public int hashCode() {
		return textElementSequences.hashCode();
	}

}
