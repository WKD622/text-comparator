package tinkerbell.input.container;

import java.util.List;
import java.util.stream.Stream;

/**
 * Represents basic structure component interface
 * 
 * @author Paweł Zeller, Jakub Ziarko
 * @param <T>
 */
public interface Container<T> {
	void addElement(T element);
	
	List<T> getAll();
	
	default Stream<T> stream(){
		return getAll().stream();
	}
}
