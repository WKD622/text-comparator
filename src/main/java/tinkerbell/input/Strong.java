package tinkerbell.input;

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
	private final List<TextElement> elements;
	
	/**
	 * Basic constructor for {@link Strong} class.
	 * 
	 * @param textElements
	 */
	public Strong(List<TextElement> textElements) {
		this(textElements, false);
	}
	
	/**
	 * Constructor which protects list from modifications. It creates new list and
	 * copies there all elements of input list.
	 * 
	 * @param textElements
	 * @param shared
	 *            when it's true it creates object witch is modifiable, when false
	 *            not.
	 */
	Strong(List<TextElement> textElements, boolean shared) {
		if (shared) {
			this.elements = textElements;
		} else {
			this.elements = new ArrayList<>();
			this.elements.addAll(textElements);
		}
	}
	
	/**
	 * Returns a stream of all {@link TextElement}s from {@link Strong} object.
	 * 
	 * @return
	 */
	public Stream<TextElement> stream() {
		return getElements().stream();
	}
	
	/**
	 * Returns stream of all words from {@link Strong} object.
	 * 
	 * @return
	 */
	@Override
	public Stream<Word> words() {
		return stream().flatMap(TextElement::words);
	}
	
	/**
	 * Returns unmodifiable {@link TextElement} List from {@link Strong} object.
	 * 
	 * @return
	 */
	@Override
	public List<TextElement> getElements() {
		return Collections.unmodifiableList(elements);
	}
	
	@Override
	public int hashCode() {
		return elements.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Strong)) return false;
		
		Strong strong = (Strong) obj;
		return elements.equals(strong.elements);
	}
	
}
