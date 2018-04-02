package tinkerbell.input;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class TextBuilderImpl implements TextBuilder {
	class ParagraphBuilderImpl implements ParagraphBuilder {
		/** When built, it should be {@code null}. */
		private List<Sentence> sentences = new ArrayList<>();
		
		@Override
		public ParagraphBuilder sentence(Sentence s) {
			if (sentences == null) {
				throw new IllegalStateException("this paragraph is finished");
			}
			
			if (s == null) {
				throw new IllegalArgumentException("null sentence");
			}
			
			sentences.add(s);
			return this;
		}
		
		@Override
		public TextBuilder finish() {
			return TextBuilderImpl.this;
		}
		
		private Paragraph build() {
			Paragraph ret = new Paragraph(sentences, true);
			sentences = null;
			return ret;
		}
	}
	
	/** When built, it should be {@code null}. */
	private List<Section> sections = new ArrayList<>();
	
	private String sectionName = null;
	private List<ParagraphBuilderImpl> pendingParagraphs = new ArrayList<>();
	
	TextBuilderImpl() {
		
	}
	
	@Override
	public TextBuilder section(String sectionName) {
		if (sectionName == null) throw new IllegalArgumentException("null section name");
		
		flushSection();
		
		this.sectionName = sectionName;
		return this;
	}
	
	private void flushSection() {
		if (sectionName != null || !pendingParagraphs.isEmpty()) {
			List<Paragraph> paragraphs = pendingParagraphs.stream() //
					.map(ParagraphBuilderImpl::build) //
					.collect(Collectors.toList());
			sections.add(new Section(sectionName, paragraphs, true));
		}
		
		sectionName = null;
		pendingParagraphs.clear();
	}
	
	@Override
	public ParagraphBuilder paragraph() {
		if (sections == null) throw new IllegalStateException("builder finished");
		
		ParagraphBuilderImpl b = new ParagraphBuilderImpl();
		pendingParagraphs.add(b);
		return b;
	}
	
	@Override
	public Text build() {
		if (sections == null) throw new IllegalStateException("builder finished");
		
		flushSection();
		
		Text ret = new Text(sections);
		sections = null;
		return ret;
	}
}
