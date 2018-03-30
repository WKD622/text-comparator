package tinkerbell.input;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class SentenceBuilderImpl implements SentenceBuilder {
	private class Block {
		private TextElementSupplier supplier;
		private List<TextElement> elements = new ArrayList<>();
		
		private Block(TextElementSupplier supplier) {
			this.supplier = supplier;
		}
		
		private void add(TextElement el) {
			elements.add(el);
		}
		
		private TextElement build() {
			return supplier.supply(elements);
		}
	}
	
	// when # of blocks is 0, this builder is finished
	private Deque<Block> blocks = new ArrayDeque<>();
	
	SentenceBuilderImpl() {
		blocks.push(new Block(null));
	}
	
	private void checkFinished() {
		if (blocks.isEmpty()) throw new IllegalStateException("builder is finished");
	}
	
	@Override
	public SentenceBuilder word(String s) {
		checkFinished();
		
		blocks.peek().add(new Word(s));
		return this;
	}
	
	@Override
	public SentenceBuilder strong() {
		return block(l -> new Strong(l, true));
	}
	
	@Override
	public SentenceBuilder emphasis() {
		return block(l -> new Emphasis(l, true));
	}
	
	@Override
	public SentenceBuilder block(TextElementSupplier supplier) {
		checkFinished();
		
		blocks.push(new Block(supplier));
		return this;
	}
	
	@Override
	public SentenceBuilder end() {
		if (blocks.size() <= 1) {
			throw new IllegalStateException("no block to end");
		}
		
		TextElement seq = blocks.pop().build();
		blocks.peek().add(seq);
		
		return this;
	}
	
	@Override
	public Sentence build() {
		checkFinished();
		
		while (blocks.size() > 1)
			end();
		
		return new Sentence(blocks.pop().elements, true);
	}
}
