package tinkerbell.input.container;

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
		sentences = element;
	}

	public List<Sentence> getSentences() {
		return sentences;
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
