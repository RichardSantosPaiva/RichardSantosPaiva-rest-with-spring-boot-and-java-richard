package br.com.richard.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.richard.data.vo.v1.BookVO;
import br.com.richard.services.BookServices;
import br.com.richard.util.CustomMediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/book/v1")
@Tag(name = "Book", description = "Endpoints for Managing Book")
public class BookController {	
	
	@Autowired
	private BookServices service;
	
	@GetMapping(
		produces = {CustomMediaType.APPLICATION_JSON,CustomMediaType.APPLICATION_XML,"application/x-yaml"})
	@Operation(summary = "Finds all books", description = "Finds all books",
		tags = {"Book"},
		responses = {
			@ApiResponse(description =  "Success", responseCode = "200", 
				content = {
					@Content(
						mediaType = "application/json",
						array =  @ArraySchema(schema = @Schema(implementation = BookVO.class))
					)
				}),
			@ApiResponse(description =  "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description =  "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description =  "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description =  "Internal Error", responseCode = "500", content = @Content),
		}
	)
	public List<BookVO> findAll(){
		return service.findAll();
	}
	
	@GetMapping(value ="/{id}",
		produces = {CustomMediaType.APPLICATION_JSON, CustomMediaType.APPLICATION_XML,
				"application/x-yaml"})
	@Operation(summary = "Finds a Book", description = "Finds a Book",
		tags = {"Book"},
		responses = {
			@ApiResponse(description =  "Success", responseCode = "200", 
				content = 
					@Content(schema = @Schema(implementation = BookVO.class))
			),
			@ApiResponse(description =  "No Content", responseCode = "204", content = @Content),
			@ApiResponse(description =  "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description =  "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description =  "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description =  "Internal Error", responseCode = "500", content = @Content),
		}
	)
	
	public BookVO findById(@PathVariable Long id){
		return service.findById(id);
	}

	@PostMapping(
		consumes = {CustomMediaType.APPLICATION_JSON, CustomMediaType.APPLICATION_XML,"application/x-yaml"},
		produces = {CustomMediaType.APPLICATION_JSON, CustomMediaType.APPLICATION_XML,	"application/x-yaml"})
	@Operation(summary = "Adds a new Book",
		description = "Adds a new Book by passing in a JSON, XML or YML representantion of the book",
		tags = {"Book"},
		responses = {
			@ApiResponse(description =  "Success", responseCode = "200", 
				content = 
					@Content(schema = @Schema(implementation = BookVO.class))
			),
			@ApiResponse(description =  "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description =  "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description =  "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description =  "Internal Error", responseCode = "500", content = @Content),
		}
	)
	public BookVO create(@RequestBody BookVO book){
		return service.create(book);
	}
	
	@PutMapping(
		consumes = {CustomMediaType.APPLICATION_JSON, CustomMediaType.APPLICATION_XML,	"application/x-yaml"},
		produces = {CustomMediaType.APPLICATION_JSON, CustomMediaType.APPLICATION_XML,		"application/x-yaml"})
	@Operation(summary = "Updates a Book",
		description = "Updates a  Book by passing in a JSON, XML or YML representantion of the book",
		tags = {"Book"},
		responses = {
			@ApiResponse(description =  "Updated", responseCode = "200", 
				content = 
					@Content(schema = @Schema(implementation = BookVO.class))
			),
			@ApiResponse(description =  "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description =  "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description =  "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description =  "Internal Error", responseCode = "500", content = @Content),
		}
	)
	public BookVO update(@RequestBody BookVO book){
		return service.update(book);
	}
	
	@DeleteMapping(value ="/{id}")
	@Operation(summary = "Deletes a Book",
		description = "Deleted a  Book by passing in a JSON, XML or YML representantion of the book",
		tags = {"Book"},
		responses = {
			@ApiResponse(description =  "No content", responseCode = "204", content = @Content),
			@ApiResponse(description =  "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description =  "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description =  "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description =  "Internal Error", responseCode = "500", content = @Content),
		}
	)
	public ResponseEntity<?> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
