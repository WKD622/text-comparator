package tinkerbell.input;

import java.util.List;

/**
 * Represents sequence of basic sentence components: words, punctuation marks
 * etc. (TextElement objects)
 * 
 * @author Paweł Zeller, Jakub Ziarko
 */
public interface TextElementSequence {
	List<TextElement> getElements();
}
