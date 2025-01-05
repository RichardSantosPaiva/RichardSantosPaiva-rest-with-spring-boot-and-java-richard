package br.com.richard.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.richard.model.Book;
import br.com.richard.services.BookServices;
import br.com.richard.util.CustomMediaType;

@RestController
@RequestMapping("/api/book/v1")
public class BookController {
	
	@Autowired
	private BookServices service;
	
	@GetMapping(produces = CustomMediaType.APPLICATION_JSON)
	public List<Book> findAll(){
		return service.findAll();
	}
	
}	
