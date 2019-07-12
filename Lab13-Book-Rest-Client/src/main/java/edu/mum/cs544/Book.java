package edu.mum.cs544;


import java.util.Date;

public class Book {
	private int id;
	private String title;
	private String ISBN;
	private String author;
	private double price;
	private Date publishedDate;

	public Book() {
	}

	public Book(int id, String title, String ISBN, String author, double price, Date publishedDate) {
		this.id = id;
		this.title = title;
		this.ISBN = ISBN;
		this.author = author;
		this.price = price;
		this.publishedDate = publishedDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	@Override
	public String toString() {
		return "Book{" +
				"id=" + id +
				", title='" + title + '\'' +
				", ISBN='" + ISBN + '\'' +
				", author='" + author + '\'' +
				", price=" + price +
				", publishedDate=" + publishedDate +
				'}';
	}
}
