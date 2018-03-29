package tinkerbell.input;

public interface TextBuilder {
	
	/**
	 * Gives opportunity to create Paragraphs
	 * @author Kamil
	 *
	 */
	public interface ParagraphBuilder {
		/**
		 * Ads sentence to list of sentences waiting to become a part of a new paragraph
		 * @param s
		 * @return
		 */
		ParagraphBuilder sentence(Sentence s);
		
		/**
		 * Finishes a process of creating Paragraphs. 
		 * @return
		 */
		TextBuilder finish();
	}

	/**
	 * Creates a new section which name is sectionName
	 * @param sectionName
	 * @return
	 */
	TextBuilder section(String sectionName);

	ParagraphBuilder paragraph();

	Text build();
}
