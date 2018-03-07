package tinkerbell.input.container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * Represents text section as a List of {@link Paragraph}
 * 
 * @author Paweł Zeller, Jakub Ziarko
 */
public class Section {
	private final List<Paragraph> paragraphs;
	
	/**
	 * Basic constructor for {@link Section} class.
	 * @param textElements
	 */
	public Section(List<Paragraph> paragraphs) {
		this(paragraphs, false);
	}
	
	/**
	 * Constructor which protects list from modifications. It creates new list and copies
	 * there all elements of input list. 
	 * 
	 * @param parahraphs
	 * @param shared - when it's true it creates object witch is modifiable, when false not.
	 */
	Section(List<Paragraph> paragraphs, boolean shared) {
		if (shared) {
			this.paragraphs = paragraphs;
		} else {
			this.paragraphs = new ArrayList<>();
			this.paragraphs.addAll(paragraphs);
		}
	}

	/**
	 * Returns unmodifiable {@link Paragraph}s List from {@link Section} object.
	 * @return
	 */
	public List<Paragraph> getParagraphs() {
		return Collections.unmodifiableList(paragraphs);
	}

	/**
	 * Returns a stream of all paragraphs from {@link Section} object.
	 * @return
	 */
	public Stream<Paragraph> stream() {
		return getParagraphs().stream();
	}
	
	/**
	 * Returns stream of all words from {@link Section} object.
	 * @return
	 */
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
