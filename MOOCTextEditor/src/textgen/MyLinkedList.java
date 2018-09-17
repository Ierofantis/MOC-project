package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
	    // TODO: Implement this method
             size=0;
	     head = new LLNode<E>(null);
	     tail = new LLNode<E>(null);
	     head.next = tail;
	     tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		LLNode<E> newNode = new LLNode<E>(element);
		tail.prev.next = newNode;
		newNode.prev = tail.prev;
		newNode.next = tail;
		tail.prev = newNode;		
		size++;
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if( index < 0 || index >= size ){
			throw new IndexOutOfBoundsException("Invalid index");
		}	
		
		LLNode<E> temp=head;
		
		for(int i=0; i<index; i++)
		{
		   temp = temp.next;
		}
		return temp.next.data;	
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if( index > this.size ){
			throw new IndexOutOfBoundsException("Invalid index");
		}
		
		if (element == null) {
			throw new NullPointerException("Cannot be null");
		}
		
		LLNode<E> temp = head;
		//LLNode<E> holder;
		for(int i=0; i < index-1 && temp.next != null; i++)
		{
			temp = temp.next;
		}
		LLNode<E> newNode = new LLNode<E>(element);
		temp.next.prev = newNode;
		newNode.next = temp.next;
		newNode.prev = temp;
		temp.next = newNode;
		this.size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if( index < 0 || index >= size ){
			throw new IndexOutOfBoundsException("Invalid index");
		}
		LLNode<E> temp = head;
		for(int i=0; i< index - 1 && temp.next != null; i++)
		{
			temp = temp.next;
		}
		LLNode<E> current = temp.next;
		temp.next = current.next;
		current.next.prev = temp;
		current.next = null;
		current.prev = null;
		this.size--;
		return current.data;
		//return null;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if( index < 0 || index >= size ){
			throw new IndexOutOfBoundsException("Invalid index");
		}
		if( element == null ){
			throw new NullPointerException("Null Pointer");
		}
		LLNode<E> temp = head;
		for(int i=0; i< index - 1 && temp.next != null; i++)
		{
			temp = temp.next;
		}
		E current = temp.next.data;
		temp.next.data = element;
		return current;		
	}   
	
	
	
}



class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	public LLNode() {
		this.prev = null;
		this.next = null;
	}

}
