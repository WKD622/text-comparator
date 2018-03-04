package tinkerbell.input.container;

import java.util.ArrayList;
import java.util.List;

/**
 * Representation of whole text as a list of sections
 * 
 * @author Pawe, Kuba
 * 
 */
public class Text implements Container<Section> {

	List<Section> sections = new ArrayList<>();
	
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
