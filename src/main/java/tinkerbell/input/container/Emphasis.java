package tinkerbell.input.container;

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

	private final List<TextElement> emphasises;

	/**
	 * Basic constructor for Emphasis class.
	 * @param textElements
	 */
	public Emphasis(List<TextElement> element) {
		this(element, false);
	}
	
	/**
	 * Constructor which protects list from modifications. It creates new list and copies
	 * there all elements of input list. 
	 * 
	 * @param element
	 * @param shared - when it's true it creates object witch is modifiable, when false not.
	 */
	Emphasis(List<TextElement> element, boolean shared) {
		if (shared) {
			this.emphasises = element;
		} else {
			this.emphasises = new ArrayList<>();
			this.emphasises.addAll(emphasises);
		}
	}
	
	/**
	 * Returns unmodifiable {@link TextElement}s List from {@link Emphasis} object.
	 * @return
	 */
	public List<TextElement> getEmphasises() {
		return Collections.unmodifiableList(emphasises);
	}

	/**
	 * Returns a stream of all {@link TextElement}s from {@link Emphasis} object.
	 * @return
	 */
	public Stream<TextElement> stream() {
		return getEmphasises().stream();
	}
	
	/**
	 * Returns stream of all words from {@link Emphasis} object.
	 * @return
	 */
	public Stream<Word> words() {
		return stream().flatMap(TextElement::words);
	}

	@Override
	public int hashCode() {
		return emphasises.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Emphasis))
			return false;

		Emphasis emphasis = (Emphasis) obj;
		return emphasises.equals(emphasis.getEmphasises());
	}
}
