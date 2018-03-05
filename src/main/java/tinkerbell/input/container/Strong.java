package tinkerbell.input.container;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import tinkerbell.input.textelement.TextElement;

/**
 * Represents strong text fragment in a form of a {@link TextElementSequence}.
 * 
 * @author Paweł Zeller, Jakub Ziarko
 */

public class Strong{
	
	private final List<TextElement> strongs;
	
	public Strong(List <TextElement> element) {
		strongs = element;
	}

	public Stream<TextElement> stream(){
		return getStrongs().stream();
	}
	
	public List<TextElement> getStrongs() {
		return strongs;
	}

	@Override
	public int hashCode() {
		return strongs.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Strong)) return false;
		
		Strong strong = (Strong) obj;
		return strongs.equals(strong.getStrongs());	
	}
		
	
}
