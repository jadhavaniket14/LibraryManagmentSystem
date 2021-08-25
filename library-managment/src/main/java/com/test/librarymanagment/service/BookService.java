package com.test.librarymanagment.service;

import java.util.List;
import java.util.Map.Entry;

import com.test.librarymanagment.model.Book;

public interface BookService {

	public Book addBook(Book book);
	
	public List<Book> getAllBooks();
	
	public List<Entry<Integer, Book>> getBookWithName(String bookName);
 }
