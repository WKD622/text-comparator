package tinkerbell.input;

/**
 * TODO
 * An instance of this type is used to create {@link Sentence} instances easily...
 * @author jakub
 *
 */
public interface SentenceBuilder {
	SentenceBuilder word(String s);
	
	/**
	 * This method initializes the strong part in {@link Sentence}. After this every 
	 * {@link Word} added will be a strong word till end call. It can be used togather 
	 * with emphasis method.
	 * 
	 * @return the built object
	 */
	SentenceBuilder strong();

	/**
	 * This method initializes the emphasis part in {@link Sentence}. After this every 
	 * {@link Word} added will be a emphasis word till end call. It can be used togather
	 * with strong method.
	 * 
	 * @return the built object
	 */
	SentenceBuilder emphasis();
	
	/**
	 * This methods ends any tag. For example if you have already started emphasis and you will
	 * use end every next added word will be a not emphasise word {@link Word}. There must be the 
	 * same amout of starts as ends. For example:
	 * ...emphasis().strong().word("example1").word("example2").end.end
	 * 
	 * @return the built object
	 */
	SentenceBuilder end();
	
	/**
	 * This method finishes this builder, and returns the built {@link Sentence} object.
	 * When it finishes, every call to a method modifying this builder will result
	 * in an instance of {@link IllegalStateException} being thrown.
	 * 
	 * @return the {@link Sentence} object.
	 */
	Sentence build();
}
