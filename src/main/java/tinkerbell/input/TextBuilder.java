package tinkerbell.input;

public interface TextBuilder {
	public interface SentenceBuilder {
		SentenceBuilder word(Word w);
	}

	public interface ParagraphBuilder {
		ParagraphBuilder sentence(Sentence s);

		SentenceBuilder sentence();

		TextBuilder finish();
	}

	TextBuilder section(String sectionName);

	ParagraphBuilder paragraph();

	Text build();
}
