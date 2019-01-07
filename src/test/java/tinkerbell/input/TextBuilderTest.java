package tinkerbell.input;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tinkerbell.input.TextBuilder.ParagraphBuilder;

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
		assertThrows(IllegalArgumentException.class, () -> builder.section(null), //
				"Expected IllegalArgumentException when name=null");
	}
	
	@Test
	void testNullSentence() {
		assertThrows(IllegalArgumentException.class, () -> builder.paragraph().sentence(null), //
				"Expected IllegalArgumentException when sentence=null");
	}
	
	@Test
	void testFinishReturnValue() {
		assertSame(builder, builder.paragraph().finish());
	}
	
	@Test
	void testFinishSideEffects1() {
		ParagraphBuilder pb = builder.paragraph();
		pb.sentence(sentenceA);
		pb.finish();
		
		// I'm allowed to add another sentence here,
		// after finishing the paragraph
		pb.sentence(sentenceB);
		
		builder.paragraph();
		
		// I'm allowed to add another sentence here,
		// after creating a new paragraph
		pb.sentence(sentenceA);
	}
	
	@Test
	void testFinishSideEffects2() {
		ParagraphBuilder pb = builder.paragraph();
		pb.sentence(sentenceA);
		pb.finish();
		
		pb.sentence(sentenceB);
		
		builder.section("test");
		
		// I'm not allowed to add sentence after creating a new section
		assertThrows(IllegalStateException.class, () -> pb.sentence(sentenceB));
	}
	
	@Test
	void testFinishSideEffects3() {
		ParagraphBuilder pb = builder.paragraph();
		pb.sentence(sentenceA);
		pb.finish();
		
		// I'm allowed to add another sentence here,
		// after finishing the paragraph
		pb.sentence(sentenceB);
		
		builder.build();
		
		// I'm not allowed to add sentence after building
		assertThrows(IllegalStateException.class, () -> pb.sentence(sentenceB));
	}
	
	@Test
	void testFinishSideEffects4() {
		ParagraphBuilder pb = builder.paragraph();
		pb.sentence(sentenceA);
		pb.finish();
		
		pb.sentence(sentenceB);
		
		builder.paragraph();
		
		pb.sentence(sentenceA);
		
		builder.section("test");
		
		assertThrows(IllegalStateException.class, () -> pb.sentence(sentenceB));
		
		Text text = builder.build();
		assertEquals(text.getSections().get(0).getParagraphs().get(0).getSentences(),
				Arrays.asList(sentenceA, sentenceB, sentenceA));
		
		assertThrows(IllegalStateException.class, () -> pb.sentence(sentenceB));
	}
	
	@Test
	void testMultipleBuild() {
		builder.build();
		
		assertThrows(IllegalStateException.class, () -> builder.build());
	}
	
	@Test
	void testParagraphAfterBuild() {
		builder.build();
		
		assertThrows(IllegalStateException.class, () -> builder.paragraph());
	}
}
