package com.ictexpertsgroup.practice;

import java.util.Objects;

public class Book implements Comparable<Book> {
	private Integer id;
	private String title;
	private String author;
	private Double rating;

	public Book(Integer id, String title, String author, Double rating) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", rating=" + rating + "]";
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}

	public static void printTopRatedBooks(Book pBook) {
		if (pBook.getRating()>=4) {
			System.out.println(pBook);
		}
	}
	
	@Override
	public int compareTo(Book obj) {
		//System.out.println(this.getRating().compareTo(obj.getRating()));
		return this.getRating().compareTo(obj.getRating());
	}

	@Override
	public int hashCode() {
		System.out.println("hasCode() invoked..");
		return Objects.hash(title,rating);
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
//		System.out.println("Book.equals is invoked");
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		Book b = (Book)obj;
//		System.out.println("This : " + this.toString());
//		System.out.println("obj : " + b.toString());
//		System.out.println(this.getId()==b.getId() && this.getTitle().equals(b.getTitle()) && this.getAuthor().equals(b.getTitle()));
//		return this.getId()==b.getId() && this.getTitle().equals(b.getTitle()) && this.getAuthor().equals(b.getTitle());
		//return this.toString().equals(b.toString());
		return this.getId().equals(b.getId()) && this.getTitle().equals(b.getTitle()) && this.getAuthor().equals(b.getAuthor()) && this.getRating().equals(b.getRating());
	}
}
