package tinkerbell.input.container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * Represents strong text fragment in a form of a {@link TextElement}s
 * 
 * @author Paweł Zeller, Jakub Ziarko
 */

public class Strong implements TextElementSequence, TextElement {

	private final List<TextElement> textElements;

	/**
	 * Basic constructor for {@link Strong} class.
	 * @param textElements
	 */
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

	/**
	 * Returns a stream of all {@link TextElement}s from {@link Strong} object.
	 * @return
	 */
	public Stream<TextElement> stream() {
		return getStrongs().stream();
	}

	/**
	 * Returns stream of all words from {@link Strong} object.
	 * @return
	 */
	@Override
	public Stream<Word> words() {
		return stream().flatMap(TextElement::words);
	}
	
	/**
	 * Returns unmodifiable {@link TextElement} List from {@link Strong} object.
	 * @return
	 */
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

	

}
