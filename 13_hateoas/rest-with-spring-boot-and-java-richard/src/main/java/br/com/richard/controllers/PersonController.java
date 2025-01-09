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

import br.com.richard.data.vo.v1.PersonVO;
import br.com.richard.services.PersonServices;
import br.com.richard.util.CustomMediaType;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {	
	
	@Autowired
	private PersonServices service;
	
	@GetMapping(
		produces = {CustomMediaType.APPLICATION_JSON,
					CustomMediaType.APPLICATION_XML,
				"application/x-yaml"
				})
	public List<PersonVO> findAll(){
		return service.findAll();
	}
	
	@GetMapping(value ="/{id}",
		produces = {CustomMediaType.APPLICATION_JSON, CustomMediaType.APPLICATION_XML,
				"application/x-yaml"})
	public PersonVO findById(@PathVariable Long id){
		return service.findById(id);
	}

	@PostMapping(
		consumes = {CustomMediaType.APPLICATION_JSON, CustomMediaType.APPLICATION_XML,
				"application/x-yaml"},
		produces = {CustomMediaType.APPLICATION_JSON, CustomMediaType.APPLICATION_XML,
				"application/x-yaml"})
	public PersonVO create(@RequestBody PersonVO person){
		return service.create(person);
	}
	
	@PutMapping(
		consumes = {CustomMediaType.APPLICATION_JSON, CustomMediaType.APPLICATION_XML,
				"application/x-yaml"},
		produces = {CustomMediaType.APPLICATION_JSON, CustomMediaType.APPLICATION_XML,	
				"application/x-yaml"})
	public PersonVO update(@RequestBody PersonVO person){
		return service.update(person);
	}
	
	@DeleteMapping(value ="/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
