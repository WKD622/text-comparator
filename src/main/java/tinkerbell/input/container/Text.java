package tinkerbell.input.container;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Representation of whole text as a list of sections
 * 
 * @author Pawe�, Kuba
 * 
 */
public class Text implements Container<Section> {

	List<Section> sections = new ArrayList<>();
	
	@Override
	public void addElement(Section element) {
		sections.add(element);		
	}

	@Override
	public void deleteElement(Section element) {
		sections.remove(element);
	}

	@Override
	public Section findElement(Section element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Section> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		return super.equals(obj);
	}

	@Override
	public Stream<Section> stream() {
		// TODO Auto-generated method stub
		return null;
	}
}
