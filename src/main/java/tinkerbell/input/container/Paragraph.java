package tinkerbell.input.container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * Represents text paragraph in a List of {@link Sentence}
 * 
 * @author Paweł Zeller, Jakub Ziarko
 */
public class Paragraph {

	private final List<Sentence> sentences;

	/**
	 * Basic constructor for {@link Paragraph} class.
	 * @param textElements
	 */
	public Paragraph(List<Sentence> element) {
		this(element,false);
	}
	
	/**
	 * Constructor which protects list from modifications. It creates new list and copies
	 * there all elements of input list. 
	 * 
	 * @param element
	 * @param shared - when it's true it creates object witch is modifiable, when false not.
	 */
	Paragraph(List<Sentence> element, boolean shared) {
		if (shared) {
			this.sentences = element;
		} else {
			this.sentences = new ArrayList<>();
			this.sentences.addAll(sentences);
		}
	}

	/**
	 * Returns unmodifiable {@link Sentence} List from {@link Paragraph} object.
	 * @return
	 */
	public List<Sentence> getSentences() {
		return Collections.unmodifiableList(sentences);
	}

	/**
	 * Returns a stream of all {@link Sentence}s from {@link Paragraph} object.
	 * @return
	 */
	public Stream<Sentence> stream() {
		return getSentences().stream();
	}

	/**
	 * Returns stream of all words from {@link Paragraph} object.
	 * @return
	 */
	public Stream<Word> words() {
		return stream().flatMap(Sentence::words);
	}

	@Override
	public int hashCode() {
		return sentences.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Paragraph))
			return false;

		Paragraph paragraph = (Paragraph) obj;
		return sentences.equals(paragraph.getSentences());
	}

}
