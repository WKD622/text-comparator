package tinkerbell.input;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * This class gathers the common behavior of most classes implementing the
 * {@link TextElementSequence} interface. It provides storage for
 * {@link TextElement}s and common methods such as {@link #getElements()},
 * {@link #stream()} or {@link #words()}.
 * 
 * @author Kamil Jarosz
 */
abstract class TextElementContainer implements TextElementSequence {
	/*
	 * Contains the elements in the specified order.
	 */
	private final List<TextElement> elements;
	
	/**
	 * Initialize this container with the given elements.
	 * <p>
	 * <b>Warning:</b> This constructor will copy the whole list in order to keep
	 * this object immutable. If it isn't the desired behavior, consider using the
	 * {@link TextBuilder} class.
	 * 
	 * @param elements
	 *            the elements this object will contain
	 */
	protected TextElementContainer(List<TextElement> elements) {
		this(elements, false);
	}
	
	/*
	 * This constructor is used to share the list of elements for speed. It should
	 * be used when copying the whole list isn't needed. However the caller shall
	 * abide by the fact that the list passed to this constructor cannot be changed
	 * afterwards because it will break the immutability of this object.
	 */
	TextElementContainer(List<TextElement> elements, boolean shared) {
		if (shared) {
			this.elements = elements;
		} else {
			this.elements = new ArrayList<>();
			this.elements.addAll(elements);
		}
	}
	
	@Override
	public final List<TextElement> getElements() {
		return Collections.unmodifiableList(elements);
	}
	
	/**
	 * Returns the stream of {@link TextElement}s from this container.
	 * 
	 * @return the stream of text elements
	 */
	public Stream<TextElement> stream() {
		return elements.stream();
	}
	
	/**
	 * Returns the stream of {@link Word}s from this container, i.e. the filtered
	 * and flattened words the structure represented by this object consists of.
	 * 
	 * @return the stream of words
	 */
	public Stream<Word> words() {
		return stream().flatMap(TextElement::words);
	}
	
	@Override
	public int hashCode() {
		return elements.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof TextElementContainer)) return false;
		
		TextElementContainer container = (TextElementContainer) obj;
		return elements.equals(container.elements);
	}
}
