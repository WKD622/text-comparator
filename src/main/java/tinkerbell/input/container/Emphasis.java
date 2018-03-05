package tinkerbell.input.container;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import tinkerbell.input.textelement.TextElement;

/**
 * Represents emphasized text in a form of TextElementSequence
 * 
 * @author Paweł Zeller, Jakub Ziarko
 */
public class Emphasis implements TextElementSequence {
	
	private final List<TextElement> emphasises;
	
	public Emphasis(List<TextElement> element) {
		emphasises = element;
	}
	
	public List<TextElement> getEmphasises() {
		return emphasises;
	}

	public Stream<TextElement> stream(){
		return getEmphasises().stream();
	}
	
	@Override
	public int hashCode() {
		return emphasises.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Emphasis)) return false;
		
		Emphasis emphasis = (Emphasis) obj;
		return emphasises.equals(emphasis.getEmphasises());
	}
}
