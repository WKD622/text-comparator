package tinkerbell.input.container;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Representation of whole text as a list of sections
 * 
 * @author Paweł, Kuba
 * 
 */
public class Text implements Container<Section> {
	
	List<Section> sections = new ArrayList<>();

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Text)
			if (sections.equals(((Text) obj).getSections()))
				return true;
		return false;
	}

	public List getSections() {
		return sections;
	}
	
	@Override
	public void addElement(Section element) {
		sections.add(element);		
	}

	@Override
	public List<Section> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
