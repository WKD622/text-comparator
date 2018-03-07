package tinkerbell.input;

import java.util.List;

/**
 * Represents strong text fragment in a form of a {@link TextElement}s
 * 
 * @author Paweł Zeller
 * @author Jakub Ziarko
 */
public class Strong extends TextElementContainer implements TextElement {
	/**
	 * Basic constructor for {@link Strong} class.
	 * 
	 * @param elements
	 */
	public Strong(List<TextElement> elements) {
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
	Strong(List<TextElement> elements, boolean shared) {
		super(elements, shared);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Strong)) return false;
		
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
