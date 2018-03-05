package tinkerbell.input.container;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Represents text section as a List of Paragraph
 * 
 * @author Paweł Zeller, Jakub Ziarko
 */
public class Section implements Container<Paragraph> {
	private final List<Paragraph> paragraphs = new ArrayList<>();
	
	public Section() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void addElement(Paragraph element) {
		paragraphs.add(element);
	}
	
	@Override
	public List<Paragraph> getAll() {
		return paragraphs;
	}
	
	@Override
	public int hashCode() {
		return paragraphs.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Section)) return false;
		
		Section section = (Section) obj;
		return paragraphs.equals(section.getAll());
	}
}
