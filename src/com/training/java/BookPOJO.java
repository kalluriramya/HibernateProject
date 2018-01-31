package com.training.java;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK")
public class BookPOJO {
	private int bookId;
	private String bookName;
	private PublisherPOJO publisher;

	public BookPOJO() 
	{ 
	} 
	public BookPOJO(String name) 
	{
	this.bookName = name;
	}
	public BookPOJO(String name, PublisherPOJO publisher) 
	{
	this.bookName = name;
	this.publisher = publisher;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "book_ID")
	public int getBookId() 
	{
		return bookId;
	}
	public void setBookId(int bookId) 
	{
		this.bookId = bookId;
	}
	
	@Column(name = "book_name")
	public String getBookName() 
	{
		return bookName;
	}
	public void setBookName(String bookName) 
	{
		this.bookName = bookName;
	}
	
	@ManyToOne(cascade = CascadeType.ALL) 
	@JoinColumn(name = "PUB_ID")
	public PublisherPOJO getPublisher() 
	{
		return publisher;
	}
	public void setPublisher(PublisherPOJO publisher) 
	{
		this.publisher = publisher;
	}
}
