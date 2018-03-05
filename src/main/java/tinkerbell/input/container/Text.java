package tinkerbell.input.container;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import tinkerbell.input.textelement.TextElement;

/**
 * Representation of whole text as a list of sections
 * 
 * @author Paweł Zeller, Jakub Ziarko
 */
public class Text{
	private final List<Section> sections = new ArrayList<>();
	
	public Text() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Section> getSections() {
		return sections;
	}

	public Stream<Section> stream(){
		return getSections().stream();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Text)) return false;
		
		Text text = (Text) obj;
		return sections.equals(text.getSections());
	}
	
	@Override
	public int hashCode() {
		return sections.hashCode();
	}
}
