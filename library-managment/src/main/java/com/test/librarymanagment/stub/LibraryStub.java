package com.test.librarymanagment.stub;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.test.librarymanagment.model.Book;

public class LibraryStub {

	private static Map<Integer,Book> bookData = new ConcurrentHashMap<>();
	
	public static Map<Integer,Book> getBooks(){
		return bookData;
	}
}
