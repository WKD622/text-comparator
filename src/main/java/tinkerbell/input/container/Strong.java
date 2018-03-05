package tinkerbell.input.container;

import java.util.ArrayList;
import java.util.List;

import tinkerbell.input.textelement.TextElement;

/**
 * Represents strong text fragment in a form of a {@link TextElementSequence}.
 * 
 * @author Paweł Zeller, Jakub Ziarko
 */

public class Strong implements TextElementSequence {
	
	private final List<TextElement> strongs = new ArrayList<>();
	
	public List<TextElement> getStrongs() {
		return strongs;
	}

	@Override
	public void addElement(TextElement element) {
		strongs.add(element);
	}
	
	@Override
	public List<TextElement> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int hashCode() {
		return strongs.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Strong)) return false;
		
		Strong strong = (Strong) obj;
		return strongs.equals(strong.strongs);	
	}
		
	
}
