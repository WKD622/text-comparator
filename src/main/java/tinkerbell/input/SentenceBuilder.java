package tinkerbell.input;

public interface SentenceBuilder {
	SentenceBuilder word(String s);
	
	SentenceBuilder strong();

	SentenceBuilder emphasis();
	
	SentenceBuilder end();
	
	Sentence build();
}
