package com.ictexpertsgroup.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * This class is created to test and practice different kind of collections.
 * we will use all collections in this class by using Book and CreditRank Classes and their obejcts.
 * 
 *                       Iterable <I>
 *                          |
 *                      Collection <I>
 *                          |
 *              -------------------------------------------------------------------------
 *              |             					      |                  				|
 *             List <I>      					   Queue <I>        			   		Set <I> 
 *             	|											|________					|_____________________						
 *              |  			     					|				|		 			|		   			  |
 *              |                 				Deque <I>			PriorityQueue <C>   |						Sorted Set <I> 
 * 				|									|									|									|
 * 				|--------ArrayList <C>				|									----- HashSet <C>					|
 * 				|									/\									|									TreeSet <C>
 * 				|--------LinkedList <C>-------------   ArrayDeque (C)  						|----- LinkedHashSet <C>
 * 				|
 * 				|--------Vector <C>
 * 							|_____Stack <C>
 * 
 */
public class CollectionPractice {
	CollectionPractice() {

	}

	public static void collectionI_ArrayList() {
		Collection<Book> bookList = new ArrayList<>();
		bookList.add(new Book(1, "Learning Java", "Waseem", 4.0));
		bookList.add(new Book(2, "Java Collections", "Ahmad", 3.5));
		bookList.add(new Book(3, "C vs Java", "WAMS", 3.0));
		bookList.add(new Book(3, "C vs Java", "WAMS", 3.0));
		bookList.add(null);

//		print complete list
		System.out.println(bookList);
//		remove an item from the list, below method will remove only one occurance of the element.
		bookList.remove(new Book(3, "C vs Java", "WAMS", 3.0));
		System.out.println("remove object after finding\n" + bookList);

		/*
		 * practice some bulk operations addAll, removeAll, retainAll etc
		 */
		Collection<Book> bookList2 = new ArrayList<Book>();
		bookList2.add(new Book(4, "List2 Book", "List 2 Author", 4.4));
		bookList2.add(new Book(4, "List2 Book", "List 2 Author", 4.4));
		bookList2.add(new Book(3, "C vs Java", "WAMS", 3.0));

//		bookList.addAll(bookList2);
//		System.out.println(bookList);
//		
//		bookList.removeAll(bookList2);
//		System.out.println("bookList : " + bookList);
//		

		// again add all books in bookList2 to the bookList and test retainAll method of
		// the collection
//		it should retain only common objects which exist in both list and remain should be removed.
		// bookList.addAll(bookList2);
		// bookList.retainAll(bookList2);
		System.out.println(bookList);

		// Check the set method of the collection interface that is implemented in
		// ArrayList
		System.out.println(bookList2.contains(new Book(3, "C vs Java", "WAMS", 3.0)));

		System.out.println("bookList2 :: " + bookList2);
		System.out.println(bookList.containsAll(bookList2));

		System.out.println("Printing booklist collection with while(itr.hasnext()");
		// now iterate through collection

		Iterator<Book> itr = bookList.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

//		print booklist with for loop
		for (Book book : bookList) {
			System.out.println(book);
		}

		// convert the object in array and then print this.
		Book[] bookArray = (Book[]) bookList.toArray();
		for (Book book : bookArray) {
			System.out.println(book);
		}

	}

	public static void listI_ArrayList() {
		List<Book> bookList = new ArrayList<>();
		bookList.add(new Book(1, "Learning Java", "Waseem", 4.0));
		bookList.add(new Book(2, "Java Collections", "Ahmad", 3.5));
		bookList.add(new Book(3, "C vs Java", "WAMS", 3.0));
		bookList.add(new Book(3, "C vs Java", "WAMS", 3.0));
		bookList.add(null);

//		print complete list
		System.out.println(bookList);
//		remove item at particular index.
		bookList.remove(3);
		System.out.println("remove object at particular Index\n" + bookList);

		List<Book> bookList2 = new ArrayList<Book>();
		bookList2.add(new Book(-1, "book 1", "Author1", 2.0));
		bookList2.add(new Book(-2, "book 2", "Author2", 2.0));

		bookList.addAll(bookList2);
		Book tempBook = new Book(0, "Book 0", "Author 0", 1.0);

		bookList.add(tempBook);
		System.out.println("set new value at indes=3, previous element value was: "
				+ bookList.set(3, new Book(0, "Book 0", "Author 0", 1.0)));

		System.out.println("test contains method : " + bookList.contains(tempBook));

		System.out.println("test method indexOf :" + bookList.indexOf(tempBook));

		System.out.println("test method lastIndexOf : " + bookList.lastIndexOf(tempBook));

		// printing booklist with a while loop using iterator.
		Iterator<Book> itr = bookList.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		int i = 0;
		// print all elements in the list with for loop
		for (Book book : bookList) {
			System.out.println("bookList[" + i++ + "] : " + book);
		}

//		test range view methods of list
		System.out.println("\n\n :::::Testing sub list functions::::: \n\n");
		List<Book> subBookList = bookList.subList(2, 4);

		// tempBook.setId(5555);
		// subBookList.set(0, tempBook);
		subBookList.set(0, new Book(1234567, "Injection Book", "Injector", 1.2));

		i = 0;
		for (Book book : bookList) {
			System.out.println("bookList[" + i++ + "] : " + book);
		}

		// remove element during iterating... you cannot remove any element in the list
		// during foreach loop

		Iterator<Book> bookIerator = bookList.iterator();

		System.out.println("\n\n::Testing Remove::\n\n");
		while (bookIerator.hasNext()) {
			Book b = bookIerator.next();
			if (b.equals(new Book(1234567, "Injection Book", "Injector", 1.2))) {
				System.out.println("Element Found");
				bookIerator.remove();
			}
		}

		i = 0;
		for (Book book : bookList) {
			System.out.println("bookList[" + i++ + "] : " + book);
		}

		// bookList.forEach(System.out::println);
//		bookList.forEach(Book::printTopRatedBooks);
		bookList.forEach(new Filter());

		// Testing of list iterator iterface that is extedned from iterator.
		System.out.println("\n\nTesting ListIterator interface\n\n");
		ListIterator<Book> bookListIterator = bookList.listIterator();
		i = 0;
		while (bookListIterator.hasNext()) {
			System.out.println("bookList[" + bookListIterator.nextIndex() + "] : " + bookListIterator.next());
		}
		System.out.println("\n\n:: Printing list in reverse order ::\n\n");
//		i--;
		while (bookListIterator.hasPrevious()) {
			System.out.println("bookList[" + bookListIterator.previousIndex() + "] : " + bookListIterator.previous());
		}

	}

	public static void linkListTest() {
		// @SuppressWarnings("unused")
		List<Book> bookLinkedList = new LinkedList<Book>();

		bookLinkedList.add(new Book(1, "Learning Java", "Waseem", 4.0));
		bookLinkedList.add(new Book(2, "Java Collections", "Ahmad", 3.5));
		bookLinkedList.add(new Book(3, "C vs Java", "WAMS", 3.0));
		bookLinkedList.add(new Book(3, "C vs Java", "WAMS", 3.0));
		bookLinkedList.add(null);

		// bookLinkedList.remove(0);

		ListIterator<Book> li = bookLinkedList.listIterator();
		int i = 0;
		while (li.hasNext()) {
			Book b = li.next();
			if (i++ < 3) {
				li.remove();
			}
			System.out.println(b);
		}
		System.out.println("After removing first three elements, now print the list" + bookLinkedList);
		// li = bookLinkedList.listIterator();
		while (li.hasPrevious()) {
			System.out.println("Index " + li.previousIndex() + " - " + li.previous());
		}

		// create a new linked list and test lifo and fifo feature

		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.addFirst(10);
		ll.addLast(0);

		Iterator<Integer> it = ll.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		LinkedList<Integer> list = new LinkedList<Integer>();

		list.add(1);
		list.add(2);

		List<Integer> list2 = new ArrayList<Integer>(list);
		list2.forEach(System.out::println);
	}

	public static void arrayDequeTest() {

		Deque<Integer> deq = new ArrayDeque<Integer>();
		System.out.println(deq.offer(1));
		System.out.println(deq.add(2));
		System.out.println(deq.offerFirst(0));
		deq.addLast(3);
		deq.forEach(System.out::println);

		System.out.println("Peek : " + deq.peek()); // it will just return the first element in the Q, and element will
													// not be removed
		System.out.println("element : " + deq.element()); // it will just return the first element in the Q, and element
															// will not be removed
		System.out.println("getFirst : " + deq.getFirst()); // it will just return the first element in the Q, and
															// element will not be removed
		System.out.println("getLast : " + deq.getLast());
		System.out.println("peekFirst : " + deq.peekFirst());
		System.out.println("peekLast : " + deq.peekLast());
		System.out.println(" : " + deq.removeIf(n -> (n == 3)));

		// check the fifo feature
//		System.out.println(deq.remove());
//		System.out.println(deq.remove());
//		System.out.println(deq.remove());

		//
		System.out.println("\n\n:: Testing Stack Behavior :: \n\n");
		deq.push(4);
		deq.push(5);
		deq.forEach(System.out::println);

		System.out.println("Pop :: " + deq.pop());
		System.out.println("Pop :: " + deq.pop());
		System.out.println("Pop :: " + deq.pop());
		System.out.println("\n\n After Pop() \n\n");
		deq.forEach(System.out::println);

	}

	public static void priorityQueueTest() {
		Queue<Book> pQ = new PriorityQueue<Book>();
		pQ.add(new Book(1, "Java for Dummies", "Author 1", 1.2));
		pQ.add(new Book(2, "Spring Boot", "Author 1", 4.5));
		pQ.add(new Book(3, "Lamdas", "Author 1", 4.0));
		pQ.add(new Book(4, "CI/CD", "Author 1", 3.0));

		while (!pQ.isEmpty()) {
			System.out.println(pQ.remove());
		}

		// create custom comparator for String and use this in priority Q
		
		/* MEthod 1 : to create custom comparator:
		 * 
		 * Comparator<String> stringtLengthComparator = new Comparator<String>() {
			public int compare(String s1, String s2) {
				return s1.length()-s2.length();
			}
		};*/
		
		// now create a priority q using the above comparator
		Queue<String> pQS = new PriorityQueue<String>(new Comparator<String>() {
			public int compare (String s1, String s2) {
				return s1.length()-s2.length();
			}
		});
		
		pQS.add("Waseem");
		pQS.add("Muhammad Rayan");
		pQS.add("Siddique");
		pQS.add("Ahmad");
		
		pQS.forEach(System.out::println);
		
//		while(!pQS.isEmpty()) {
//			System.out.println("Remove : " + pQS.remove());
//		}
	}

	
	public static void main(String[] arg) {
		// collectionI_ArrayList();
		// listI_ArrayList();

//		linkListTest();
		//arrayDequeTest();
//		priorityQueueTest();
	}

}
