package tinkerbell.input;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testing {@link TextBuilder} implementation provided by
 * {@link Text#builder()}.
 * 
 * @author Kamil Jarosz
 */
class TextBuilderTest {
	private Sentence sentenceA;
	private Sentence sentenceB;
	private TextBuilder builder;
	
	@BeforeEach
	void setUp() {
		List<TextElement> listA = new ArrayList<>();
		listA.add(new Word("a"));
		sentenceA = new Sentence(new ArrayList<>());
		
		List<TextElement> listB = new ArrayList<>();
		listB.add(new Word("b"));
		listB.add(new Word("c"));
		sentenceB = new Sentence(listB);
		
		builder = Text.builder();
	}
	
	@Test
	void testDefaultSectionName() {
		builder.paragraph().sentence(sentenceA).sentence(sentenceB);
		Text text = builder.build();
		
		assertEquals(text.getSections().get(0).getName(), null, //
				"Name of the default section must be null");
	}
	
	@Test
	void testNoSection() {
		Text text = builder.build();
		
		assertTrue(text.getSections().isEmpty(), //
				"When nothing added, no section should be built");
	}
	
	@Test
	void testSectionName() {
		builder.section("Section A").paragraph().sentence(sentenceA);
		builder.section("Section B").paragraph().sentence(sentenceB);
		
		Text text = builder.build();
		
		assertEquals(text.getSections().get(0).getName(), "Section A");
		assertEquals(text.getSections().get(1).getName(), "Section B");
	}
	
	@Test
	void testSectionContents() {
		builder.section("Section A").paragraph().sentence(sentenceA);
		builder.section("Section B") //
				.paragraph().sentence(sentenceB).sentence(sentenceA).finish() //
				.paragraph().sentence(sentenceB);
		
		Text text = builder.build();
		
		List<Paragraph> sectionAp = text.getSections().get(0).getParagraphs();
		List<Paragraph> sectionBp = text.getSections().get(1).getParagraphs();
		
		assertEquals(sectionAp.get(0).getSentences(), Arrays.asList(sentenceA));
		assertEquals(sectionBp.get(0).getSentences(), Arrays.asList(sentenceB, sentenceA));
		assertEquals(sectionBp.get(1).getSentences(), Arrays.asList(sentenceB));
	}
	
	@Test
	void testNullSectionName() {
		assertThrows(IllegalArgumentException.class, () -> builder.section(null));
	}
	
	@Test
	void testNullSentence() {
		assertThrows(IllegalArgumentException.class, () -> builder.paragraph().sentence(null));
	}
}
