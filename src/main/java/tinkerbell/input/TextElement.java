package tinkerbell.input;

import java.util.stream.Stream;

/**
 * Basic structure, represents words, punctuation marks etc.
 * 
 * @author Paweł Zeller
 * @author Jakub Ziarko
 */
public interface TextElement {
	Stream<Word> words();
}
