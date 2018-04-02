package tinkerbell.input;

/**
 * An instance of this type is used to create {@link Sentence} instances easily. 
 * Namely unlike the constructors, it allows to reuse the memory used while
 * creating auxiliary objects. The lists, normally passed to the constructors,
 * are not copied when using this builder, also preserving the immutability of
 * created objects.
 * 
 * <p>
 * An example usage of this builder is given below:
 * 
 * <pre>
 * SentenceBuilder sb = new SentenceBuilder();
 * Sentence s = sb.word("example1").strong().word("example2").emphasis().word("example3").end().end();
 * </pre>
 * 
 * <p>
 * This will create sentence" "example1 example2 example3" where "example2" is strong
 * and "example3" is strong and emphasis.
 * 
 * <p>
 * For additional information aboiut usage of a specific method, see the
 * documentation thereof. For information about creating text with sections, paragraphs, see
 * {@link Paragraph}, {@link Section}, {@link Text} or {@link TextBuilder}.
 * 
 * @author Jakub Ziarko 
 *
 */
public interface SentenceBuilder {
	/**
	 * This method adds new word to part which was began earlier. For example: we initalized
	 * builder as it is shown above, when we just now start adding words like this:
	 * 
	 * <pre>
	 * sb.word("example1").word("example2");
	 * </pre>
	 * 
	 * <p> we will get normal words in our object struture created, but then if we add 
	 * emphasis method this way:
	 * 
	 * <pre>
	 * sb.emphasis().word("example3").word("example4").end();
	 * </pre>
	 * 
	 * <p> every next added word will be emphasis till we use end() operation.
	 * 
	 * @param word
	 * @return
	 */
	SentenceBuilder word(String word);
	
	/**
	 * This method initializes the new tag - strong part in {@link Sentence}. After this every 
	 * {@link Word} added will be a strong word till end call. It can be used togather 
	 * with other tags start methods.
	 * 
	 * @return the built object
	 */
	SentenceBuilder strong();

	/**
	 * This method initializes the new tag - emphasis part in {@link Sentence}. After this every 
	 * {@link Word} added will be a emphasis word till end call. It can be used togather 
	 * with other tags start methods.
	 * 
	 * @return the built object
	 */
	SentenceBuilder emphasis();
	
	/**
	 * This method adds new punctuation. We use it to add punctuation to our object structure.
	 * For example sentence like "Example1 example2, example3." will look like this when being 
	 * created:
	 * 
	 * <pre>
	 * sb.word("Example1").word("example2").punctuation(",").word("example3").punctuation(".");
	 * @param punctuation
	 * @return
	 */
	public SentenceBuilder punctuation(String punctuation);
	
	/**
	 * This methods ends last added tag. For example if you have already started emphasis and you will
	 * use end every next added word will be a not emphasise word {@link Word}. There must be the 
	 * same amout of starts as ends. For example:
	 * 
	 * <pre>
	 * ...emphasis().strong().word("example1").word("example2").end().end()
	 * </pre>
	 * 
	 * @return the built object
	 */
	SentenceBuilder end();
	
	/**
	 * This method finishes this builder, and returns the built {@link Sentence} object.
	 * There must be the same amount of started tags as ends, if not - build() throws exeption. 
	 * TODO - exeption
	 * 
	 * @return the {@link Sentence} object.
	 */
	Sentence build();
}
