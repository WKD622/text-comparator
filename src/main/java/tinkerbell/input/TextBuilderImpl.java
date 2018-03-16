package tinkerbell.input;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class TextBuilderImpl implements TextBuilder {
	class ParagraphBuilderImpl implements ParagraphBuilder {
		private List<Sentence> sentences = new ArrayList<>();

		@Override
		public ParagraphBuilder sentence(Sentence s) {
			sentences.add(s);
			return this;
		}

		@Override
		public SentenceBuilder sentence() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public TextBuilder finish() {
			return TextBuilderImpl.this;
		}

		private Paragraph build() {
			sentences = Collections.unmodifiableList(sentences);
			return new Paragraph(sentences, true);
		}
	}

	private List<Section> sections = new ArrayList<>();

	private String sectionName = null;
	private List<ParagraphBuilderImpl> pendingParagraphs = new ArrayList<>();

	TextBuilderImpl() {

	}

	@Override
	public TextBuilder section(String sectionName) {
		flushSection();

		this.sectionName = sectionName;

		return this;
	}

	/**
	 * TODO
	 */
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
		ParagraphBuilderImpl b = new ParagraphBuilderImpl();
		pendingParagraphs.add(b);
		return b;
	}

	@Override
	public Text build() {
		flushSection();
		sections = Collections.unmodifiableList(sections);
		return new Text(sections);
	}
}
