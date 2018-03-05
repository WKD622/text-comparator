package tinkerbell.input.container;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation of whole text as a list of sections
 * 
 * @author Paweł Zeller, Jakub Ziarko
 */
public class Text implements Container<Section> {
	private final List<Section> sections = new ArrayList<>();
	
	public Text() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void addElement(Section element) {
		sections.add(element);
	}
	
	@Override
	public List<Section> getAll() {
		return sections;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Text)) return false;
		
		Text text = (Text) obj;
		return sections.equals(text.getAll());
	}
	
	@Override
	public int hashCode() {
		return sections.hashCode();
	}
}
