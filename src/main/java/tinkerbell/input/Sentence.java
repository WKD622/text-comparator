package tinkerbell.input;

import java.util.List;

import javax.lang.model.util.Elements;

/**
 * Represents text sentence as a List of {@link TextElement}s
 * 
 * @author Paweł Zeller
 * @author Jakub Ziarko
 */
public class Sentence extends TextElementContainer {
	/**
	 * Basic constructor for {@link Sentence} class.
	 * 
	 * @param elements
	 */
	public Sentence(List<TextElement> elements) {
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
	Sentence(List<TextElement> elements, boolean shared) {
		super(elements, shared);
	}
	
	@Override
	public String toString() {
		return getElements().toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Sentence)) return false;
		
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
