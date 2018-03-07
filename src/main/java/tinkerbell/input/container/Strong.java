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

public class Strong implements TextElementSequence, TextElement{
	
	private final List<TextElement> textElements;
	
	public Strong(List <TextElement> element) {
		textElements = element;
	}

	public Stream<TextElement> stream(){
		return getStrongs().stream();
	}
	
	public List<TextElement> getStrongs() {
		return textElements;
	}

	@Override
	public int hashCode() {
		return textElements.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Strong)) return false;
		
		Strong strong = (Strong) obj;
		return textElements.equals(strong.getStrongs());	
	}
		
}
