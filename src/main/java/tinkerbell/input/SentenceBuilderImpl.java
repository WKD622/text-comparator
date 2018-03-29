package tinkerbell.input;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author jakub
 *
 */
public class SentenceBuilderImpl implements SentenceBuilder {
	private ArrayList <ArrayList <TextElement>> list = new ArrayList <ArrayList <TextElement>>();
	private List <TextElement> pendingTextElements = new ArrayList<>();
	int i;
	
	@Override
	public SentenceBuilder word(String s) {
		pendingTextElements.add(new Word(s));
		i++;
		return this;
	}
	
	@Override
	public SentenceBuilder strong() {
		List <TextElement> strongList = new ArrayList<>();
		
		return null;
	}
	
	@Override
	public SentenceBuilder emphasis() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public SentenceBuilder end() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Sentence build() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
