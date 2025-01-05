package br.com.richard.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.richard.model.Book;
import br.com.richard.services.BookServices;
import br.com.richard.util.CustomMediaType;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/book/v1")
public class BookController {
	
	@Autowired
	private BookServices service;
	
	@GetMapping(produces = CustomMediaType.APPLICATION_JSON)
	public List<Book> findAll(){
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}", produces = CustomMediaType.APPLICATION_JSON)
	public Book findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping(
		produces = CustomMediaType.APPLICATION_JSON,
		consumes =  CustomMediaType.APPLICATION_JSON
    )
	public Book create(@RequestBody Book book) {
		return service.create(book);
	}
	
	@PutMapping(
			produces = CustomMediaType.APPLICATION_JSON,
			consumes =  CustomMediaType.APPLICATION_JSON
			)
	public Book update(@RequestBody Book book) {
		return service.update(book);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}	
