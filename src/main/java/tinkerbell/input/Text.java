package tinkerbell.input;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * Representation of whole text as a list of {@link Section}s
 * 
 * @author Paweł Zeller
 * @author Jakub Ziarko
 */
public class Text {
	private final List<Section> sections;
	
	/**
	 * Basic constructor for {@link Text} class.
	 * 
	 * @param sections
	 */
	public Text(List<Section> sections) {
		this(sections, false);
	}
	
	/**
	 * Constructor which protects list from modifications. It creates new list and
	 * copies there all elements of input list.
	 * 
	 * @param sections
	 * @param shared
	 *            when it's true it creates object witch is modifiable, when false
	 *            not
	 */
	Text(List<Section> sections, boolean shared) {
		if (shared) {
			this.sections = sections;
		} else {
			this.sections = new ArrayList<>();
			this.sections.addAll(sections);
		}
	}
	
	/**
	 * Returns unmodifiable {@link Section}s List from {@link Text} object.
	 * 
	 * @return
	 */
	public List<Section> getSections() {
		return Collections.unmodifiableList(sections);
	}
	
	/**
	 * Returns a stream of all {@link Section}s from {@link Text} object.
	 * 
	 * @return
	 */
	public Stream<Section> stream() {
		return sections.stream();
	}
	
	/**
	 * Returns a stream of all words from {@link Text} object.
	 * 
	 * @return
	 */
	public Stream<Word> words() {
		return stream().flatMap(Section::words);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Text)) return false;
		
		Text text = (Text) obj;
		return sections.equals(text.sections);
	}
	
	@Override
	public int hashCode() {
		return sections.hashCode();
	}
}
