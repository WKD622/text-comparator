package tinkerbell.input.container;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import tinkerbell.input.textelement.Word;

/**
 * Represents text section as a List of Paragraph
 * 
 * @author Paweł Zeller, Jakub Ziarko
 */
public class Section {
	private final List<Paragraph> paragraphs;

	public Section(List<Paragraph> element) {
		paragraphs = element;
	}

	public List<Paragraph> getParagraphs() {
		return Collections.unmodifiableList(paragraphs);
	}

	public Stream<Paragraph> stream() {
		return getParagraphs().stream();
	}

	public Stream<Word> words() {
		return stream().flatMap(Paragraph::words);
	}

	@Override
	public int hashCode() {
		return paragraphs.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Section))
			return false;

		Section section = (Section) obj;
		return paragraphs.equals(section.getParagraphs());
	}
}
