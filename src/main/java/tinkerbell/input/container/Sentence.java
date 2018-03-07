package tinkerbell.input.container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import tinkerbell.input.textelement.TextElement;
import tinkerbell.input.textelement.Word;

/**
 * Represents text sentence as a List of TextElementSentence
 * 
 * @author Paweł Zeller, Jakub Ziarko
 */
public class Sentence implements TextElementSequence {

	private final List<TextElement> textElements;

	public Sentence(List<TextElement> textElements) {
		this(textElements, false);
	}
	
	Sentence(List<TextElement> textElements, boolean shared) {
		if (shared) {
			this.textElements = textElements;
		} else {
			this.textElements = new ArrayList<>();
			this.textElements.addAll(textElements);
		}
	}

	public List<TextElement> getTextElements() {
		return Collections.unmodifiableList(textElements);
	}

	public Stream<TextElement> stream() {
		return getTextElements().stream();
	}

	public Stream<Word> words() {
		return stream().flatMap(TextElement::words);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Sentence))
			return false;

		Sentence sentence = (Sentence) obj;
		return textElements.equals(sentence.getTextElements());
	}

	@Override
	public int hashCode() {
		return textElements.hashCode();
	}

}
