package tinkerbell.input;

import java.util.List;

/**
 * Represents emphasized text in a form of {@link TextElementSequence}
 * 
 * @author Paweł Zeller
 * @author Jakub Ziarko
 * @author Kamil Jarosz
 */
public class Emphasis extends TextElementContainer implements TextElement {
	/**
	 * Basic constructor for Emphasis class.
	 * 
	 * @param textElements
	 */
	public Emphasis(List<TextElement> elements) {
		super(elements, false);
	}
	
	/**
	 * Constructor which protects list from modifications. It creates new list and
	 * copies there all elements of input list.
	 * 
	 * @param elements
	 * @param shared
	 *            when it's true it creates object witch is modifiable, when false
	 *            not.
	 */
	Emphasis(List<TextElement> elements, boolean shared) {
		super(elements, shared);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Emphasis)) return false;
		
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
