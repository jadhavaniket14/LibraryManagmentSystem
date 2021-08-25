package com.test.librarymanagment.service.impl;

import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.librarymanagment.dao.BookDao;
import com.test.librarymanagment.model.Book;
import com.test.librarymanagment.service.BookService;

@Service
public class BookServiceImpl  implements BookService{

	@Autowired
	BookDao dao;
	
	@Override
	public Book addBook(Book book) {
		dao.addBook(book);
		return book;
	}

	@Override
	public List<Book> getAllBooks() {
		return dao.getAllBooks();
	}

	@Override
	public List<Entry<Integer, Book>> getBookWithName(String bookName) {
		return dao.getBookWithName(bookName);
	}

}
