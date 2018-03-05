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
	
	private final List<TextElement> emphasises = new ArrayList<>();
	
	public Emphasis() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void addElement(TextElement element) {
		emphasises.add(element);
	}
	
	@Override
	public List<TextElement> getAll() {
		return emp
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
