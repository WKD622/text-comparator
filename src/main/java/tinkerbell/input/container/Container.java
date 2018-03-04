package tinkerbell.input.container;

import java.util.List;

/**
 * Represents basic structure component interface
 * 
 * @author Pawe³, Kuba
 * @param <T>
 * 
 */
public interface Container<T> {
	
	void addElement(T element);
	
	void deleteElement(T element);
	
	T findElement(T element);
	
	List<T> getAll();
	
}
