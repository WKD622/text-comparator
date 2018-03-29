package tinkerbell.input;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * sialalalabamba,
 * Kamil wpadł do szamba,
 * przytrzymał się kija
 * i dostał w ryja...
 * @author jakub
 *
 */
public class SentenceBuilderImpl implements SentenceBuilder {
	private List <TextElement> pendingTextElements = new ArrayList<>();
	Stack<List <TextElement>> lists = new Stack<>();
	Stack<Integer> info = new Stack<Integer>();
	//deque
	@Override
	public SentenceBuilder word(String s) {
		int info = this.info.peek();
		switch (info) {
		case 1: 
			this.lists.peek().add(new Word(s));
			break;
		case 2:
			this.lists.peek().add(new Word(s));
			break;
		default:
			pendingTextElements.add(new Word(s));
			break;
		}
		return this;
	}
	
	@Override
	public SentenceBuilder strong() {
		List <TextElement> strongList = new ArrayList<>();
		lists.push(strongList);
		info.push(1);
		Strong strong = new Strong(strongList);
		pendingTextElements.add(strong);
		
		return this;
	}
	
	@Override
	public SentenceBuilder emphasis() {    
		List <TextElement> emphasisList = new ArrayList<>();
		lists.push(emphasisList);
		info.push(2);
		Emphasis emphasis = new Emphasis(emphasisList);
		pendingTextElements.add(emphasis);
		
		return null;
	}
	
	@Override
	public SentenceBuilder end() {
		if (!info.isEmpty() && !lists.isEmpty()) {
			info.pop();
			lists.pop();
		}
		return this;
	}
	
	@Override
	public Sentence build() {
		return new Sentence(pendingTextElements);
	}
	
}
