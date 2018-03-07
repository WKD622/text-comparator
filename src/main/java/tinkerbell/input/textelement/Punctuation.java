package tinkerbell.input.textelement;

import java.util.stream.Stream;

import tinkerbell.input.container.Strong;

/**
 * Representation a punctuation mark as a TextElement implementation
 * 
 * @author Paweł Zeller, Jakub Ziarko
 */
public class Punctuation implements TextElement {
	private final String punctuation;

	public Punctuation(String punctuation) {
		this.punctuation = punctuation;
	}

	public String getPunctuation() {
		return punctuation;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Punctuation))
			return false;

		Punctuation punctuation = (Punctuation) obj;
		return this.punctuation.equals(punctuation.getPunctuation());
	}

	@Override
	public int hashCode() {
		return punctuation.hashCode();
	}

	@Override
	public Stream<Word> words() {
		return Stream.of();
	}
}
