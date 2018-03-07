package tinkerbell.input.textelement;

import java.util.stream.Stream;

/**
 * Basic structure, represents words, punctuation marks etc.
 * 
 * @author Paweł Zeller, Jakub Ziarko
 */
public interface TextElement {
	Stream<Word> words();
}
