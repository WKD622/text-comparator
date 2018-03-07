package tinkerbell.input.container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import tinkerbell.input.textelement.Word;

/**
 * Represents text paragraph in a List of Sentence
 * 
 * @author Paweł Zeller, Jakub Ziarko
 */
public class Paragraph {

	private final List<Sentence> sentences;

	public Paragraph(List<Sentence> element) {
		this(element,false);
	}
	
	/**
	 * Constructor which protects list from modifications. It creates new list and copies
	 * there all elements of input list. 
	 * 
	 * @param sections
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

	public List<Sentence> getSentences() {
		return Collections.unmodifiableList(sentences);
	}

	public Stream<Sentence> stream() {
		return getSentences().stream();
	}

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
