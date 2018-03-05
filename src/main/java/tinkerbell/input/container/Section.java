package tinkerbell.input.container;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Represents text section as a List of Paragraph
 * 
 * @author Paweł Zeller, Jakub Ziarko
 */
public class Section{
	private final List<Paragraph> paragraphs;
	
	public Section(List <Paragraph> element) {
		paragraphs = element;
	}
	
	public List<Paragraph> getParagraphs() {
		return paragraphs;
	}

	public Stream<Paragraph> stream(){
		return getParagraphs().stream();
	}

	@Override
	public int hashCode() {
		return paragraphs.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Section)) return false;
		
		Section section = (Section) obj;
		return paragraphs.equals(section.getParagraphs());
	}
}
