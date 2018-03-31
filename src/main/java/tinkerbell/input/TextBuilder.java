package tinkerbell.input;

/**
 * An instance of this type is used to create {@link Text} instances easily. It
 * has an additional advantage over using constructors in a normal manner.
 * Namely unlike the constructors, it allows to reuse the memory used while
 * creating auxiliary objects. The lists, normally passed to the constructors,
 * are not copied when using this builder, also preserving the immutability of
 * created objects.
 * 
 * <p>
 * An instance of this builder may be obtained using {@link Text#builder()}
 * method. An example usage of this builder is given below:
 * 
 * <pre>
 * TextBuilder b = Text.builder();
 * b.section("Section name");
 * 
 * ParagraphBuilder pb = b.paragraph();
 * pb.sentence(sentenceA);
 * pb.sentence(sentenceB);
 * </pre>
 * 
 * <p>
 * For additional information aboiut usage of a specific method, see the
 * documentation thereof. For information about creating sentences, see
 * {@link Sentence} or {@link SentenceBuilder}.
 * 
 * <p>
 * Note: this builder is not suitable for creating multiple objects, as the
 * execution of the {@link #build()} method will cause this builder to be
 * immutable.
 * 
 * @see Text
 * @see Section
 * @see Paragraph
 * 
 * @author Kamil Jarosz
 */
public interface TextBuilder {
	/**
	 * For detailed information about the purpose of this type, see
	 * {@link TextBuilder#paragraph()}.
	 */
	public interface ParagraphBuilder {
		/**
		 * Adds a sentence to this paragraph.
		 * 
		 * @param sentence
		 *            the sentence to add
		 * 
		 * @return a reference to this object
		 * 
		 * @throws IllegalStateException
		 *             when {@link TextBuilder#build()} has been called on the parent
		 */
		ParagraphBuilder sentence(Sentence sentence);
		
		/**
		 * Finishes the process of creating a paragraph. This method is non-binding,
		 * i.e. after calling this method it's still possible to use the builder. The
		 * call which disallows to modify this builder further is
		 * {@link TextBuilder#build()}.
		 * 
		 * <p>
		 * It is only used as an auxiliary method for obtaining a reference to the
		 * parent {@link TextBuilder}. It is guaranteed that the returned object will be
		 * exactly the same as the object which the method
		 * {@link TextBuilder#paragraph()} used to obtain this object was called on. In
		 * other words:
		 * 
		 * <pre>
		 * TextBuilder b;
		 * ...
		 * ParagraphBuilder pb = b.paragraph();
		 * ...
		 * // this expression is always true
		 * pb.finish() == b;
		 * </pre>
		 * 
		 * @return the parent {@link TextBuilder}
		 */
		TextBuilder finish();
	}
	
	/**
	 * Starts a new section. Every paragraph added using the {@link #paragraph()}
	 * method will be included in the newly created section. For details see
	 * {@link #paragraph()}.
	 * 
	 * @param sectionName
	 *            name of the started section
	 * 
	 * @return a reference to this object
	 * 
	 * @throws NullPointerException
	 *             when sectionName is {@code null}
	 * @throws IllegalStateException
	 *             when {@link #build()} has been called before
	 * 
	 * @see #paragraph()
	 */
	TextBuilder section(String sectionName);
	
	/**
	 * Starts a new paragraph. In order to build the paragraph, an instance of
	 * {@link ParagraphBuilder} is returned which is coupled with the builder this
	 * method is called on. This object is called the parent of the returned
	 * {@link ParagraphBuilder}.
	 * 
	 * <p>
	 * The added paragraph will belong to either the last added section or the
	 * default one when no section has been added. That is, when the method
	 * {@link #section(String)} hasn't been called, all added paragraphs will belong
	 * to a virtual section i.e. without a name.
	 * 
	 * @return a builder used to build the started paragraph
	 * 
	 * @throws IllegalStateException
	 *             when {@link #build()} has been called before
	 */
	ParagraphBuilder paragraph();
	
	/**
	 * This method finishes this builder, and returns the built {@link Text} object.
	 * When it finishes, every call to a method modifying this builder will result
	 * in an instance of {@link IllegalStateException} being thrown.
	 * 
	 * @return the built object
	 */
	Text build();
}
