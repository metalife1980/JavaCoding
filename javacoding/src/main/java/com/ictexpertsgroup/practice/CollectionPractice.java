package com.ictexpertsgroup.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

	public static void hashSetTest() {
		Set<CreditRank> hsCreditRank = new HashSet<CreditRank>();
		hsCreditRank.add(new CreditRank(1,"Poor"));
		hsCreditRank.add(new CreditRank(2,"Improved"));
		hsCreditRank.add(new CreditRank(3,"Good"));

		List<CreditRank> listCreditRank = new ArrayList<CreditRank>();
		listCreditRank.add(new CreditRank(4,"Better"));
		listCreditRank.add(new CreditRank(5,"Best"));
		listCreditRank.add(new CreditRank(1,"Poor")); // this is duplicate item and will not be added in hashset
		
		hsCreditRank.addAll(listCreditRank);
		
		hsCreditRank.forEach(System.out::println);
		
		//practice remove methods 
		System.out.println(hsCreditRank.contains(new CreditRank(1,"Poor")));
		
	}

	public static void linkedHashSetTest() {  
		/*
		 * LinkedHashSet internally use linked list and hashMap and it preservers the insertion order
		 */
		Set<CreditRank> lhsCreditRank = new LinkedHashSet<CreditRank>();

		List<CreditRank> listCreditRank = new ArrayList<CreditRank>();
		listCreditRank.add(new CreditRank(4,"Better"));
		listCreditRank.add(new CreditRank(5,"Best"));
		listCreditRank.add(new CreditRank(1,"Poor")); // this is duplicate item and will not be added in hashset
		
		lhsCreditRank.addAll(listCreditRank);
		lhsCreditRank.add(new CreditRank(1,"Poor"));
		lhsCreditRank.add(new CreditRank(2,"Improved"));
		lhsCreditRank.add(new CreditRank(3,"Good"));
		
		lhsCreditRank.forEach(System.out::println);
		
		//practice remove methods 
		System.out.println(lhsCreditRank.contains(new CreditRank(1,"Poor")));
		
	}

	public static void sortedSetTest() {
		TreeSet<CreditRank> ts = new TreeSet<CreditRank>();
		List<CreditRank> listCreditRank = new ArrayList<CreditRank>();
		listCreditRank.add(new CreditRank(4,"Better"));
		listCreditRank.add(new CreditRank(5,"Best"));
		listCreditRank.add(new CreditRank(1,"Poor")); // this is duplicate item and will not be added in hashset
		
		ts.addAll(listCreditRank);
		ts.add(new CreditRank(1,"Poor"));
		ts.add(new CreditRank(2,"Improved"));
		ts.add(new CreditRank(3,"Good"));
		
		ts.forEach(System.out::println);
		
		System.out.println("\n\nTesting with Comparator\n\n");
		TreeSet<CreditRank> ts2 = new TreeSet<>( new RankComparator() );
		List<CreditRank> listCreditRank2 = new ArrayList<CreditRank>();
		listCreditRank2.add(new CreditRank(4,"Better"));
		listCreditRank2.add(new CreditRank(5,"Best"));
		listCreditRank2.add(new CreditRank(1,"Poor")); // this is duplicate item and will not be added in hashset
		
		ts2.addAll(listCreditRank2);
		ts2.add(new CreditRank(1,"Poor"));
		ts2.add(new CreditRank(2,"Improved"));
		ts2.add(new CreditRank(3,"Good"));
		
		ts2.forEach(System.out::println);
		
		
	}

	public static void navigableSetTest () {

		
		NavigableSet<Integer> nsT = new TreeSet<Integer>();
		nsT.add(5);
		nsT.add(23);
		nsT.add(74);
		nsT.add(89);
		
		System.out.println("lower:" + nsT.lower(74));
		System.out.println("floor:" + nsT.floor(74));
		System.out.println("celing:" + nsT.ceiling(74));
		System.out.println("higher:" + nsT.higher(74));
		System.out.println("first:" + nsT.first());
		System.out.println("last:" + nsT.last());
		
		System.out.println(nsT);
		
		Iterator<Integer> it =  nsT.descendingIterator();
		while (it.hasNext()) {
			System.out.println("desc iterator:" + it.next());
		}

		//if any change made in the subset descending set, tailset or headset return objectsm, changes will also be made to the super set.
		NavigableSet< Integer> descendingSet = nsT.descendingSet();
		System.out.println(descendingSet);
		descendingSet.remove(23);
		System.out.println("\n AFter removing 23 ");
		System.out.println(nsT);
		
		descendingSet.add(23);
		System.out.println("\nAdd 23 againt to the set");
		System.out.println(nsT);

		//test tail set and head set
		NavigableSet<Integer> tailset = nsT.tailSet(74, true);
		System.out.println("\nTailset :: " + tailset);
		
		NavigableSet<Integer> headset = nsT.headSet(74, true);
		System.out.println("\nheadset :: " + headset);
		
		headset.add(4); // you cannot add an
		
		System.out.println("super set  :" + nsT);
		
		// now add some value to the tail set and seet the superset
		tailset.add(100);
		System.out.println("super set  :" + nsT);		
		
		NavigableSet<Integer> ss = 	(NavigableSet<Integer>) nsT.subSet(23, 89);
		
		SortedSet<Integer> sortedset = nsT.subSet(23, 89);
		
		System.out.println(ss);
		System.out.println(sortedset);
	 
		sortedset.add(25);
		ss.add(60);
		System.out.println(nsT);
	}
	
	public static void hashMapTest() {
		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("Poor", 0);
		m.put("Improved", 1);
		m.put("Good", 2);
		m.put("Better", 3	);
		
		for (Map.Entry<String, Integer> e : m.entrySet()) {
			System.out.println("Key Value Pair:" + e.getKey() + " - " + e.getValue());
		}
		
		System.out.println(m.get("Poor"));
		m.put("Poor",1);
		System.out.println(m);
		
		m.putIfAbsent("Excellent", 4);
		System.out.println(m);

		m.putIfAbsent("Excellent", 5);
		System.out.println(m);
		
		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.putAll(m);
		
		System.out.println("new hashmap from old hashmap:" + hm);
		hm.put("Excellent", 5);
		System.out.println("old hashmap"+ m);
		System.out.println("new hashmap:" + hm);
		
//		m.remove("Poor");
//		System.out.println("old hashmap"+ m);
//		
//		m.remove("Good", 7);
//		System.out.println("old hashmap"+ m);
//
//		m.remove("Good", 2);
//		System.out.println("old hashmap"+ m);
		
		System.out.println(m.replace("Poor", 0));
		System.out.println(m.replace("Poor", 0, 11));
		
		m.replaceAll((k,v)->{
			Integer nv=0;
			if (k.equals("Poor") || k.equals("Good")) {
				nv= -1;
			}
			return nv;
		});
		
		System.out.println("old hashmap"+ m);
		
		
		// test hasmap with creditrank class and books java class.
		
		// iterate keys and values...
		// use maps and streams....
		
	}
	
	
	static boolean filter(String doc, Predicate<String> filterDoc) {
		return filterDoc.test(doc);
		
	}

	
	public static void testFunctionInterfaces() {
		String doc1 = "<html><body>One of the most common uses of <i>streams</i> is to represent queries over data in collections</body></html>";
		String doc2 = "<html><body>Information integration systems provide valuable services to users by integrating information from a number of autonomous, heterogeneous and distributed Web sources</body></html>";
		String doc3 = "<html><body>Solr is the popular, blazing fast open source enterprise search platform from the Apache Lucene</body></html>";
		String doc4 = "<html><body>Java 8 goes one more step ahead and has developed a streams API which lets us think about parallelism</body></html>";
		List<String> documents = new ArrayList<String>(Arrays.asList(doc1,doc2,doc3,doc4));
		
		Predicate<String> p = (str) -> str.contains("streams"); // this is lambda expression
		Function<String, String> transform = (str) -> {
			return str.replace("<html><body>", " ");
			};		
			
		Function <String, String> replaceSpaceToEndLine = (str) -> str.replaceAll("\\s", "\n") ;	
		
		for (String doc : documents) {
			if(p.test(doc)) {
				System.out.println("stream keyword found");
				String res = 	transform.apply(doc);
				res = replaceSpaceToEndLine.apply(res);
				System.out.println(res);
			}
		}
		System.out.println("After for loop and test by calling interface functions directly");
		
//		System.out.println(documents.get(0));
		
		
		documents.forEach( (doc) -> {
					if(p.test(doc)) {
						System.out.println("stream keyword found");
						String res = 	transform.apply(doc);
						res = replaceSpaceToEndLine.apply(res);
						System.out.println(res);
					}
					}
				);
		

		FilterFunctionalInterface f = (str) -> str.contains("streams"); // this is lambda expression
		
		documents.forEach( (doc) -> {
								if (f.checkKeyWord("streams")) {
									System.out.println(doc);
								}
						}
		);
		
		System.out.println("\n\n:: Calling implemented function in interface class\n\n");
		documents.stream().filter((doc)->f.evaluateKeyWord(doc)).forEach(System.out::println);

	//	documents.stream().filter((doc)->doc.contains("streams")).forEach(System.out::println);
			
		
		
		
	}
	
	public static void testStreamMaps() {
//		List <String> l = Arrays.asList("1","2", "3", "4");
//		List <Integer> il = l.stream().map(s->Integer.parseInt(s)).collect(Collectors.toList());
//		Integer i = l.stream().mapToInt(s->Integer.parseInt(s)).sum();
//		System.out.println(i);
//		
//		Function <String, String> foo= (p)->p.replace("g", "h");
		
		
		List <String> stringList = Arrays.asList("a","b","c","d");
		
		List <String> stringList2 = stringList.stream().map(s->s.toUpperCase()).collect(Collectors.toList()).subList(1, 3).stream().map(s->s.concat("_*")).collect(Collectors.toList());
		System.out.println(stringList);
		System.out.println(stringList2);
		
		List <Integer> integerList = Arrays.asList(1,2,3,4);
		integerList.stream().map(i->i*2).collect(Collectors.toList()).forEach(System.out::println);
		
		
		//Play with flatmaps
		
		System.out.println();
		String [][] arr = new String [][] {
											{"a","b"},{"c","a"}
										  };
		
		Arrays.stream(arr).map(s->s).filter(x->x.equals("a")).forEach(System.out::println);
		Arrays.stream(arr).flatMap(s->Arrays.stream(s)).filter(x->x.equals("a")).forEach(System.out::println);
		
		//Collections, hashset, streams, flatmap
		Student obj1 = new Student();
        obj1.setName("mkyong");
        obj1.addBook("Java 8 in Action");
        obj1.addBook("Spring Boot in Action");
        obj1.addBook("Effective Java (2nd Edition)");

        Student obj2 = new Student();
        obj2.setName("zilap");
        obj2.addBook("Learning Python, 5th Edition");
        obj2.addBook("Effective Java (2nd Edition)");

        Student obj3 = new Student();
        obj3.setName("zilap");
        obj3.addBook("Learning Python, 5th Edition");
        obj3.addBook("Effective Java (2nd Edition)");

        
        List<Student> list = new ArrayList<>();
        list.add(obj1);
        list.add(obj2);
        list.add(obj3);
        
//        list.stream().map(x->x.get)
        list.stream().map(x->x).distinct().forEach(System.out::println);
        list.stream().distinct().collect(Collectors.toList()).forEach(System.out::println);
        
        System.out.println(list.stream().distinct().count());
       
        list.stream().map(s->s.getBook()).distinct().forEach(System.out::println);
        
        list.stream().map(s->s.getBook()).flatMap(b->b.stream()).distinct().forEach(System.out::println);
        
        //another way to get distinct books
        System.out.println("\n\nanother way to get distinct books\n\n");
        list.stream().flatMap(s->s.getBook().stream()).distinct().forEach(System.out::println);
        
        System.out.println("\n\nanother way to get distinct books\n\n");
        list.stream().map(s->s.getBook().stream()).distinct().forEach(System.out::println);
        // System.out.println(list);
    
        System.out.println("\n\nanother way to get distinct books and then apply filter\n\n");
        list.stream().flatMap(s->s.getBook().stream()).distinct().collect(Collectors.toList()).stream().filter(s->s.contains("Java")).forEach(System.out::println);

        System.out.println("\n\nanother way to get distinct books and then apply filter, findfirst  and find any \n\n");
       
       Optional<String> bookName =  list.stream().flatMap(s->s.getBook().stream()).distinct().collect(Collectors.toList()).stream()
        	.filter(s->s.contains("Java")).findAny();
        
       if (bookName.isPresent()) {
    	   System.out.println(bookName.get());
       }
       
       list.stream().flatMap(s->s.getBook().stream()).distinct().collect(Collectors.toList()).stream()
           	.filter(s->s.contains("Python")).findAny().ifPresent(System.out::println);
          
      
   	List<Book> bookList2 = new ArrayList<Book>();
	bookList2.add(new Book(2, "book 1", "Author1", 3.0));
	bookList2.add(new Book(5, "book 2", "Author2", 4.0));
	bookList2.add(new Book(6, "book 1", "Author1", 5.0));
	bookList2.add(new Book(7, "book 2", "Author2", 6.0));

	bookList2.stream().reduce(
								(b1,b2) -> b1.getRating().compareTo(b2.getRating()) <= 0 ? b1:b2)
							.ifPresent(b->System.out.println("low rating book is:" + b));
	
	
	String s = Arrays.stream(arr).flatMap(a->Arrays.stream(a)).reduce("", (s1,s2)->s1+s2);
	System.out.println(s);
	
	s = Arrays.stream(arr).flatMap( a->Arrays.stream(a)).reduce(new StringBuilder(), (sb,s1)->sb.append(s1), (sb1,sb2)->sb2.append(sb2)).toString();
	System.out.println(s);
	
	
	
       // stringList.stream().skip(1).limit(2).forEach(System.out::println);
        
      //play with collectons and hasmaps, lambdas, streams and maps.
	}
	
	public static void main(String[] arg) {
		// collectionI_ArrayList();
		// listI_ArrayList();

//		linkListTest();
		//arrayDequeTest();
//		priorityQueueTest();
//		hashSetTest();
//		linkedHashSetTest();
		
//		sortedSetTest();
		//navigableSetTest();
//		hashMapTest();
		testFunctionInterfaces();
		//testStreamMaps();
	}


}


