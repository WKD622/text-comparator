package tinkerbell.input;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * Represents emphasized text in a form of {@link TextElementSequence}
 * 
 * @author Paweł Zeller, Jakub Ziarko
 */
public class Emphasis implements TextElementSequence, TextElement {
	private final List<TextElement> elements;
	
	/**
	 * Basic constructor for Emphasis class.
	 * 
	 * @param textElements
	 */
	public Emphasis(List<TextElement> element) {
		this(element, false);
	}
	
	/**
	 * Constructor which protects list from modifications. It creates new list and
	 * copies there all elements of input list.
	 * 
	 * @param element
	 * @param shared
	 *            - when it's true it creates object witch is modifiable, when false
	 *            not.
	 */
	Emphasis(List<TextElement> element, boolean shared) {
		if (shared) {
			this.elements = element;
		} else {
			this.elements = new ArrayList<>();
			this.elements.addAll(elements);
		}
	}
	
	/**
	 * Returns unmodifiable {@link TextElement}s List from {@link Emphasis} object.
	 * 
	 * @return
	 */
	public List<TextElement> getElements() {
		return Collections.unmodifiableList(elements);
	}
	
	/**
	 * Returns a stream of all {@link TextElement}s from {@link Emphasis} object.
	 * 
	 * @return
	 */
	public Stream<TextElement> stream() {
		return elements.stream();
	}
	
	/**
	 * Returns stream of all words from {@link Emphasis} object.
	 * 
	 * @return
	 */
	@Override
	public Stream<Word> words() {
		return stream().flatMap(TextElement::words);
	}
	
	@Override
	public int hashCode() {
		return elements.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Emphasis)) return false;
		
		Emphasis emphasis = (Emphasis) obj;
		return elements.equals(emphasis.elements);
	}
}
