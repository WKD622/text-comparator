package tinkerbell.input;

import java.util.ArrayList;
import java.util.List;

/**
 * SentenceBuilder implementation.
 * 
 * @author Jakub Ziarko
 *
 */
public class SentenceBuilderImpl implements SentenceBuilder {
	private List<ElementToBuild> elementsToBuild = new ArrayList<>();
	int i;
	
	@Override
	public SentenceBuilder word(String word) {
		elementsToBuild.add(new ElementToBuild(word, Tags.Word));
		return this;
	}
	
	public SentenceBuilder punctuation(String punctuation) {
		elementsToBuild.add(new ElementToBuild(punctuation, Tags.Punctuation));
		return this;
	}
	
	@Override
	public SentenceBuilder strong() {
		elementsToBuild.add(new ElementToBuild(Tags.Strong));
		return this;
	}
	
	@Override
	public SentenceBuilder emphasis() {
		elementsToBuild.add(new ElementToBuild(Tags.Emphasis));
		return this;
	}
	
	@Override
	public SentenceBuilder end() {
		elementsToBuild.add(new ElementToBuild(Tags.End));
		return this;
	}
	
	@Override
	public Sentence build() {
		int countEnd = 0, countStart = 0;
		for (ElementToBuild element : elementsToBuild) {
			switch (element.tag) {
				case Strong: case Emphasis:
					countStart++;
					break;
				case End:
					countEnd++;
					break;
				default:
					break;
			}
		}
		if (countEnd != countStart) {
			//TODO throw exeption 
		}
		i = 0;
		return new Sentence(internalBuild());
	}
	
	private List<TextElement> internalBuild() {
		List<TextElement> list = new ArrayList<TextElement>();
		
		while (elementsToBuild.get(i).getTag() != Tags.End &&
				elementsToBuild.get(i).getElement() != ".") {
			switch (elementsToBuild.get(i).getTag()) {
			case Strong:
				list.add(new Strong(internalBuild()));
				break;
			case Emphasis:
				list.add(new Emphasis(internalBuild()));
				break;
			case Word:
				list.add(new Word(elementsToBuild.get(i).textElement));
				break;
			default:
				list.add(new Punctuation(elementsToBuild.get(i).textElement));
				break;
			}
			i++;
		}
		list.add(new Punctuation(elementsToBuild.get(i).textElement));
		return list;
	}
	
	private class ElementToBuild {
		private final String textElement;
		final Tags tag;
		
		public String getElement() {
			return textElement;
		}
		
		public Tags getTag() {
			return tag;
		}
		
		public ElementToBuild(String element, Tags tag) {
			this.tag = tag;
			this.textElement = element;
		}
		
		public ElementToBuild(Tags tag) {
			this.tag = tag;
			this.textElement = null;
		}
	}
	
	private enum Tags {
		Strong, Emphasis, End, Punctuation, Word
	}
}
