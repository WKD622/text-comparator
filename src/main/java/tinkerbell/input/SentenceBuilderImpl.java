package tinkerbell.input;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * sialalalabamba, Kamil wpadł do szamba, przytrzymał się kija i dostał w
 * ryja...
 * 
 * @author jakub
 *
 */
public class SentenceBuilderImpl implements SentenceBuilder {
	private List<TextElement> pendingTextElements = new ArrayList<>();
	private Deque<List<TextElement>> lists = new ArrayDeque<>();
	private boolean strongStart = false, emphasisStart = false;
	
	@Override
	public SentenceBuilder word(String s) {
		if (!lists.isEmpty())
			this.lists.peekFirst().add(new Word(s));
		else
			pendingTextElements.add(new Word(s));
		return this;
	}
	
	@Override
	public SentenceBuilder strong() {
		if (!strongStart) {
			List<TextElement> strongList = new ArrayList<>();
			if (!emphasisStart)
				pendingTextElements.add(new Strong(strongList));
			else {
				ArrayList<TextElement> pom = (ArrayList<TextElement>) pendingTextElements
						.get(pendingTextElements.size() - 1);
				pom.add(new Strong(strongList));
			}
			lists.addFirst(strongList);
		}
		return this;
	}
	
	@Override
	public SentenceBuilder emphasis() {
		if (!emphasisStart) {
			List<TextElement> emphasisList = new ArrayList<>();
			if (!strongStart)
				pendingTextElements.add(new Strong(emphasisList));
			else {
				ArrayList<TextElement> pom = (ArrayList<TextElement>) pendingTextElements
						.get(pendingTextElements.size() - 1);
				pom.add(new Strong(emphasisList));
			}
			lists.addFirst(emphasisList);
		}
		return this;
	}
	
	@Override
	public SentenceBuilder end() {
		if (!lists.isEmpty()) {
			lists.pop();
		}
		return this;
	}
	
	@Override
	public Sentence build() {
		return new Sentence(pendingTextElements);
	}
	
}
