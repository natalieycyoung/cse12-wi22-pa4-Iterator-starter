/**
 * Name: Natalie Young
 * Email: nyoung@ucsd.edu
 * Sources used: zyBooks, javadocs
 * 
 * Contains MyLinkedList generic class and protected class Node
 */

import java.util.AbstractList;
import java.lang.*;
//import java.lang.NullPointerException;
//import java.lang.IndexOutOfBoundsException;
import java.util.ListIterator;

/** 
 * Implementation of Linked List extending AbstractList
 */

public class MyLinkedList<E> extends AbstractList<E>
{
	int size;
	Node head;
	Node tail;

	/**
	 * A Node class that holds data and references to previous and next Nodes.
	 */
	protected class Node
	{
		E data;
		Node next;
		Node prev;

		/** 
		 * Constructor to create singleton Node 
		 * @param element Element to add, can be null	
		 */
		public Node(E element)
		{
			// Initialize the instance variables
			this.data = element;
			this.next = null;
			this.prev = null;
		}

		/** 
		 * Set the parameter prev as the previous node
		 * @param prev - new previous node
		 */
		public void setPrev(Node prev)
		{
			this.prev = prev;		
		}

		/** 
		 * Set the parameter next as the next node
		 * @param next - new next node
		 */
		public void setNext(Node next)
		{
			this.next = next;
		}

		/** 
		 * Set the parameter element as the node's data
		 * @param element - new element 
		 */
		public void setElement(E element)
		{
			this.data = element;
		}

		/** 
		 * Accessor to get the next Node in the list 
		 * @return the next node
		 */
		public Node getNext()
		{
			return this.next;
		}

		/** 
		 * Accessor to get the prev Node in the list
		 * @return the previous node  
		 */
		public Node getPrev()
		{
			return this.prev;
		}

		/** 
		 * Accessor to get the Nodes Element 
		 * @return this node's data
		 */
		public E getElement()
		{
			return this.data;
		}
	}

	//  Implementation of the MyLinkedList Class
	/** 
	 * Only 0-argument constructor is defined
	 * Constructor that creates an empty list and initializes all necessary
	 * variables
	 */
	public MyLinkedList()
	{
		/* Add your implementation here */
		// TODO
		size = 0;

		head = new Node(null);
		tail = new Node(null);

		head.setNext(tail);
		tail.setPrev(head);
	}
	
	/**
	 * Returns number of nodes being stored
	 *
	 * @return size of this list
	 */
	@Override
	public int size()
	{
		return size; // TODO
	}

	/**
	 * Gets data within node at position index
	 *
	 * Throws IndexOutOfBoundsException when index < 0 or
	 * index >= number of elements in list
	 */
	@Override
	public E get(int index)
	{
		if (index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException();
		}

		Node curNode = head;

		for (int i = 0; i <= index; i++)
		{
			curNode = curNode.next;

			if (i == index)
			{
				return curNode.data;
			}
		}

		return curNode.data;
		// return (E) null;  // TODO
	}

	/**
	 * Adds node into list by index
	 * Input index can be any integer between zero and number of
	 * elements, inclusive
	 *
	 * Throws NullPointerException if data is null
	 * Throws IndexOutOfBoundsException when index < 0
	 * or index > number of elements in list
	 *
	 * @param index
	 * @param data
	 */
	@Override
	public void add(int index, E data)
	{
		/* Add your implementation here */
		// TODO
		if (data == null)
		{
			throw new NullPointerException();
		}

		if (index < 0 || index > size)
		{
			throw new IndexOutOfBoundsException();
		}

		/*
		if (size == 0)
		{
			head.data = data;
		}*/
		
		Node curNode = head.next;
		Node sucNode;
		int i;

		for (i = 0; i <= index; i++)
		{
			sucNode = curNode.next;

			if (i == index)
			{
				sucNode = curNode;

				curNode.data = data;
				curNode.next = sucNode;
				curNode.prev = head;

				size += 1;
			}

			curNode = sucNode;
		}
	}

	/**
	 * Adds a node at end into this list
	 * note: boolean add method will presumable always return true;
	 * it is boolean function due to method definition in
	 * AbstractList
	 *
	 * Throws NullPointerException if data is null
	 */
	public boolean add(E data)
	{
		if (data == null)
		{
			throw new NullPointerException();
		}

		Node newNode = new Node(data);
		Node precNode;

//		newNode.data = data;
		
		precNode = tail.prev;
		precNode.setNext(newNode);

		newNode.setPrev(precNode);
		newNode.setNext(tail);

		tail.setPrev(newNode);

		size += 1;

		return true; // TODO
	}

	/**
	 * Sets element for node at index to data, returns element
	 * previously stored in node
	 *
	 * Throws NullPointerException if data is null
	 * Throws IndexOutOfBoundsException when index < 0 or
	 * index >= number of elements in list
	 */
	public E set(int index, E data)
	{
		if (data == null)
		{
			throw new NullPointerException();
		}

		if (index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException();
		}

		Node curNode = head.next;
		E element = null;

		for (int i = 0; i <= index; i++)
		{
			if (i == index)
			{
				element = curNode.getElement();
				curNode.data = data;
			}
		}

		return element; // TODO
	}
/*
export CLASSPATH=".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar;.;./libs/hamcrest-core-1.3.jar;./libs/junit-4.12.jar"
 *
 */


	/**
	 * Removes node from at specified index, returns data within
	 * removed node
	 *
	 * Throws IndexOutOfBoundsException when index < 0
	 * or index >= number of elements in list
	 */
	public E remove(int index)
	{
		if (index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException();
		}

		int i;
		Node curNode = head.next;
		Node sucNode;
		Node precNode;
		E element = (E) null;

		// first loop to reach specified index and remove element
		for (i = 0; i <= index; i++)
		{
			sucNode = curNode.next;

			if (i == index)
			{
				precNode = curNode.prev;
				precNode.next = sucNode;
				sucNode.prev = precNode;

				element = curNode.data;
				size -= 1;
			}

			curNode = sucNode;
		}

		// second loop to repopulate rest of list
		for (; i < size; i++)
		{
			curNode = curNode.next;
		}

		return element; // TODO
	}

	/**
	 * Removes all nodes from list.
	 */
	public void clear()
	{
		head = tail;
		size = 0;
		/* Add your implementation here */
/*		for (int i = 0; i < size - 1; i++)
		{

		}
		*/
	}

	/**
	 * Determines if list is empty.
	 */
	public boolean isEmpty()
	{
		if (this.size() == 0)
		{
			return true;  // TODO
		}

		return false;
	}

	/**
	 * Helper method that returns Node at specified index
	 * --not content!
	 *
	 * Throws IndexOutOfBoundsException when index < 0 or
	 * index >= number of elements in list
	 */
	protected Node getNth(int index)
	{
		if (index < 0 || index >= size)
		{
			throw new IndexOutOfBoundsException();
		}

		Node curNode = head;

		for (int i = 0; i <= index; i++)
		{
			curNode = curNode.next;

			if (i == index)
			{
				return curNode;
			}
		}
		return (Node) null;  // TODO
	}


	/**
	 */
	protected class MyListIterator implements ListIterator<E>
	{
		// class variables
		Node left;
		Node right;
		int idx;	// int value of index of next node
		
		// determine current moving direction of iterator
		// true after calling next(), false after calling previous()
		// can be t/f after init because only used for remove and set
		boolean forward;
		boolean canRemoveOrSet;	// helper, should be init false
								// true after next or previous
								// false after add or remove

	
		// constructor
		public MyListIterator()
		{
			left = head;
			right = head.getNext();
			canRemoveOrSet = false;
		}

		// methods
		
		/**
		 *
		 */
		public boolean hasNext()
		{
			return false;
		}

		public E next()
		{
			return null;
		}

		public boolean hasPrevious()
		{
			return false;
		}

		public E previous()
		{
			return null;
		}

		public int nextIndex()
		{
			return 0;
		}

		public int previousIndex()
		{
			return 0;
		}

		public void add(E element)
		{
			if (element == null)
			{
				throw new NullPointerException();
			}

			Node node = new Node(element);
			node.setPrev(tail.getPrev());
			node.setNext(tail);
		}

		public void set(E element)
		{
			if (element == null)
			{
				throw new NullPointerException();
			}
		}

		public void remove()
		{}
	}
}

