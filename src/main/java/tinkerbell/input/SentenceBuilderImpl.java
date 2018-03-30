package tinkerbell.input;

import java.util.ArrayList;
import java.util.List;

/**
 * sialalalabamba, Kamil wpadł do szamba, przytrzymał się kija i dostał w
 * ryja...
 * 
 * @author jakub
 *
 */
public class SentenceBuilderImpl implements SentenceBuilder {
	private List<QueueElement> queue = new ArrayList<>();
	
	@Override
	public SentenceBuilder word(String s) {
		queue.add(new QueueWord(s));
		return this;
	}
	
	@Override
	public SentenceBuilder strong() {
		queue.add(QueueStartEnd.StrongStart);
		return this;
	}
	
	@Override
	public SentenceBuilder emphasis() {
		queue.add(QueueStartEnd.EmphasisStart);
		return this;
	}
	
	@Override
	public SentenceBuilder end() {
		queue.add(QueueStartEnd.End);
		return this;
	}
	
	@Override
	public Sentence build() {
		int countEnd = 0, countStart = 0;
		for (QueueElement element: queue) {
			if  (element instanceof QueueStartEnd) {
				if ( element == QueueStartEnd.End)
					countEnd++;
				else
					countStart++;
			}
		}
		if ( countEnd > countStart) {
			//TODO throw exeption (more ends than starts)
		}
		else if ( countStart > countEnd) {
			//TODO throw exeption (more starts than ends)
		}
		return new Sentence(internalBuild(0));
	}
	
	private List <TextElement> internalBuild(Integer i) { 
		List <TextElement> list = new ArrayList<TextElement>();
		
		while (!(queue.get(i) instanceof QueueStartEnd) && queue.get(i) != QueueStartEnd.End) {
			if (queue.get(i) == QueueStartEnd.StrongStart) {
				list.add(new Strong(internalBuild(i)));
				
			}else if (queue.get(i)== QueueStartEnd.EmphasisStart) {
				list.add(new Emphasis(internalBuild(i)));
						
			} else {
				list.add(new Word(((QueueWord)queue.get(i)).getWord()));	
			}
			i++;
		}
		return list;
	}
	
	private interface QueueElement{
	}
	
	private class QueueWord implements QueueElement{
		private final String word;
		
		public String getWord() {
			return word;
		}
		public QueueWord(String word){
			this.word = word;
		}
	}
	
	private enum QueueStartEnd implements QueueElement{
		StrongStart, EmphasisStart, End
	}
}
