package tinkerbell.input.container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import tinkerbell.input.textelement.TextElement;
import tinkerbell.input.textelement.Word;

/**
 * Represents strong text fragment in a form of a {@link TextElementSequence}.
 * 
 * @author Paweł Zeller, Jakub Ziarko
 */

public class Strong implements TextElementSequence, TextElement {

	private final List<TextElement> textElements;

	public Strong(List<TextElement> textElements) {
		this(textElements, false);
	}
	
	/**
	 * Constructor which protects list from modifications. It creates new list and copies
	 * there all elements of input list. 
	 * 
	 * @param textElements
	 * @param shared - when it's true it creates object witch is modifiable, when false not.
	 */
	Strong(List<TextElement> textElements, boolean shared) {
		if (shared) {
			this.textElements = textElements;
		} else {
			this.textElements = new ArrayList<>();
			this.textElements.addAll(textElements);
		}
	}

	public Stream<TextElement> stream() {
		return getStrongs().stream();
	}

	public List<TextElement> getStrongs() {
		return Collections.unmodifiableList(textElements);
	}

	@Override
	public int hashCode() {
		return textElements.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Strong))
			return false;

		Strong strong = (Strong) obj;
		return textElements.equals(strong.getStrongs());
	}

	@Override
	public Stream<Word> words() {
		return stream().flatMap(TextElement::words);
	}

}
