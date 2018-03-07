package tinkerbell.input.container;
import java.util.List;
import java.util.stream.Stream;

import tinkerbell.input.textelement.TextElement;
import tinkerbell.input.textelement.Word;

/**
 * Represents text sentence as a List of TextElementSentence
 * 
 * @author Paweł Zeller, Jakub Ziarko
 */
public class Sentence implements TextElementSequence{
	
	private final List<TextElement> textElements;
	
	public Sentence(List <TextElement> element) {
		textElements = element;
	}
	
	public List<TextElement> getTextElements() {
		return textElements;
	}

	public Stream<TextElement> stream(){
		return getTextElements().stream();
	}
	
	public Stream<Word> words(){
		return stream().flatMap(TextElement::words);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Sentence)) return false;
		
		Sentence sentence = (Sentence) obj;
		return textElements.equals(sentence.getTextElements());
	}
	
	@Override
	public int hashCode() {
		return textElements.hashCode();
	}

}
