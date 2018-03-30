package tinkerbell.input;

import java.util.List;

/**
 * TODO An instance of this type is used to create {@link Sentence} instances
 * easily...
 * 
 * @author jakub
 *
 */
public interface SentenceBuilder {
	@FunctionalInterface
	public interface TextElementSupplier {
		TextElement supply(List<TextElement> elements);
	}
	
	SentenceBuilder word(String s);
	
	/**
	 * This method initializes the strong part in {@link Sentence}. After this every
	 * {@link Word} added will be a strong word till end call. It can be used
	 * togather with emphasis method.
	 * 
	 * @return the built object
	 */
	default SentenceBuilder strong() {
		return block(Strong::new);
	}
	
	/**
	 * This method initializes the emphasis part in {@link Sentence}. After this
	 * every {@link Word} added will be a emphasis word till end call. It can be
	 * used togather with strong method.
	 * 
	 * @return the built object
	 */
	default SentenceBuilder emphasis() {
		return block(Emphasis::new);
	}
	
	SentenceBuilder block(TextElementSupplier supplier);
	
	/**
	 * TODO This methods ends ...
	 * 
	 * @return the built object
	 */
	SentenceBuilder end();
	
	/**
	 * This method finishes this builder, and returns the built {@link Sentence}
	 * object. When it finishes, every call to a method modifying this builder will
	 * result in an instance of {@link IllegalStateException} being thrown.
	 * 
	 * @return the {@link Sentence} object.
	 */
	Sentence build();
}
