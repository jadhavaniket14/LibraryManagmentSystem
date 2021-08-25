package com.test.librarymanagment.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.test.librarymanagment.dao.BookDao;
import com.test.librarymanagment.model.Book;
import com.test.librarymanagment.stub.LibraryStub;

@Repository
public class BookDaoImpl implements BookDao{

	private static Map<Integer,Book> bookData = LibraryStub.getBooks();
	
	@Override
	public Book addBook(Book book) {
		bookData.put(bookData.size()+1, book);
		return book;
	}

	@Override
	public List<Book> getAllBooks() {
		return new ArrayList<>(bookData.values());
	}

	@Override
	public List<Entry<Integer, Book>> getBookWithName(String bookName) {
		List<Entry<Integer, Book>>  bookList = bookData.entrySet().stream().filter(val -> val.getValue().getName().contains(bookName)).collect(Collectors.toList());
		return bookList;
	}

}
