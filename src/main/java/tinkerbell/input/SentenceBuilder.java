package tinkerbell.input;

public interface SentenceBuilder {
	SentenceBuilder word(String s);
	
	SentenceBuilder bold();

	SentenceBuilder emphasis();
	
	SentenceBuilder end();
	
	Sentence build();
}
