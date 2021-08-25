package com.test.librarymanagment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.test.librarymanagment.model.ApiErrorModel;
import com.test.librarymanagment.model.Book;
import com.test.librarymanagment.service.BookService;


@RestController
@RequestMapping(value = "/api/library-managment/v1/")
public class BookController {

	
	@Autowired
	BookService service;
	
	private Gson gson = new Gson();
	
	@PostMapping(value= "/addBook" , consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addBook( @RequestBody Book book) {
		Map<String,ApiErrorModel> error =new HashMap<>();
		try {
			service.addBook(book);
			return new ResponseEntity<>(gson.toJson(book), HttpStatus.CREATED);
		}catch(Exception e) {
			error.put("error", new ApiErrorModel(HttpStatus.INTERNAL_SERVER_ERROR.toString(),e.getMessage()));
			return new ResponseEntity<>(gson.toJson(error),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@GetMapping(value = "/getAllBooks" ,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getAllBooks() {
		Map<String,ApiErrorModel> error =new HashMap<>();
		try {
			List<Book> allBooks=service.getAllBooks();
			return new ResponseEntity<>(gson.toJson(allBooks), HttpStatus.CREATED);
		}catch(Exception e) {
			error.put("error", new ApiErrorModel(HttpStatus.INTERNAL_SERVER_ERROR.toString(),e.getMessage()));
			return new ResponseEntity<>(gson.toJson(error),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value = "/getBookWithName/{bookName}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getBookWithName(@RequestParam(value="bookName", required=true) String bookName ) {
		Map<String,ApiErrorModel> error =new HashMap<>();
		try {
			if(bookName ==null || bookName.isEmpty()) {
				error.put("error", new ApiErrorModel(HttpStatus.BAD_REQUEST.toString(), "please enter valid string to search the book"));
			}
			List<Entry<Integer, Book>> allBooks=service.getBookWithName(bookName);
			return new ResponseEntity<>(gson.toJson(allBooks), HttpStatus.CREATED);
		}catch(Exception e) {
			error.put("error", new ApiErrorModel(HttpStatus.INTERNAL_SERVER_ERROR.toString(),e.getMessage()));
			return new ResponseEntity<>(gson.toJson(error),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
