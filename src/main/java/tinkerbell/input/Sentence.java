package tinkerbell.input;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * Represents text sentence as a List of {@link TextElement}s
 * 
 * @author Paweł Zeller, Jakub Ziarko
 */
public class Sentence implements TextElementSequence {
	private final List<TextElement> elements;
	
	/**
	 * Basic constructor for {@link Sentence} class.
	 * 
	 * @param textElements
	 */
	public Sentence(List<TextElement> textElements) {
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
	Sentence(List<TextElement> textElements, boolean shared) {
		if (shared) {
			this.elements = textElements;
		} else {
			this.elements = new ArrayList<>();
			this.elements.addAll(textElements);
		}
	}
	
	/**
	 * Returns unmodifiable {@link TextElement} List from {@link Sentence} object.
	 * 
	 * @return
	 */
	public List<TextElement> getElements() {
		return Collections.unmodifiableList(elements);
	}
	
	/**
	 * Returns a stream of all {@link TextElement}s from Sentence object.
	 * 
	 * @return
	 */
	public Stream<TextElement> stream() {
		return elements.stream();
	}
	
	/**
	 * Returns stream of all words from {@link Sentence} object.
	 * 
	 * @return
	 */
	public Stream<Word> words() {
		return stream().flatMap(TextElement::words);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Sentence)) return false;
		
		Sentence sentence = (Sentence) obj;
		return elements.equals(sentence.getElements());
	}
	
	@Override
	public int hashCode() {
		return elements.hashCode();
	}
}
